package com.sound.battery.mybatis.dao;

import java.util.List;

import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.model.CustomerRequirementM;

public interface BatteryDao {
	
	/**
	 * 基于客户需求信息 自动筛选动力电池系统
	 * @param customerRequirementM
	 * @return
	 */
	
	public List<BatteryConfigM> queryByConditionModel(CustomerRequirementM customerRequirementM);
	
	/**
	 * 根据ID查询配置信息
	 * @param id
	 * @return
	 */
	public BatteryConfigM queryById(String id);

}
