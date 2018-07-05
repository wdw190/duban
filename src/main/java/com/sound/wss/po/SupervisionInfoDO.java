package com.sound.wss.po;

import java.io.Serializable;

public class SupervisionInfoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4919392073106347674L;

	private String supervisionWorkType;

	private String supervisionWorkNum;

	public String getSupervisionWorkType() {
		return supervisionWorkType;
	}

	public void setSupervisionWorkType(String supervisionWorkType) {
		this.supervisionWorkType = supervisionWorkType;
	}

	public String getSupervisionWorkNum() {
		return supervisionWorkNum;
	}

	public void setSupervisionWorkNum(String supervisionWorkNum) {
		this.supervisionWorkNum = supervisionWorkNum;
	}

	@Override
	public String toString() {
		return "SupervisionInfoDO [supervisionWorkType=" + supervisionWorkType + ", supervisionWorkNum="
				+ supervisionWorkNum + "]";
	}

}
