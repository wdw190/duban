package com.sound.wss.po;

import java.io.Serializable;

public class WorkItemDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5668394446724425205L;

	private String workId;
	private String workType;
	private String workSummary;
	private String workDescription;
	private String reporter;
	private String created;
	private String workStatus;

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

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

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	@Override
	public String toString() {
		return "WorkITEMPO [workId=" + workId + ", workType=" + workType + ", workSummary=" + workSummary
				+ ", workDescription=" + workDescription + ", reporter=" + reporter + ", created=" + created
				+ ", workStatus=" + workStatus + "]";
	}
	
	

}
