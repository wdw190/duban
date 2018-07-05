package com.sound.wss.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.bo.WorkItemSimpleBO;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.po.DueTaskDO;
import com.sound.wss.po.SupervisionInfoDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkTaskActionDO;
import com.sound.wss.po.WorkViewDO;

@Mapper
public interface TaskItemMapper {
	/**
	 * 新增任务项
	 * 
	 * @param taskItemDO
	 * @return
	 */
	public int insertTaskItem(TaskItemDO taskItemDO);

	/**
	 * 列出我的代办任务
	 * 
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public java.util.List<TaskItemDO> listMyTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 已完成任务列表
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public java.util.List<TaskItemDO> listMyDoneTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	
	/**
	 * 沟通中的任务
	 * @param myTaskCriteriaDTO
	 * @return
	 */
	public java.util.List<TaskActionCombineBO> listMyProcessingTask(MyTaskCriteriaDTO myTaskCriteriaDTO);
	/**
	 * 查询任务最新的操作记录
	 * @param taskId
	 * @return
	 */
	public TaskActionCombineBO queryLatestTaskItemActionRecord(String taskId);

	/**
	 * 查询任务详情
	 */
	public TaskItemDetailsBO viewSingleTaskItemInfo(String taskId);
	
	public List<WorkTaskActionDO> listWorkTaskActionDO(String workOrTaskId);
	
	public WorkItemSimpleBO queryWorkItemSimpleBO(String workId);
	
	/**
	 * 跟新任务状态
	 */
	
	public int updateTaskItemStatusByTaskID(TaskItemDO taskItemDO);
	/**
	 * 取消任务
	 * @param taskItemDO
	 * @return
	 */
	public int  cancelTaskItemStatusByTaskID(TaskItemDO taskItemDO);
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
	

}
