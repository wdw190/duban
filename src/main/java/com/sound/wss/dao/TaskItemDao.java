package com.sound.wss.dao;

import java.util.List;

import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.po.DueTaskDO;
import com.sound.wss.po.SupervisionInfoDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WeChatPersonInfoDO;
import com.sound.wss.po.WorkViewDO;

public interface TaskItemDao {
	/**
	 * 新增任务项
	 * @param taskItemDO
	 * @return
	 */
	public int insertTaskItem(TaskItemDO taskItemDO);
	/**
	 * 查询我的代办
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	
	public java.util.List<TaskItemDO> listMyTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 查询已处理完成的任务
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public java.util.List<TaskItemDO> listMyDoneTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	
	/**
	 * 沟通中的代办任务
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public java.util.List<TaskActionCombineBO> listMyProcessingTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 查询任务最新的沟通记录
	 * @param taskId
	 * @return
	 */
	public TaskActionCombineBO queryLatestTaskItemActionRecord(String taskId);
	/**
	 * 查询任务详情
	 * @param taskId
	 * @return
	 */
	public TaskItemDetailsBO viewSingleTaskItemInfo(String taskId);
	
	/**
	 * 根据任务编号更新任务状态
	 * @param taskItemDO
	 * @return
	 */
	public int updateTaskItemStatusByTaskID(TaskItemDO taskItemDO);
	/**
	 * 任务完成
	 * @param taskItemDO
	 * @return
	 */
	public int completeTaskItemByTaskID(TaskItemDO taskItemDO);
	
	/**
	 * 编辑保存
	 * @param taskItemDO
	 * @return
	 */
	public int updateTaskItemDoByTaskID(TaskItemDO taskItemDO);
	
	/**
	 * 取消任务项
	 * @param taskItemDO
	 * @return
	 */
	public int  cancelTaskItemStatusByTaskID(TaskItemDO taskItemDO);
	
	/**
	 * 催办提醒
	 * @param assignee
	 * @return
	 */
	public List<SupervisionInfoDO> listAllSupervisionInfos(String assignee);
	
	/**
	 * 逾期提醒
	 * @param assignee
	 * @return
	 */
	public DueTaskDO listDueTaskInfos(String assignee);
	
	/**
	 * 工作总览
	 * @param assignee
	 * @return
	 */
	public WorkViewDO listAllWorkViewInfos(String assignee);
	
	
	/**
	 * 查询微信ID
	 * @param taskId
	 * @return
	 */
	public WeChatPersonInfoDO viewWeChatPersonInfo(String taskId);

}
