package com.sound.account.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.account.mybatis.dao.AccountDao;
import com.sound.account.mybatis.mapper.AccountMapper;
import com.sound.account.mybatis.model.Roles;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserCriticalM;
import com.sound.account.mybatis.model.UserResultM;
import com.sound.account.mybatis.model.UserRoles;

@Repository("defaultAccountDao")
public class DefaultAccountDao implements AccountDao {

	private SqlSession sqlSession;

	/**
	 * 插入
	 */
	@Override
	public int insertUser(User user) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);

		return mapper.insertUser(user);
	}

	/**
	 * 查询
	 */

	@Override
	public List<UserResultM> selectAllUsers(UserCriticalM userCriticalM) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.selectAllUsers(userCriticalM);
	}

	/**
	 * 基于用户ID查询用户
	 */

	@Override
	public User selectUserByUserid(int userid) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.selectUserByUserid(userid);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateUser(User user) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.updateUser(user);
	}

	/**
	 * 查询用户
	 */

	@Override
	public User selectUserByUserName(String username) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.selectUserByUserName(username);
	}

	/**
	 * 禁用
	 */

	@Override
	public int forbiddenUser(int userid) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.forbiddenUser(userid);
	}

	/**
	 * 启用
	 */

	@Override
	public int enableUser(int userid) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.enableUser(userid);
	}

	/**
	 * 查询所有角色
	 */

	@Override
	public List<Roles> selectAllRoles() {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.selectAllRoles();
	}

	/**
	 * 根据用户ID查询用户的角色
	 */

	@Override
	public List<UserRoles> selectUserRolesByUserID(int userid) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.selectUserRolesByUserID(userid);
	}

	/**
	 * 删除用户角色
	 */

	@Override
	public int deleteUserRoleByUserId(int userid) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.deleteUserRoleByUserId(userid);
	}

	/**
	 * 批量插入用户角色
	 */

	@Override
	public int insertUserRoles(List<UserRoles> list) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.insertUserRoles(list);
	}

	/**
	 * 基于用户ID和角色代码删除用户的角色
	 */

	@Override
	public int deleteUserRolesByUserIDAndRole(Map<String, Object> map) {
		AccountMapper mapper = this.sqlSession.getMapper(AccountMapper.class);
		return mapper.deleteUserRolesByUserIDAndRole(map);
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
