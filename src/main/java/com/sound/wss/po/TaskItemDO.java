package com.sound.wss.po;

import java.io.Serializable;

public class TaskItemDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4963006391126685929L;
	/**
	 * 
	 * 负责人 负责部门 协助部门/人 任务优先级/重要程度 创建时间 任务详细说明 完成时间/到期日 任务项编号 完成情况 实际完成时间 任务状态
	 * 任务项描述 修改时间 工作项编号 工作项任务序号
	 */
	private String assignee;
	private String assigneeDept;
	private String assist;
	private String priority;
	private String taskCreated;
	private String taskDescription;
	private String taskDuedate;
	private String taskId;
	private String taskResolution;
	private String taskResolutiondate;
	private String taskStatus;
	private String taskSummary;
	private String taskUpdated;
	private String workId;
	private int workTaskNum;

	private String reporter;
	private String supervisor;
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssigneeDept() {
		return assigneeDept;
	}
	public void setAssigneeDept(String assigneeDept) {
		this.assigneeDept = assigneeDept;
	}
	public String getAssist() {
		return assist;
	}
	public void setAssist(String assist) {
		this.assist = assist;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTaskCreated() {
		return taskCreated;
	}
	public void setTaskCreated(String taskCreated) {
		this.taskCreated = taskCreated;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskDuedate() {
		return taskDuedate;
	}
	public void setTaskDuedate(String taskDuedate) {
		this.taskDuedate = taskDuedate;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskResolution() {
		return taskResolution;
	}
	public void setTaskResolution(String taskResolution) {
		this.taskResolution = taskResolution;
	}
	public String getTaskResolutiondate() {
		return taskResolutiondate;
	}
	public void setTaskResolutiondate(String taskResolutiondate) {
		this.taskResolutiondate = taskResolutiondate;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskSummary() {
		return taskSummary;
	}
	public void setTaskSummary(String taskSummary) {
		this.taskSummary = taskSummary;
	}
	public String getTaskUpdated() {
		return taskUpdated;
	}
	public void setTaskUpdated(String taskUpdated) {
		this.taskUpdated = taskUpdated;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public int getWorkTaskNum() {
		return workTaskNum;
	}
	public void setWorkTaskNum(int workTaskNum) {
		this.workTaskNum = workTaskNum;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	@Override
	public String toString() {
		return "TaskItemDO [assignee=" + assignee + ", assigneeDept=" + assigneeDept + ", assist=" + assist
				+ ", priority=" + priority + ", taskCreated=" + taskCreated + ", taskDescription=" + taskDescription
				+ ", taskDuedate=" + taskDuedate + ", taskId=" + taskId + ", taskResolution=" + taskResolution
				+ ", taskResolutiondate=" + taskResolutiondate + ", taskStatus=" + taskStatus + ", taskSummary="
				+ taskSummary + ", taskUpdated=" + taskUpdated + ", workId=" + workId + ", workTaskNum=" + workTaskNum
				+ ", reporter=" + reporter + ", supervisor=" + supervisor + "]";
	}

	

}
