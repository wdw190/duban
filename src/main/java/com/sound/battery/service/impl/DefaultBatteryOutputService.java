package com.sound.battery.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.battery.mybatis.dao.BatteryDao;
import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.battery.mybatis.model.OutputM;
import com.sound.battery.service.BatteryOutputService;
import com.sound.battery.utils.BatturyUitls;

@Service("defaultBatteryOutputService")
public class DefaultBatteryOutputService implements BatteryOutputService {

	private BatteryDao batteryDao;

	@Override
	public OutputM queryById(String id) {

		OutputM outputm = new OutputM();

		BatteryConfigM batteryConfigM = this.batteryDao.queryById(id);

		outputm.setPtdy(batteryConfigM.getDypt()); // 平台电压
		outputm.setFdjzdy(Float
				.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT).format(batteryConfigM.getXtzc() * 2.8)));// 放电截止电压
		outputm.setCdjzdy(Float
				.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT).format(batteryConfigM.getXtzc() * 3.6)));// 充电截止电压
		outputm.setXtbcrl(batteryConfigM.getBcrl());// 系统标称容量
		outputm.setXtdl(batteryConfigM.getBcdl()); // 系统电量
		outputm.setAnum(batteryConfigM.getDxzhfs1()); // A箱个数
		outputm.setAdm(batteryConfigM.getDxzhfs2());  //A箱代码
		outputm.setBnum(batteryConfigM.getDxzhfs3()); // B箱个数
		outputm.setBdm(batteryConfigM.getDxzhfs4()); //B箱代码
		outputm.setZl(Float.parseFloat(new DecimalFormat(BatturyUitls.DECIMALlFORMAT)
				.format(batteryConfigM.getDxzhfs1() * batteryConfigM.getAxzl()
						+ batteryConfigM.getDxzhfs3() * batteryConfigM.getBxzl()))); // 重量
		outputm.setXtnlmd(batteryConfigM.getDxnlmd()); // 系统能量密度

		/**
		 * 补贴金额计算
		 */
		float nlmd = batteryConfigM.getDxnlmd();
		float btjn = 0;

		String carType = batteryConfigM.getSycxcode();// 车长

		if (nlmd > 85 && nlmd <= 95) {
			outputm.setBtxs(new Float(0.8).floatValue());
			btjn = new BigDecimal(batteryConfigM.getBcdl()).multiply(new BigDecimal(1800)).multiply(new BigDecimal(0.8))
					.divide(new BigDecimal(10000)).floatValue();
		} else if (nlmd > 95 && nlmd <= 115) {
			outputm.setBtxs(new Float(1).floatValue());
			btjn = new BigDecimal(batteryConfigM.getBcdl()).multiply(new BigDecimal(1800)).multiply(new BigDecimal(1))
					.divide(new BigDecimal(10000)).floatValue();
		} else if (nlmd > 115) {
			outputm.setBtxs(new Float(1.2).floatValue());
			btjn = new BigDecimal(batteryConfigM.getBcdl()).multiply(new BigDecimal(1800)).multiply(new BigDecimal(1.2))
					.divide(new BigDecimal(10000)).floatValue();
		}

		if (carType.equalsIgnoreCase("TA")) {
			btjn = btjn <= 9 ? btjn : 9;

		} else if (carType.equalsIgnoreCase("TB")) {
			btjn = btjn <= 20 ? btjn : 20;
		} else if (carType.equalsIgnoreCase("TC") || carType.equalsIgnoreCase("TD")) {
			btjn = btjn <= 30 ? btjn : 30;
		}

		outputm.setBtje(btjn);
		return outputm;
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
