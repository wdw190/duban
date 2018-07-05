package com.sound.wss.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sound.exception.WSSException;
import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.dao.WorkItemDao;
import com.sound.wss.dao.WorkTaskActionDao;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkTaskActionDO;
import com.sound.wss.service.WorkTaskActionService;
import com.sound.wss.storage.StorageService;
import com.sound.wss.utils.WSSUtils;

@Service("defaultWorkTaskActionService")
public class DefaultWorkTaskActionService implements WorkTaskActionService {

	private static Logger logger = LogManager.getLogger(DefaultWorkTaskActionService.class);

	private WorkTaskActionDao workTaskActionDao;

	private WorkItemDao workItemDao;

	private TaskItemDao taskItemDao;

	@Autowired
	private ApplicationContext appContext;

	@Override
	@Transactional
	public ActionResultDTO addCommContent(WorkTaskActionDO workTaskActionDO, MultipartFile[] files,
			HttpServletRequest request) throws WSSException {
		ActionResultDTO actionResultDTO = new ActionResultDTO();
		// 获取当前登录用户名
		HttpSession session = request.getSession(true);
		// 设置参数内容
		workTaskActionDO.setId(UUID.randomUUID().toString());
		workTaskActionDO.setAuthor(session.getAttribute("currentusername").toString());
		workTaskActionDO.setCreated(WSSUtils.getCurrentTime());
		workTaskActionDO.setUpdateAuthor(session.getAttribute("currentusername").toString());
		workTaskActionDO.setUpdated(WSSUtils.getCurrentTime());

		try {

			// 处理审批操作
			if (workTaskActionDO.getActionType().equalsIgnoreCase("approval")) {
				approvalTask(workTaskActionDO);
			} else {

				//非审批操作
				TaskItemDO taskItemDO = new TaskItemDO();

				taskItemDO.setTaskId(workTaskActionDO.getWorkOrTaskId());
				taskItemDO.setTaskStatus(workTaskActionDO.getActionType());

				this.taskItemDao.updateTaskItemStatusByTaskID(taskItemDO);
			}
			//插入操作内容
			this.workTaskActionDao.insertWorkTaskAction(workTaskActionDO);

			// 上传附件
			// 获取操作文件的BEAN
			StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

			// 创建对应的文件目录
			storageService.init(new StringBuilder().append(WSSUtils.getRealPath(request)).append("/uploadfiles/")
					.append(workTaskActionDO.getId()).toString());

			List<FileAttachmentDO> fileAttachmentDOList = new ArrayList<FileAttachmentDO>();

			// 文件上传
			for (MultipartFile file : files) {

				if (!file.isEmpty()) {
					FileAttachmentDO fileAttachmentDO = new FileAttachmentDO();

					storageService.store(file);

					fileAttachmentDO.setId(UUID.randomUUID().toString());
					fileAttachmentDO.setWorkOrTaskId(workTaskActionDO.getId());// 沟通记录上传的附件挂在这次沟通记录的下面
					fileAttachmentDO.setMimetype(file.getContentType());
					fileAttachmentDO.setFilename(file.getOriginalFilename());
					fileAttachmentDO.setCreated(workTaskActionDO.getCreated());
					fileAttachmentDO.setFilesize(file.getSize());
					fileAttachmentDO.setAuthor(workTaskActionDO.getAuthor());
					fileAttachmentDO.setPath(new StringBuilder().append(WSSUtils.getContextPath(request))
							.append("/uploadfiles/").append(workTaskActionDO.getId()).append("/")
							.append(file.getOriginalFilename()).toString());

					fileAttachmentDO.setDownloadPath(new StringBuilder().append(WSSUtils.getContextPath(request))
							.append("/filedownload/").append(workTaskActionDO.getId()).append("/")
							.append(file.getOriginalFilename()).toString());

					fileAttachmentDOList.add(fileAttachmentDO);
				}

			}
			// 批量保存文件信息

			if (fileAttachmentDOList != null && fileAttachmentDOList.size() > 0) {
				this.workItemDao.insertFileAttachment(fileAttachmentDOList);
			}

			actionResultDTO.setFlag("success");
		} catch (Exception e) {

			logger.error("----------------------------------错误发生-----------------------------------------");
			logger.error("发生时间：" + WSSUtils.getCurrentTime());
			logger.error("添加工作项：" + workTaskActionDO.toString());
			logger.error("错误信息:" + e.getMessage());
			logger.error("---------------------------------------------------------------------------");

			throw new WSSException(e.getMessage());
		}

		return actionResultDTO;
	}

	/**
	 * 审批
	 */

	@Override
	public void approvalTask(WorkTaskActionDO workTaskActionDO) throws WSSException {

		TaskActionCombineBO taskActionCombineBO = this.taskItemDao.queryLatestTaskItemActionRecord(workTaskActionDO.getWorkOrTaskId());
		// 处理申请完成时候的审批
		if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforcompleted")) {
			
			workTaskActionDO.setActionType("applyforcompleted_approval");

			TaskItemDO taskItemDO = new TaskItemDO();

			taskItemDO.setTaskId(taskActionCombineBO.getTaskId());
			taskItemDO.setTaskStatus("approval");
			taskItemDO.setTaskResolution("done");
			taskItemDO.setTaskResolutiondate(taskActionCombineBO.getCreated());

			try {
				this.taskItemDao.completeTaskItemByTaskID(taskItemDO);
			} catch (Exception e) {
				throw new WSSException(e.getMessage());
			}
		} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforadjustment")) {
			
			workTaskActionDO.setActionType("applyforadjustment_approval");

			TaskItemDO taskItemDO = new TaskItemDO();

			taskItemDO.setTaskId(taskActionCombineBO.getTaskId());
			taskItemDO.setTaskStatus("completechanges");

			try {
				this.taskItemDao.updateTaskItemStatusByTaskID(taskItemDO);
			} catch (Exception e) {
				throw new WSSException(e.getMessage());
			}
		}

	}

	public WorkTaskActionDao getWorkTaskActionDao() {
		return workTaskActionDao;
	}

	@Autowired
	@Required
	public void setWorkTaskActionDao(@Qualifier("defaultWorkTaskActionDao") WorkTaskActionDao workTaskActionDao) {
		this.workTaskActionDao = workTaskActionDao;
	}

	public WorkItemDao getWorkItemDao() {
		return workItemDao;
	}

	@Autowired
	@Required
	public void setWorkItemDao(@Qualifier("defaultWorkItemDao") WorkItemDao workItemDao) {
		this.workItemDao = workItemDao;
	}

	public TaskItemDao getTaskItemDao() {
		return taskItemDao;
	}

	@Autowired
	@Required
	public void setTaskItemDao(@Qualifier("defaultTaskItemDao") TaskItemDao taskItemDao) {
		this.taskItemDao = taskItemDao;
	}

}
