package com.sound.battery.mybatis.model;

import java.util.List;

public class BatteryConfigResultM {

	private List<BatteryConfigM> batteryConfigResult;
	private String msg;

	public List<BatteryConfigM> getBatteryConfigResult() {
		return batteryConfigResult;
	}

	public void setBatteryConfigResult(List<BatteryConfigM> batteryConfigResult) {
		this.batteryConfigResult = batteryConfigResult;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
