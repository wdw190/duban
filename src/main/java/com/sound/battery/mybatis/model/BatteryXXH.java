package com.sound.battery.mybatis.model;

import java.io.Serializable;

public class BatteryXXH implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6860798850138850635L;

	private String xxh;

	public String getXxh() {
		return xxh;
	}

	public void setXxh(String xxh) {
		this.xxh = xxh;
	}

	@Override
	public String toString() {
		return "BatteryXXH [xxh=" + xxh + "]";
	}

}
