package com.sound.battery.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.battery.mybatis.dao.BatteryParamDao;
import com.sound.battery.mybatis.mapper.BatteryParamMapper;
import com.sound.battery.mybatis.model.BatteryCPBH;
import com.sound.battery.mybatis.model.BatteryDM;
import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.mybatis.model.BatteryXXH;
import com.sound.model.BatteryParamRequirementM;

@Repository("defaultBatteryParamDao")
public class DefaultBatteryParamDao implements BatteryParamDao {

	private SqlSession sqlSession;

	@Override
	public List<BatteryParamM> queryByAnyCondition(BatteryParamRequirementM batteryParamRequirementM) {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		List<BatteryParamM> batteryParamMList = mapper.queryByAnyCondition(batteryParamRequirementM);
		return batteryParamMList != null && batteryParamMList.size() > 0 ? batteryParamMList : null;
	}

	@Override
	public BatteryParamM queryBatteryParamById(String id) {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		BatteryParamM batteryParamM = mapper.queryBatteryParamById(id);
		return batteryParamM != null ? batteryParamM : null;
	}
	
	

	@Override
	public BatteryParamM queryBatteryParamByDm(String dm) {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		BatteryParamM batteryParamM = mapper.queryBatteryParamByDm(dm);
		return batteryParamM != null ? batteryParamM : null;
	}

	/**
	 * 插入
	 */
	@Override
	public int insertBatteryParamM(BatteryParamM batteryParamM) {

		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		int noOfRowsInserted = mapper.insertBatteryParamM(batteryParamM);

		return noOfRowsInserted;
	}

	/**
	 * 修改
	 */
	@Override
	public int updateBatteryParamM(BatteryParamM batteryParamM) {

		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		int onOfRowsUpdated = mapper.updateBatteryParamM(batteryParamM);

		return onOfRowsUpdated;
	}

	/**
	 * 删除
	 */

	@Override
	public int deleteBatteryParamM(String id) {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		int noOfRowsDeleted = mapper.deleteBatteryParamM(id);
		return noOfRowsDeleted;
	}

	@Override
	public List<BatteryXXH> queryDistinctXXH() {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);

		List<BatteryXXH> BatteryXXHList = mapper.queryDistinctXXH();

		return BatteryXXHList != null && BatteryXXHList.size() > 0 ? BatteryXXHList : null;
	}

	@Override
	public List<BatteryCPBH> queryDistinctCPBH() {

		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		List<BatteryCPBH> BatteryCPBHList = mapper.queryDistinctCPBH();

		return BatteryCPBHList != null && BatteryCPBHList.size() > 0 ? BatteryCPBHList : null;
	}

	@Override
	public List<BatteryDM> queryDistinctDM() {
		BatteryParamMapper mapper = this.sqlSession.getMapper(BatteryParamMapper.class);
		List<BatteryDM> BatteryDMList = mapper.queryDistinctDM();

		return BatteryDMList != null && BatteryDMList.size() > 0 ? BatteryDMList : null;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	@Required
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
