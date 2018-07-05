package com.sound.battery.mybatis.model;

import java.io.Serializable;

public class BatteryCPBH implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4708903102221694118L;

	private String cpbh;

	public String getCpbh() {
		return cpbh;
	}

	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}

	@Override
	public String toString() {
		return "BatteryCPBH [cpbh=" + cpbh + "]";
	}
	
	

}
