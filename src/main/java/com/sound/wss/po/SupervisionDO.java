package com.sound.wss.po;

import java.io.Serializable;

public class SupervisionDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -678724284792670122L;

	private String workType;
	private String workSummary;
	private String taskResolution;
	private String taskId;
	private String assigneeDept;
	private String assignee;
	private String taskSummary;
	private String taskStatus;
	private String supervisor;
	private String taskCreated;
	private String taskDuedate;
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorkSummary() {
		return workSummary;
	}
	public void setWorkSummary(String workSummary) {
		this.workSummary = workSummary;
	}
	public String getTaskResolution() {
		return taskResolution;
	}
	public void setTaskResolution(String taskResolution) {
		this.taskResolution = taskResolution;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getAssigneeDept() {
		return assigneeDept;
	}
	public void setAssigneeDept(String assigneeDept) {
		this.assigneeDept = assigneeDept;
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
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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
	@Override
	public String toString() {
		return "SupervisionDO [workType=" + workType + ", workSummary=" + workSummary + ", taskResolution="
				+ taskResolution + ", taskId=" + taskId + ", assigneeDept=" + assigneeDept + ", assignee=" + assignee
				+ ", taskSummary=" + taskSummary + ", taskStatus=" + taskStatus + ", supervisor=" + supervisor
				+ ", taskCreated=" + taskCreated + ", taskDuedate=" + taskDuedate + "]";
	}

	

}
