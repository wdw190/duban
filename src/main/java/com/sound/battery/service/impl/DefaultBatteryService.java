package com.sound.battery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.battery.mybatis.dao.BatteryDao;
import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.battery.service.BatteryService;
import com.sound.model.CustomerRequirementM;

@Service("defaultBatteryService")
public class DefaultBatteryService implements BatteryService {

	private BatteryDao batteryDao;

	@Override
	public List<BatteryConfigM> queryData(CustomerRequirementM customerRequirementM) {

		List<BatteryConfigM> batteryConfigMLists = this.batteryDao.queryByConditionModel(customerRequirementM);
		return batteryConfigMLists;
	}

	@Override
	public BatteryConfigM queryById(String id) {

		return this.batteryDao.queryById(id);

	}

	public BatteryDao getBatteryDao() {
		return batteryDao;
	}

	@Autowired
	@Required
	public void setBatteryDao(@Qualifier("defaultBatteryDao") BatteryDao batteryDao) {
		this.batteryDao = batteryDao;
	}

}
