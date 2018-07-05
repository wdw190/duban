package com.sound.battery.mybatis.dao;

import java.util.List;

import com.sound.battery.mybatis.model.BatteryCPBH;
import com.sound.battery.mybatis.model.BatteryDM;
import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.mybatis.model.BatteryXXH;
import com.sound.model.BatteryParamRequirementM;

public interface BatteryParamDao {
	public List<BatteryParamM> queryByAnyCondition(BatteryParamRequirementM batteryParamRequirementM);

	public BatteryParamM queryBatteryParamById(String id);

	public BatteryParamM queryBatteryParamByDm(String dm);

	/**
	 * 插入单条电池箱数据
	 * 
	 * @param batteryParamM
	 * @return
	 */
	public int insertBatteryParamM(BatteryParamM batteryParamM);

	/**
	 * 
	 * @Title: @Description: 修改电池箱参数 @param @return int 返回类型 @throws
	 *
	 */
	public int updateBatteryParamM(BatteryParamM batteryParamM);

	/**
	 * 删除 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int deleteBatteryParamM(String id);

	/**
	 * 箱型号 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * List<BatteryXXH> 返回类型 @throws
	 *
	 */
	public List<BatteryXXH> queryDistinctXXH();

	/**
	 * 产品编号 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * List<BatteryCPBH> 返回类型 @throws
	 *
	 */
	public List<BatteryCPBH> queryDistinctCPBH();

	/**
	 * 代码 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return List<BatteryDM>
	 * 返回类型 @throws
	 *
	 */

	public List<BatteryDM> queryDistinctDM();
}
