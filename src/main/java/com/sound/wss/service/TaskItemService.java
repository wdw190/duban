package com.sound.wss.service;

import com.sound.exception.WSSException;
import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.po.TaskItemDO;

public interface TaskItemService {

	/**
	 * 初始化任务项
	 * 
	 * @param parameter
	 * @return
	 */
	public TaskItemDO initTaskItemDO(String parameter);

	/**
	 * 插入任务项
	 * 
	 * @param taskItemDO
	 * @return
	 */

	public ActionResultDTO insertTaskItemDO(TaskItemDO taskItemDO) throws WSSException;

	/**
	 * 承办人的代处理任务列表
	 * 
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public WorkTaskResultBO<TaskItemDO> listMyTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 承办人已完成处理任务列表
	 * 
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public WorkTaskResultBO<TaskItemDO> listMyDoneTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 承办人的处理中的代办
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public WorkTaskResultBO<TaskActionCombineBO> listMyProcessingTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 查询任务详情
	 * @param taskId
	 * @return
	 */
	public TaskItemDetailsBO viewSingleTaskItemInfo(String taskId);
	
	/**
	 * 编辑保存任务项
	 * @param taskItemDO
	 * @return
	 */
	public ActionResultDTO updateTaskItemDoByTaskID(TaskItemDO taskItemDO);
	
	/**
	 * 取消任务项
	 * @param taskItemDO
	 * @return
	 */
	public ActionResultDTO cancelTaskItemDoByTaskID(TaskItemDO taskItemDO);

}
