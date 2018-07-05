package com.sound.wss.dto;

import java.io.Serializable;

public class TaskItemWorkIdCriticalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7353495022296397818L;
	
	private String workId;

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	@Override
	public String toString() {
		return "TaskItemWorkIdCriticalDTO [workId=" + workId + "]";
	}
	
	

}
