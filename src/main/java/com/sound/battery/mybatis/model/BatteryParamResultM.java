package com.sound.battery.mybatis.model;

import java.util.List;

public class BatteryParamResultM {

	private List<BatteryParamM> batteryParamMResult;
	private String msg;

	public List<BatteryParamM> getBatteryParamMResult() {
		return batteryParamMResult;
	}

	public void setBatteryParamMResult(List<BatteryParamM> batteryParamMResult) {
		this.batteryParamMResult = batteryParamMResult;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BatteryParamResultM [batteryParamMResult=" + batteryParamMResult + ", msg=" + msg + "]";
	}

}
