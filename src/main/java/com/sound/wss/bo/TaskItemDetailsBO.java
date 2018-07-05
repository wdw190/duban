package com.sound.wss.bo;

import java.util.List;

import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkItemDO;
import com.sound.wss.po.WorkTaskActionDO;

public class TaskItemDetailsBO extends TaskItemDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6690890808387901716L;

	private WorkItemSimpleBO workItemSimpleBO;

	private List<WorkTaskActionDO> workTaskActionDOList;

	public WorkItemSimpleBO getWorkItemSimpleBO() {
		return workItemSimpleBO;
	}

	public void setWorkItemSimpleBO(WorkItemSimpleBO workItemSimpleBO) {
		this.workItemSimpleBO = workItemSimpleBO;
	}

	public List<WorkTaskActionDO> getWorkTaskActionDOList() {
		return workTaskActionDOList;
	}

	public void setWorkTaskActionDOList(List<WorkTaskActionDO> workTaskActionDOList) {
		this.workTaskActionDOList = workTaskActionDOList;
	}

	@Override
	public String toString() {
		return "TaskItemDetailsBO [workItemSimpleBO=" + workItemSimpleBO + ", workTaskActionDOList="
				+ workTaskActionDOList + ", toString()=" + super.toString() + "]";
	}

	

}
