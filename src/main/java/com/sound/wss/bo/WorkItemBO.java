package com.sound.wss.bo;

import java.util.List;

import com.sound.wss.po.TaskItemDO;

public class WorkItemBO extends WorkItemSimpleBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5050370831488784420L;

	private List<TaskItemDO> taskItemDOList;

	public List<TaskItemDO> getTaskItemDOList() {
		return taskItemDOList;
	}

	public void setTaskItemDOList(List<TaskItemDO> taskItemDOList) {
		this.taskItemDOList = taskItemDOList;
	}

	@Override
	public String toString() {
		return "WorkItemBO [taskItemDOList=" + taskItemDOList + ", toString()=" + super.toString() + "]";
	}

}
