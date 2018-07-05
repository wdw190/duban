package com.sound.battery.service;

import com.sound.battery.mybatis.model.OutputM;

public interface BatteryOutputService {

	public OutputM queryById(String id);

}
