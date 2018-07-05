package com.sound.account.mybatis.model;

import java.io.Serializable;

public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5445684374954624226L;

	private int user_role_id;
	private int userid;
	private String role;

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [user_role_id=" + user_role_id + ", userid=" + userid + ", role=" + role + "]";
	}

}
