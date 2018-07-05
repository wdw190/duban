package com.sound.wss.dto;

import java.io.Serializable;

public class MyTaskCriteriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5710352905312803569L;
	
	private String assignee;
	
	private String taskResolution;

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getTaskResolution() {
		return taskResolution;
	}

	public void setTaskResolution(String taskResolution) {
		this.taskResolution = taskResolution;
	}

	@Override
	public String toString() {
		return "MyTaskCriteriaDTO [assignee=" + assignee + ", taskResolution=" + taskResolution + "]";
	}
	
	

}
