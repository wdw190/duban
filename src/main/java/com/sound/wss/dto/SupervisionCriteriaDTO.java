package com.sound.wss.dto;

import java.io.Serializable;

public class SupervisionCriteriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 937383438890241448L;

	private String taskCreatedStart;

	private String taskCreatedEnd;

	private String taskDuedateStart;

	private String taskDuedateEnd;

	private String taskResolutionStatus;

	private String workType;

	private String summaryDesc;
	
	private String reporter;
	
	private String supervisior;

	public String getTaskCreatedStart() {
		return taskCreatedStart;
	}

	public void setTaskCreatedStart(String taskCreatedStart) {
		this.taskCreatedStart = taskCreatedStart;
	}

	public String getTaskCreatedEnd() {
		return taskCreatedEnd;
	}

	public void setTaskCreatedEnd(String taskCreatedEnd) {
		this.taskCreatedEnd = taskCreatedEnd;
	}

	public String getTaskDuedateStart() {
		return taskDuedateStart;
	}

	public void setTaskDuedateStart(String taskDuedateStart) {
		this.taskDuedateStart = taskDuedateStart;
	}

	public String getTaskDuedateEnd() {
		return taskDuedateEnd;
	}

	public void setTaskDuedateEnd(String taskDuedateEnd) {
		this.taskDuedateEnd = taskDuedateEnd;
	}

	public String getTaskResolutionStatus() {
		return taskResolutionStatus;
	}

	public void setTaskResolutionStatus(String taskResolutionStatus) {
		this.taskResolutionStatus = taskResolutionStatus;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getSummaryDesc() {
		return summaryDesc;
	}

	public void setSummaryDesc(String summaryDesc) {
		this.summaryDesc = summaryDesc;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getSupervisior() {
		return supervisior;
	}

	public void setSupervisior(String supervisior) {
		this.supervisior = supervisior;
	}

	@Override
	public String toString() {
		return "SupervisionCriteriaDTO [taskCreatedStart=" + taskCreatedStart + ", taskCreatedEnd=" + taskCreatedEnd
				+ ", taskDuedateStart=" + taskDuedateStart + ", taskDuedateEnd=" + taskDuedateEnd
				+ ", taskResolutionStatus=" + taskResolutionStatus + ", workType=" + workType + ", summaryDesc="
				+ summaryDesc + ", reporter=" + reporter + ", supervisior=" + supervisior + "]";
	}

	

}
