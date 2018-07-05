package com.sound.battery.service;

import java.util.List;

import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.model.CustomerRequirementM;

public interface BatteryService {

	/**
	 * 根据客户需求信息查询动力电池系统配置
	 * 
	 * @param customerRequirementM
	 * @return
	 */

	public List<BatteryConfigM> queryData(CustomerRequirementM customerRequirementM);

	/**
	 * 根据ID查询配置信息
	 * 
	 * @param id
	 * @return
	 */
	public BatteryConfigM queryById(String id);

}
