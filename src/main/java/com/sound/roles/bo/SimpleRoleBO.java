package com.sound.roles.bo;

import java.io.Serializable;

public class SimpleRoleBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 479381269019686056L;

	private String roleId;
	private String role;
	private String roleDesc;
	private String menuCode;
	private String menuName;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
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

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public String toString() {
		return "SimpleRoleBO [roleId=" + roleId + ", role=" + role + ", roleDesc=" + roleDesc + ", menuCode=" + menuCode
				+ ", menuName=" + menuName + "]";
	}

}
