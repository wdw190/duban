package com.sound.roles.po;

import java.io.Serializable;

public class RoleDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2914309570685597821L;
	
	
	private int roleId;
	
	private String role;
	
	private String roleDesc;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "RoleDO [roleId=" + roleId + ", role=" + role + ", roleDesc=" + roleDesc + "]";
	}
	
	
	

}
