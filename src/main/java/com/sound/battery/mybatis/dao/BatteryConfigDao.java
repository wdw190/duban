package com.sound.battery.mybatis.dao;

import com.sound.battery.mybatis.model.BatteryConfigM;

public interface BatteryConfigDao {
	/**
	 * 根据A箱或B箱代码查询配置方案
	 * 
	 * @param dm
	 * @return
	 */
	public java.util.List<BatteryConfigM> queryByABCodeCondition(String dm);
	
	/**
	 * 方案更新
	 * @param batteryConfigM
	 * @return
	 */
	public int updateBatteryConfigM(BatteryConfigM batteryConfigM);

}
