package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.battery.mybatis.dao.BatteryConfigDao;
import com.sound.battery.mybatis.model.BatteryConfigM;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatteryConfigDaoTest {

	private BatteryConfigDao batteryConfigDao;

	@Test
	public void demoTest1() {

		java.util.List<BatteryConfigM> batteryConfigMList = this.batteryConfigDao.queryByABCodeCondition("A4");

		for (BatteryConfigM batteryConfigM : batteryConfigMList) {
			System.out.println("-----------------------------------");
			System.out.println(batteryConfigM.toString());
			System.out.println("-----------------------------------");

		}
	}

	public BatteryConfigDao getBatteryConfigDao() {
		return batteryConfigDao;
	}

	@Autowired
	@Required
	public void setBatteryConfigDao(@Qualifier("defaultBatteryConfigDao") BatteryConfigDao batteryConfigDao) {
		this.batteryConfigDao = batteryConfigDao;
	}

}
