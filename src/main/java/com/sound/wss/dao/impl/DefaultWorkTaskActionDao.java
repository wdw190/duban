package com.sound.wss.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.wss.dao.WorkTaskActionDao;
import com.sound.wss.mybatis.mapper.WorkTaskActionMapper;
import com.sound.wss.po.WorkTaskActionDO;
@Repository("defaultWorkTaskActionDao")
public class DefaultWorkTaskActionDao implements WorkTaskActionDao {
	
	private SqlSession sqlSession;

	@Override
	public int insertWorkTaskAction(WorkTaskActionDO workTaskActionDO) {
		
		WorkTaskActionMapper mapper = this.sqlSession.getMapper(WorkTaskActionMapper.class);
		
		return mapper.insertWorkTaskAction(workTaskActionDO);
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
