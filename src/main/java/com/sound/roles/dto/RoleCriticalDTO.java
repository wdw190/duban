package com.sound.roles.dto;

import java.io.Serializable;

public class RoleCriticalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3885151940833469701L;
	
	
	private String roleCode;
	
	private String roleDesc;
	
	private String roleStatus;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	@Override
	public String toString() {
		return "RoleCriticalDTO [roleCode=" + roleCode + ", roleDesc=" + roleDesc + ", roleStatus=" + roleStatus + "]";
	}
	
	
	
	

}
