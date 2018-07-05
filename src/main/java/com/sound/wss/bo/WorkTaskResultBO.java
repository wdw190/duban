package com.sound.wss.bo;

import java.io.Serializable;
import java.util.List;

public class WorkTaskResultBO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3700461138410347653L;

	private String msg;
	private String flag;

	private List<T> workTaskList;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<T> getWorkTaskList() {
		return workTaskList;
	}

	public void setWorkTaskList(List<T> workTaskList) {
		this.workTaskList = workTaskList;
	}

	@Override
	public String toString() {
		return "WorkTaskResultBO [msg=" + msg + ", flag=" + flag + ", workTaskList=" + workTaskList + "]";
	}
	
	

}
