package com.sound.model;

import java.io.Serializable;

public class ResponseMessageM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4390316862452557291L;

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
		return "ResponseMessageM [flag=" + flag + ", msg=" + msg + "]";
	}

}
