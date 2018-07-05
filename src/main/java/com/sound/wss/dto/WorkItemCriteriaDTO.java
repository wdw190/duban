package com.sound.wss.dto;

import java.io.Serializable;

public class WorkItemCriteriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 474418436285612426L;

	private String createdStart;

	private String createdEnd;

	private String workSummary;
	
	private String reporter;

	public String getCreatedStart() {
		return createdStart;
	}

	public void setCreatedStart(String createdStart) {
		this.createdStart = createdStart;
	}

	public String getCreatedEnd() {
		return createdEnd;
	}

	public void setCreatedEnd(String createdEnd) {
		this.createdEnd = createdEnd;
	}

	public String getWorkSummary() {
		return workSummary;
	}

	public void setWorkSummary(String workSummary) {
		this.workSummary = workSummary;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	@Override
	public String toString() {
		return "WorkItemCriteriaDTO [createdStart=" + createdStart + ", createdEnd=" + createdEnd + ", workSummary="
				+ workSummary + ", reporter=" + reporter + "]";
	}

	

}
