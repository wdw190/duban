package com.sound.roles.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.roles.bo.RoleBO;
import com.sound.roles.bo.SimpleRoleBO;
import com.sound.roles.dao.RoleDao;
import com.sound.roles.dto.RoleCriticalDTO;
import com.sound.roles.mybatis.mapper.RoleMapper;
import com.sound.roles.po.MenuDO;
import com.sound.roles.po.RoleDO;
import com.sound.roles.po.RoleMenuDO;

@Repository("defaultRoleDao")
public class DefaultRoleDao implements RoleDao {

	private SqlSession sqlSession;

	@Override
	public List<SimpleRoleBO> listAllRoles(RoleCriticalDTO roleCriticalDTO) {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.listAllRoles(roleCriticalDTO);
	}

	@Override
	public List<MenuDO> listAllMenus() {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.listAllMenus();
	}

	@Override
	public int insertRole(RoleDO roleDO) {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.insertRole(roleDO);
	}

	@Override
	public int insertRoleMenus(List<RoleMenuDO> list) {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.insertRoleMenus(list);
	}

	@Override
	public RoleBO singleRoleInfo(int roleId) {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.singleRoleInfo(roleId);
	}

	@Override
	public int deleteRoleMenuByRoleId(String roleId) {
		RoleMapper mapper = this.sqlSession.getMapper(RoleMapper.class);
		return mapper.deleteRoleMenuByRoleId(roleId);
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
