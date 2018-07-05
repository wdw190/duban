package com.sound.model;

import java.io.Serializable;

public class BatteryParamRequirementM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5794869075547598612L;

	private String xxh; //箱型号
	private String cpbh; //产品编号
	private String dm;  //代码
	public String getXxh() {
		return xxh;
	}
	public void setXxh(String xxh) {
		this.xxh = xxh;
	}
	public String getCpbh() {
		return cpbh;
	}
	public void setCpbh(String cpbh) {
		this.cpbh = cpbh;
	}
	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}
	
	

}
