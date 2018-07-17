package com.sound.wss.po;

import java.io.Serializable;

public class WeChatPersonInfoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3694304064077591963L;

	private String taskId;
	private String assignee;
	private String taskSummary;
	private String assigneeId;
	private String supervisor;
	private String supervisorId;
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
	public String getAssigneeId() {
		return assigneeId;
	}
	public void setAssigneeId(String assigneeId) {
		this.assigneeId = assigneeId;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}
	@Override
	public String toString() {
		return "WeChatPersonInfoDO [taskId=" + taskId + ", assignee=" + assignee + ", taskSummary=" + taskSummary
				+ ", assigneeId=" + assigneeId + ", supervisor=" + supervisor + ", supervisorId=" + supervisorId + "]";
	}

	

}
