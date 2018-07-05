package com.sound.model;

import java.io.Serializable;

public class CustomerRequirementM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6520300249838058707L;
	public double dymin;// 电压
	public double dymax;// 电压
	public double dlmin;// 电量
	public double dlmax;// 电量
	public int dcxslmin;// 电池箱数量
	public int dcxslmax;// 电池箱数量
	public String cc;// 车长

	public double getDymin() {
		return dymin;
	}

	public void setDymin(double dymin) {
		this.dymin = dymin;
	}

	public double getDymax() {
		return dymax;
	}

	public void setDymax(double dymax) {
		this.dymax = dymax;
	}

	public double getDlmin() {
		return dlmin;
	}

	public void setDlmin(double dlmin) {
		this.dlmin = dlmin;
	}

	public double getDlmax() {
		return dlmax;
	}

	public void setDlmax(double dlmax) {
		this.dlmax = dlmax;
	}

	public int getDcxslmin() {
		return dcxslmin;
	}

	public void setDcxslmin(int dcxslmin) {
		this.dcxslmin = dcxslmin;
	}

	public int getDcxslmax() {
		return dcxslmax;
	}

	public void setDcxslmax(int dcxslmax) {
		this.dcxslmax = dcxslmax;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "CustomerRequirementM [dymin=" + dymin + ", dymax=" + dymax + ", dlmin=" + dlmin + ", dlmax=" + dlmax
				+ ", dcxslmin=" + dcxslmin + ", dcxslmax=" + dcxslmax + ", cc=" + cc + "]";
	}

}
