package com.sound.roles.bo;

import java.io.Serializable;
import java.util.List;

public class RoleResultBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7868838896986473902L;
	
	private String flag;
	
	private String msg;
	
	private List<SimpleRoleBO> simpleRoleBOList;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<SimpleRoleBO> getSimpleRoleBOList() {
		return simpleRoleBOList;
	}

	public void setSimpleRoleBOList(List<SimpleRoleBO> simpleRoleBOList) {
		this.simpleRoleBOList = simpleRoleBOList;
	}

	@Override
	public String toString() {
		return "RoleResultBO [flag=" + flag + ", msg=" + msg + ", simpleRoleBOList=" + simpleRoleBOList + "]";
	}
	
	
	

}
