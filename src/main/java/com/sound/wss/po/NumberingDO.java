package com.sound.wss.po;

import java.io.Serializable;

public class NumberingDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1517407849282895946L;
	
	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "NumberingDO [number=" + number + "]";
	}
	
	

}
