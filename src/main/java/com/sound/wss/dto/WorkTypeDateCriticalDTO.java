package com.sound.wss.dto;

import java.io.Serializable;

public class WorkTypeDateCriticalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8627928754440061697L;

	private String workTypeDate;

	public String getWorkTypeDate() {
		return workTypeDate;
	}

	public void setWorkTypeDate(String workTypeDate) {
		this.workTypeDate = workTypeDate;
	}

	@Override
	public String toString() {
		return "WorkTypeDateCriticalDTO [workTypeDate=" + workTypeDate + "]";
	}

}
