package com.sound.battery.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.battery.mybatis.dao.BatteryConfigDao;
import com.sound.battery.mybatis.mapper.BatteryConfigMapper;
import com.sound.battery.mybatis.model.BatteryConfigM;

@Repository("defaultBatteryConfigDao")
public class DefaultBatteryConfigDao implements BatteryConfigDao {

	private SqlSession sqlSession;

	@Override
	public List<BatteryConfigM> queryByABCodeCondition(String dm) {

		BatteryConfigMapper mapper = this.sqlSession.getMapper(BatteryConfigMapper.class);

		java.util.List<BatteryConfigM> batteryConfigMList = mapper.queryByABCodeCondition(dm);

		return batteryConfigMList;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	@Required
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int updateBatteryConfigM(BatteryConfigM batteryConfigM) {

		BatteryConfigMapper mapper = this.sqlSession.getMapper(BatteryConfigMapper.class);

		return mapper.updateBatteryConfigM(batteryConfigM);
	}

}
