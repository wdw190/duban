package com.sound.wss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.dao.OrgDao;
import com.sound.wss.mybatis.mapper.OrgMapper;
import com.sound.wss.po.OrgDeptDO;
import com.sound.wss.po.OrgUserDO;

@Repository("defaultOrgDao")
public class DefaultOrgDao implements OrgDao {

	private SqlSession sqlSession;

	@Override
	public List<OrgBO> listAllOrgs(Integer deptId) {

		OrgMapper mapper = this.sqlSession.getMapper(OrgMapper.class);

		return mapper.listAllOrgs(deptId);
	}

	@Override
	public List<TreeNodeBO> listAllNodes(Integer deptId) {
		OrgMapper mapper = this.sqlSession.getMapper(OrgMapper.class);
		return mapper.listAllNodes(deptId);
	}

	@Override
	public int insertOrgDeptDO(List<OrgDeptDO> list) {
		OrgMapper mapper = this.sqlSession.getMapper(OrgMapper.class);
		return mapper.insertOrgDeptDO(list);
	}
	
	

	@Override
	public int insertOrgUserDO(List<OrgUserDO> list) {
		OrgMapper mapper = this.sqlSession.getMapper(OrgMapper.class);
		return mapper.insertOrgUserDO(list);
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
