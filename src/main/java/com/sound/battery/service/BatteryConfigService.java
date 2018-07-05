package com.sound.battery.service;

import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.battery.mybatis.model.BatteryParamM;

public interface BatteryConfigService {

	/**
	 * 基于电池箱参数，批量修改 配置方案的数据
	 * 
	 * @return
	 */
	public boolean BatchUpdateBatteryConfigInfos(BatteryParamM batteryParamM);
	


}
