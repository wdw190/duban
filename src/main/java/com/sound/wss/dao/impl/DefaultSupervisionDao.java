package com.sound.wss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.wss.dao.SupervisionDao;
import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.mybatis.mapper.SupervisionMapper;
import com.sound.wss.po.SupervisionDO;

@Repository("defaultSupervisionDao")
public class DefaultSupervisionDao implements SupervisionDao {

	private SqlSession sqlSession;

	@Override
	public List<SupervisionDO> listSupervisionItem(SupervisionCriteriaDTO supervisionCriteriaDTO) {
		SupervisionMapper mapper = this.sqlSession.getMapper(SupervisionMapper.class);
		return mapper.listSupervisionItem(supervisionCriteriaDTO);
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
