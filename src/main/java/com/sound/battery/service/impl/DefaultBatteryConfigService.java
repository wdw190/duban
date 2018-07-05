package com.sound.battery.service.impl;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.battery.mybatis.dao.BatteryConfigDao;
import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.service.BatteryConfigService;
import com.sound.battery.utils.BatturyUitls;

@Service("defaultBatteryConfigService")
public class DefaultBatteryConfigService implements BatteryConfigService {

	private BatteryConfigDao batteryConfigDao;

	@Override
	public boolean BatchUpdateBatteryConfigInfos(BatteryParamM batteryParamM) {

		boolean updateFlag = false;

		if (batteryParamM != null && batteryParamM.getDm().trim().length() > 0) {

			java.util.List<BatteryConfigM> batteryConfigMList = this.batteryConfigDao
					.queryByABCodeCondition(batteryParamM.getDm());

			/**
			 * 
			 * 系统标称容量=系统并数*电芯标称容量
			 */

			for (BatteryConfigM batteryConfigM : batteryConfigMList) {

				// A箱参数修改
				if (batteryConfigM.getDxzhfs2().trim().equalsIgnoreCase(batteryParamM.getDm().trim())) {
					batteryConfigM.setAxcs(batteryParamM.getCbs3()); // A箱串数
					batteryConfigM.setAxzl(batteryParamM.getZlexptc()); // A箱质量

					batteryConfigM.setXtzc(batteryConfigM.getDxzhfs1() * batteryParamM.getCbs3()
							+ batteryConfigM.getDxzhfs3() * batteryConfigM.getBxcs());// 总串数

				}

				// B箱参数修改
				if (batteryConfigM.getDxzhfs4().trim().equalsIgnoreCase(batteryParamM.getDm().trim())) {
					batteryConfigM.setBxcs(batteryParamM.getCbs3()); // B箱串数
					batteryConfigM.setBxzl(batteryParamM.getZlexptc());// B箱质量

					batteryConfigM.setXtzc(batteryConfigM.getDxzhfs1() * batteryConfigM.getAxcs()
							+ batteryConfigM.getDxzhfs3() * batteryParamM.getCbs3());// 总串数

				}

				// 平台电压 平台电压=系统总串数*3.2
				float dypt = batteryConfigM.getXtzc() * Float.parseFloat(BatturyUitls.dyptMultiplier);
				batteryConfigM.setDypt(Float.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT).format(dypt)));
				// 标称电量（系统电量） 系统电量=平台电压*系统标称容量/1000
				float bcdl = batteryConfigM.getDypt() * batteryConfigM.getBcrl() / 1000;
				batteryConfigM.setBcdl(Float.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT).format(bcdl)));
				// 系统能量密度
				// 系统重量=A箱数量*A箱重量（不含PTC）+B箱数量*B箱重量（不含PTC）
				float xtzl = batteryConfigM.getDxzhfs1() * batteryConfigM.getAxzl()
						+ batteryConfigM.getDxzhfs3() * batteryConfigM.getBxzl();
				// 系统能量密度=标称电量*1000/系统重量
				float nlmd = batteryConfigM.getBcdl() * 1000 / xtzl;

				batteryConfigM.setDxnlmd(Float.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT).format(nlmd)));

				//更新方案
				this.batteryConfigDao.updateBatteryConfigM(batteryConfigM);

			}

			updateFlag = true;
		} else {
			updateFlag = false;
		}

		return updateFlag;
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
