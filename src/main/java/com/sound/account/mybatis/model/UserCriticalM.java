package com.sound.account.mybatis.model;

import java.io.Serializable;

public class UserCriticalM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2974094432306980799L;

	private String username;

	private String enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserCriticalM [username=" + username + ", enabled=" + enabled + "]";
	}

	
}
