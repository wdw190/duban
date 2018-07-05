package com.sound.wss.po;

import java.io.Serializable;

public class DueTaskDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207484011655683690L;
	
	private String assignee;
	
	private String overdue;
	
	private String comingSoon;
	
	private String notOverDue;

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}

	public String getComingSoon() {
		return comingSoon;
	}

	public void setComingSoon(String comingSoon) {
		this.comingSoon = comingSoon;
	}

	public String getNotOverDue() {
		return notOverDue;
	}

	public void setNotOverDue(String notOverDue) {
		this.notOverDue = notOverDue;
	}

	@Override
	public String toString() {
		return "DueTaskDO [assignee=" + assignee + ", overdue=" + overdue + ", comingSoon=" + comingSoon
				+ ", notOverDue=" + notOverDue + "]";
	}
	
	
	

}
