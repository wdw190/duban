package com.sound.account.mybatis.model;

import java.io.Serializable;

public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2858276824007851862L;

	private int roleid;//ID号
	private String role;//角色代码
	private String roledesc;//角色描述
	private int have;//用户是否拥有此角色

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}

	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", role=" + role + ", roledesc=" + roledesc + ", have=" + have + "]";
	}

}
