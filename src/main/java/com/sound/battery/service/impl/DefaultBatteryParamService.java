package com.sound.battery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.battery.mybatis.dao.BatteryParamDao;
import com.sound.battery.mybatis.model.BatteryCPBH;
import com.sound.battery.mybatis.model.BatteryDM;
import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.mybatis.model.BatteryParamResultM;
import com.sound.battery.mybatis.model.BatteryXXH;
import com.sound.battery.service.BatteryParamService;
import com.sound.model.BatteryParamRequirementM;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2017年4月21日 下午4:34:11
 */
@Service("defaultBatteryParamService")
public class DefaultBatteryParamService implements BatteryParamService {

	private BatteryParamDao batteryParamDao;

	@Override
	public BatteryParamResultM queryData(BatteryParamRequirementM batteryParamRequirementM) {
		BatteryParamResultM batteryParamResultM = new BatteryParamResultM();
		List<BatteryParamM> batteryParamMList = this.batteryParamDao.queryByAnyCondition(batteryParamRequirementM);
		if (batteryParamMList != null && batteryParamMList.size() > 0) {
			batteryParamResultM.setBatteryParamMResult(batteryParamMList);
			batteryParamResultM.setMsg("S");
		} else {
			batteryParamResultM.setMsg("F");
		}

		return batteryParamResultM;
	}

	@Override
	public BatteryParamM queryBatteryParamById(String id) {

		return this.batteryParamDao.queryBatteryParamById(id);

	}

	@Override
	public BatteryParamM queryBatteryParamByDm(String dm) {
		return this.batteryParamDao.queryBatteryParamByDm(dm);
	}

	/**
	 * 插入单条电池箱数据
	 */

	@Override
	public int insertBatteryParamM(BatteryParamM batteryParamM) {
		int noofRowsInserted = this.batteryParamDao.insertBatteryParamM(batteryParamM);
		return noofRowsInserted;
	}

	/**
	 * 修改
	 */

	@Override
	public int updateBatteryParamM(BatteryParamM batteryParamM) {

		int onOfRowsUpdated = this.batteryParamDao.updateBatteryParamM(batteryParamM);

		return onOfRowsUpdated;
	}

	/**
	 * 删除
	 */

	@Override
	public int deleteBatteryParamM(String id) {
		int onOfRowsDeleted = this.batteryParamDao.deleteBatteryParamM(id);
		return onOfRowsDeleted;
	}

	@Override
	public List<BatteryXXH> queryDistinctXXH() {

		return this.batteryParamDao.queryDistinctXXH();
	}

	@Override
	public List<BatteryCPBH> queryDistinctCPBH() {

		return this.batteryParamDao.queryDistinctCPBH();
	}

	@Override
	public List<BatteryDM> queryDistinctDM() {

		return this.batteryParamDao.queryDistinctDM();
	}

	public BatteryParamDao getBatteryParamDao() {
		return batteryParamDao;
	}

	@Autowired
	@Required
	public void setBatteryParamDao(@Qualifier("defaultBatteryParamDao") BatteryParamDao batteryParamDao) {
		this.batteryParamDao = batteryParamDao;
	}

}
