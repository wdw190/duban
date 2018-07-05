package com.sound.wss.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.exception.WSSException;
import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.dao.WorkItemDao;
import com.sound.wss.dao.WorkTaskActionDao;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.po.NumberingDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkTaskActionDO;
import com.sound.wss.service.TaskItemService;
import com.sound.wss.utils.WSSUtils;

@Service("defaultTaskItemService")
public class DefaultTaskItemService implements TaskItemService {

	private WorkItemDao workItemDao;

	private TaskItemDao taskItemDao;

	private WorkTaskActionDao workTaskActionDao;

	@Override
	public TaskItemDO initTaskItemDO(String parameter) {
		TaskItemDO taskItemDO = new TaskItemDO();

		NumberingDO numberingDO = this.workItemDao.queryTaskItemNumbering(parameter);

		taskItemDO.setWorkTaskNum((numberingDO.getNumber() + 1) * 10);
		taskItemDO.setTaskCreated(WSSUtils.getCurrentTime());

		return taskItemDO;
	}

	@Override
	@Transactional
	public ActionResultDTO insertTaskItemDO(TaskItemDO taskItemDO) throws WSSException {

		ActionResultDTO actionResultDTO = new ActionResultDTO();

		try {

			taskItemDO.setTaskId(UUID.randomUUID().toString());
			taskItemDO.setTaskUpdated(taskItemDO.getTaskCreated());

			this.taskItemDao.insertTaskItem(taskItemDO);

			// 插入操作内容
			WorkTaskActionDO workTaskActionDO = new WorkTaskActionDO();
			workTaskActionDO.setId(UUID.randomUUID().toString());
			workTaskActionDO.setWorkOrTaskId(taskItemDO.getTaskId());
			workTaskActionDO.setActionType("new");
			workTaskActionDO.setActionBody("新建");
			workTaskActionDO.setAuthor(taskItemDO.getReporter());
			workTaskActionDO.setCreated(taskItemDO.getTaskCreated());
			workTaskActionDO.setUpdateAuthor(taskItemDO.getReporter());
			workTaskActionDO.setUpdated(taskItemDO.getTaskCreated());

			this.workTaskActionDao.insertWorkTaskAction(workTaskActionDO);

			actionResultDTO.setFlag("success");
		} catch (Exception e) {
			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
			throw new WSSException(e.getMessage());

		}

		return actionResultDTO;
	}

	@Override
	public WorkTaskResultBO<TaskItemDO> listMyTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {

		WorkTaskResultBO<TaskItemDO> workTaskResultBO = new WorkTaskResultBO<TaskItemDO>();

		try {
			List<TaskItemDO> taskItemDOList = this.taskItemDao.listMyTask(myTaskCriteriaDTO);

			if (taskItemDOList != null && taskItemDOList.size() > 0) {
				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(taskItemDOList);

			} else {
				workTaskResultBO.setFlag("none");
			}

		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;
	}

	@Override
	public WorkTaskResultBO<TaskItemDO> listMyDoneTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {
		WorkTaskResultBO<TaskItemDO> workTaskResultBO = new WorkTaskResultBO<TaskItemDO>();

		try {
			List<TaskItemDO> taskItemDOList = this.taskItemDao.listMyDoneTask(myTaskCriteriaDTO);

			if (taskItemDOList != null && taskItemDOList.size() > 0) {
				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(taskItemDOList);

			} else {
				workTaskResultBO.setFlag("none");
			}

		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;

	}

	@Override
	public WorkTaskResultBO<TaskActionCombineBO> listMyProcessingTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {
		WorkTaskResultBO<TaskActionCombineBO> workTaskResultBO = new WorkTaskResultBO<TaskActionCombineBO>();

		try {
			List<TaskActionCombineBO> taskActionCombineBOList = this.taskItemDao
					.listMyProcessingTask(myTaskCriteriaDTO);

			if (taskActionCombineBOList != null && taskActionCombineBOList.size() > 0) {
				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(taskActionCombineBOList);

			} else {
				workTaskResultBO.setFlag("none");
			}

		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;
	}

	@Override
	@Transactional
	public ActionResultDTO updateTaskItemDoByTaskID(TaskItemDO taskItemDO) {
		ActionResultDTO actionResultDTO = new ActionResultDTO();

		try {
			this.taskItemDao.updateTaskItemDoByTaskID(taskItemDO);

			// 插入操作内容
			WorkTaskActionDO workTaskActionDO = new WorkTaskActionDO();
			workTaskActionDO.setId(UUID.randomUUID().toString());
			workTaskActionDO.setWorkOrTaskId(taskItemDO.getTaskId());
			workTaskActionDO.setActionType("update");
			workTaskActionDO.setActionBody("编辑修改");
			workTaskActionDO.setAuthor(taskItemDO.getReporter());
			workTaskActionDO.setCreated(WSSUtils.getCurrentTime());
			workTaskActionDO.setUpdateAuthor(taskItemDO.getReporter());
			workTaskActionDO.setUpdated(WSSUtils.getCurrentTime());

			this.workTaskActionDao.insertWorkTaskAction(workTaskActionDO);

			actionResultDTO.setFlag("success");
		} catch (Exception e) {
			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
		}

		return actionResultDTO;
	}

	@Override
	public TaskItemDetailsBO viewSingleTaskItemInfo(String taskId) {

		return this.taskItemDao.viewSingleTaskItemInfo(taskId);
	}

	@Override
	public ActionResultDTO cancelTaskItemDoByTaskID(TaskItemDO taskItemDO) {

		ActionResultDTO actionResultDTO = new ActionResultDTO();

		try {
			this.taskItemDao.cancelTaskItemStatusByTaskID(taskItemDO);

			// 插入操作内容
			WorkTaskActionDO workTaskActionDO = new WorkTaskActionDO();
			workTaskActionDO.setId(UUID.randomUUID().toString());
			workTaskActionDO.setWorkOrTaskId(taskItemDO.getTaskId());
			workTaskActionDO.setActionType("cancel");
			workTaskActionDO.setActionBody("任务取消");
			workTaskActionDO.setAuthor(taskItemDO.getReporter());
			workTaskActionDO.setCreated(WSSUtils.getCurrentTime());
			workTaskActionDO.setUpdateAuthor(taskItemDO.getReporter());
			workTaskActionDO.setUpdated(WSSUtils.getCurrentTime());

			this.workTaskActionDao.insertWorkTaskAction(workTaskActionDO);

			actionResultDTO.setFlag("success");

		} catch (Exception e) {

			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
		}

		return actionResultDTO;
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

	public WorkTaskActionDao getWorkTaskActionDao() {
		return workTaskActionDao;
	}

	@Autowired
	@Required
	public void setWorkTaskActionDao(@Qualifier("defaultWorkTaskActionDao") WorkTaskActionDao workTaskActionDao) {
		this.workTaskActionDao = workTaskActionDao;
	}

}
