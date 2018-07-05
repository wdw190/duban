package com.sound.account.mybatis.model;

import java.util.List;

public class AccountResultM {

	private List<UserResultM> userResultM;
	private String msg;

	public List<UserResultM> getUserResultM() {
		return userResultM;
	}

	public void setUserResultM(List<UserResultM> userResultM) {
		this.userResultM = userResultM;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AccountResultM [userResultM=" + userResultM + ", msg=" + msg + "]";
	}

}
