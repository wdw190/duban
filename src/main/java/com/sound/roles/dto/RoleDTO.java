package com.sound.roles.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5213656604816408873L;
	
	private String roleId;
	
	private String roleCode;
	
	private String roleDesc;
	
	private String menus;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

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

	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "RoleDTO [roleId=" + roleId + ", roleCode=" + roleCode + ", roleDesc=" + roleDesc + ", menus=" + menus
				+ "]";
	}

	
	
	
	

}
