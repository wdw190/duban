package com.sound.wss.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
import com.sound.wss.bo.WorkItemBO;
import com.sound.wss.bo.WorkItemResultBO;
import com.sound.wss.dao.WorkItemDao;
import com.sound.wss.dao.WorkTaskActionDao;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.WorkItemDO;
import com.sound.wss.po.WorkTaskActionDO;
import com.sound.wss.service.WorkItemService;
import com.sound.wss.storage.StorageService;
import com.sound.wss.utils.WSSUtils;

@Service("defaultWorkItemService")
public class DefaultWorkItemService implements WorkItemService {

	private static Logger logger = LogManager.getLogger(DefaultWorkItemService.class);

	private WorkItemDao workItemDao;

	private WorkTaskActionDao workTaskActionDao;

	@Autowired
	private ApplicationContext appContext;

	@Override
	public WorkItemDO initWorkItemDO(String parameter) {

		WorkItemDO workItemDO = new WorkItemDO();

		int nextNum = this.workItemDao.queryNumbering(parameter).getNumber() + 1;

		workItemDO.setWorkId(new StringBuilder().append(parameter).append(String.format("%04d", nextNum)).toString());

		workItemDO.setCreated(WSSUtils.getCurrentTime());

		return workItemDO;
	}

	@Override
	@Transactional
	public ActionResultDTO saveWorkItem(WorkItemDO workItemDO, MultipartFile[] files, HttpServletRequest request)
			throws WSSException {
		ActionResultDTO actionResultDTO = new ActionResultDTO();

		try {
			// 插入工作项
			this.workItemDao.insertWorkItem(workItemDO);
			// 插入操作记录
			WorkTaskActionDO workTaskActionDO = new WorkTaskActionDO();
			workTaskActionDO.setId(UUID.randomUUID().toString());
			workTaskActionDO.setWorkOrTaskId(workItemDO.getWorkId());
			workTaskActionDO.setActionType("new");
			workTaskActionDO.setActionBody("新建");
			workTaskActionDO.setAuthor(workItemDO.getReporter());
			workTaskActionDO.setCreated(workItemDO.getCreated());
			workTaskActionDO.setUpdateAuthor(workItemDO.getReporter());
			workTaskActionDO.setUpdated(workItemDO.getCreated());

			this.workTaskActionDao.insertWorkTaskAction(workTaskActionDO);

			// 上传附件
			// 获取操作文件的BEAN
			StorageService storageService = (StorageService) appContext.getBean("fileSystemStorageService");

			// 创建对应的文件目录
			storageService.init(new StringBuilder().append(WSSUtils.getRealPath(request)).append("/uploadfiles/")
					.append(workItemDO.getWorkId()).toString());

			List<FileAttachmentDO> fileAttachmentDOList = new ArrayList<FileAttachmentDO>();

			// 文件上传
			for (MultipartFile file : files) {

				if (!file.isEmpty()) {
					FileAttachmentDO fileAttachmentDO = new FileAttachmentDO();

					storageService.store(file);

					fileAttachmentDO.setId(UUID.randomUUID().toString());
					fileAttachmentDO.setWorkOrTaskId(workItemDO.getWorkId());
					fileAttachmentDO.setMimetype(file.getContentType());
					fileAttachmentDO.setFilename(file.getOriginalFilename());
					fileAttachmentDO.setCreated(workItemDO.getCreated());
					fileAttachmentDO.setFilesize(file.getSize());
					fileAttachmentDO.setAuthor(workItemDO.getReporter());
					fileAttachmentDO.setPath(new StringBuilder().append(WSSUtils.getRealPath(request))
							.append("/uploadfiles/").append(workItemDO.getWorkId()).append("/")
							.append(file.getOriginalFilename()).toString());

					fileAttachmentDO.setDownloadPath(new StringBuilder().append(WSSUtils.getContextPath(request))
							.append("/filedownload/").append(workItemDO.getWorkId()).append("/")
							.append(file.getOriginalFilename()).toString());

					fileAttachmentDOList.add(fileAttachmentDO);
				}

			}
			// 批量保存文件信息

			if (fileAttachmentDOList != null && fileAttachmentDOList.size() > 0) {
				this.workItemDao.insertFileAttachment(fileAttachmentDOList);
			}

			actionResultDTO.setFlag("success");
			actionResultDTO.setMsg("successfull");

		} catch (Exception e) {

			logger.error("----------------------------------错误发生-----------------------------------------");
			logger.error("发生时间：" + WSSUtils.getCurrentTime());
			logger.error("添加工作项：" + workItemDO.toString());
			logger.error("错误信息:" + e.getMessage());
			logger.error("---------------------------------------------------------------------------");

			throw new WSSException(e.getMessage());

		}

		return actionResultDTO;
	}

	@Override
	public WorkItemResultBO listWorkItem(WorkItemCriteriaDTO workItemCriteriaDTO) {
		WorkItemResultBO workItemResultBO = new WorkItemResultBO();

		try {
			List<WorkItemDO> workItemDOList = this.workItemDao.listWorkItem(workItemCriteriaDTO);

			if (workItemDOList != null && workItemDOList.size() > 0) {
				workItemResultBO.setFlag("success");
				workItemResultBO.setWorkItemDOList(workItemDOList);
			} else {
				workItemResultBO.setFlag("none");

			}

		} catch (Exception e) {
			workItemResultBO.setFlag("failed");
			workItemResultBO.setMsg(e.getMessage());

		}
		return workItemResultBO;
	}

	@Override
	public WorkItemResultBO updateWorkItem(WorkItemDO workItemDO) {

		WorkItemResultBO workItemResultBO = new WorkItemResultBO();

		try {
			this.workItemDao.updateWorkItem(workItemDO);

			// 插入操作记录
			WorkTaskActionDO workTaskActionDO = new WorkTaskActionDO();
			workTaskActionDO.setId(UUID.randomUUID().toString());
			workTaskActionDO.setWorkOrTaskId(workItemDO.getWorkId());
			workTaskActionDO.setActionType("update");
			workTaskActionDO.setActionBody("修改");
			workTaskActionDO.setAuthor(workItemDO.getReporter());
			workTaskActionDO.setCreated(WSSUtils.getCurrentTime());
			workTaskActionDO.setUpdateAuthor(workItemDO.getReporter());
			workTaskActionDO.setUpdated(WSSUtils.getCurrentTime());

			workItemResultBO.setFlag("success");

		} catch (Exception e) {
			workItemResultBO.setFlag("failed");
			workItemResultBO.setMsg(e.getMessage());
		}

		return workItemResultBO;
	}

	@Override
	public WorkItemBO singleWorkItemInfo(String workId) {

		return this.workItemDao.singleWorkItemInfo(workId);
	}

	public WorkItemDao getWorkItemDao() {
		return workItemDao;
	}

	@Autowired
	@Required
	public void setWorkItemDao(@Qualifier("defaultWorkItemDao") WorkItemDao workItemDao) {
		this.workItemDao = workItemDao;
	}

	public WorkTaskActionDao getWorkTaskActionDao() {
		return workTaskActionDao;
	}

	@Autowired
	@Required
	public void setWorkTaskActionDao(@Qualifier("defaultWorkTaskActionDao") WorkTaskActionDao workTaskActionDao) {
		this.workTaskActionDao = workTaskActionDao;
	}

}
