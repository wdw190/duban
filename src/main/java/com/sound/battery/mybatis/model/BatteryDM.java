package com.sound.battery.mybatis.model;

import java.io.Serializable;

public class BatteryDM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8808577265504403006L;

	private String dm;

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	@Override
	public String toString() {
		return "BatteryDM [dm=" + dm + "]";
	}
	
	

}
