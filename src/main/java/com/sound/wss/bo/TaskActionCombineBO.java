package com.sound.wss.bo;

import java.io.Serializable;

public class TaskActionCombineBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2952515880022736626L;

	private String taskId;
	private String assignee;
	private String taskSummary;
	private String taskStatus;
	private String taskCreated;
	private String taskDuedate;
	private String actionType;
	private String created;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getTaskSummary() {
		return taskSummary;
	}
	public void setTaskSummary(String taskSummary) {
		this.taskSummary = taskSummary;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskCreated() {
		return taskCreated;
	}
	public void setTaskCreated(String taskCreated) {
		this.taskCreated = taskCreated;
	}
	public String getTaskDuedate() {
		return taskDuedate;
	}
	public void setTaskDuedate(String taskDuedate) {
		this.taskDuedate = taskDuedate;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "TaskActionCombineBO [taskId=" + taskId + ", assignee=" + assignee + ", taskSummary=" + taskSummary
				+ ", taskStatus=" + taskStatus + ", taskCreated=" + taskCreated + ", taskDuedate=" + taskDuedate
				+ ", actionType=" + actionType + ", created=" + created + "]";
	}
	
	
	

}
