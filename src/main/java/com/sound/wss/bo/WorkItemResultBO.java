package com.sound.wss.bo;

import java.io.Serializable;
import java.util.List;

import com.sound.wss.po.WorkItemDO;

public class WorkItemResultBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5576216561219573377L;
	private String msg;
	private String flag;

	private List<WorkItemDO> workItemDOList;

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

	public List<WorkItemDO> getWorkItemDOList() {
		return workItemDOList;
	}

	public void setWorkItemDOList(List<WorkItemDO> workItemDOList) {
		this.workItemDOList = workItemDOList;
	}

	@Override
	public String toString() {
		return "WorkItemResultBO [msg=" + msg + ", flag=" + flag + ", workItemDOList=" + workItemDOList + "]";
	}

}
