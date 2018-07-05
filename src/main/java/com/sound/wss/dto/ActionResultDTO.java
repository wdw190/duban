package com.sound.wss.dto;

import java.io.Serializable;

public class ActionResultDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5206195530209397900L;

	private String flag;

	private String msg;

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

	@Override
	public String toString() {
		return "ActionResultDTO [flag=" + flag + ", msg=" + msg + "]";
	}

}
