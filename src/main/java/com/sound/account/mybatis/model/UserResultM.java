package com.sound.account.mybatis.model;

import java.io.Serializable;

public class UserResultM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -228415635220468822L;

	private int userid;
	private String username;
	private int enabled;
	private String rolecode;
	private String roledesc;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	@Override
	public String toString() {
		return "UserResultM [userid=" + userid + ", username=" + username + ", enabled=" + enabled + ", rolecode="
				+ rolecode + ", roledesc=" + roledesc + "]";
	}

}
