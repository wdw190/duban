package com.sound.battery.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.battery.mybatis.dao.BatteryDao;
import com.sound.battery.mybatis.mapper.BatteryMapper;
import com.sound.battery.mybatis.model.BatteryConfigM;
import com.sound.model.CustomerRequirementM;

@Repository("defaultBatteryDao")
public class DefaultBatteryDao implements BatteryDao {

	private SqlSession sqlSession;

	@Override
	public List<BatteryConfigM> queryByConditionModel(CustomerRequirementM customerRequirementM) {
		BatteryMapper mapper = this.sqlSession.getMapper(BatteryMapper.class);
		List<BatteryConfigM> batteryConfigMList = mapper.queryByConditionModel(customerRequirementM);
		return batteryConfigMList != null && batteryConfigMList.size() > 0 ? batteryConfigMList : null;
	}

	@Override
	public BatteryConfigM queryById(String id) {
		BatteryMapper mapper = this.sqlSession.getMapper(BatteryMapper.class);

		BatteryConfigM batteryConfigM = mapper.queryById(id);
		return batteryConfigM;
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
