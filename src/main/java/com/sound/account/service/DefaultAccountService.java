package com.sound.account.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sound.account.mybatis.dao.AccountDao;
import com.sound.account.mybatis.model.Roles;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserCriticalM;
import com.sound.account.mybatis.model.UserResultM;
import com.sound.account.mybatis.model.UserRoles;

@Service("defaultAccountService")
public class DefaultAccountService implements AccountService {

	private AccountDao accountDao;

	/**
	 * 查询
	 */
	@Override
	public List<UserResultM> selectAllUsers(UserCriticalM userCriticalM) {

		return this.accountDao.selectAllUsers(userCriticalM);
	}

	/**
	 * 插入
	 */

	@Override
	public int insertUser(User user) {

		return this.accountDao.insertUser(user);
	}

	/**
	 * 查询
	 */
	@Override
	public User selectUserByUserid(int userid) {

		return this.accountDao.selectUserByUserid(userid);
	}

	/**
	 * 更新
	 */

	@Override
	public int updateUser(User user) {

		return this.accountDao.updateUser(user);
	}

	/**
	 * 查询
	 */
	@Override
	public User selectUserByUserName(String username) {

		return this.accountDao.selectUserByUserName(username);
	}

	/**
	 * 禁用
	 */

	@Override
	public int forbiddenUser(int userid) {

		return this.accountDao.forbiddenUser(userid);
	}

	/**
	 * 启用
	 */
	@Override
	public int enableUser(int userid) {

		return this.accountDao.enableUser(userid);
	}

	/**
	 * 查询所有的角色
	 */

	@Override
	public List<Roles> selectAllRoles() {

		return this.accountDao.selectAllRoles();
	}

	/**
	 * 根据用户ID查询用户的角色
	 */

	@Override
	public List<UserRoles> selectUserRolesByUserID(int userid) {

		return this.accountDao.selectUserRolesByUserID(userid);
	}

	/**
	 * 根据用户ID删除用户角色
	 */

	@Override
	public int deleteUserRoleByUserId(int userid) {

		return this.accountDao.deleteUserRoleByUserId(userid);
	}

	/**
	 * 批量插入用户角色
	 */

	@Override
	@Transactional
	public int insertUserRoles(List<UserRoles> list) {

		return this.accountDao.insertUserRoles(list);
	}

	/**
	 * 基于用户ID和角色代码删除用户角色
	 */
	@Override
	public int deleteUserRolesByUserIDAndRole(Map<String, Object> map) {

		return this.accountDao.deleteUserRolesByUserIDAndRole(map);
	}

	/**
	 * 插入删除用户角色
	 */

	@Override
	@Transactional
	public boolean insertAndDelUserRoles(int userid, List<String> newRoles, List<String> delRoles) {

		int onOfRowsInserted = -1;
		int onOfRowsDeleted = -1;
		boolean result = false;
		// 插入角色
		if (newRoles != null && newRoles.size() > 0) {
			List<UserRoles> newRolesList = new ArrayList<UserRoles>();
			for (String newrole : newRoles) {
				UserRoles userRole = new UserRoles();
				userRole.setUserid(userid);
				userRole.setRole(newrole);
				newRolesList.add(userRole);
			}

			onOfRowsInserted = this.accountDao.insertUserRoles(newRolesList);
		}

		// 删除角色
		if (delRoles != null && delRoles.size() > 0) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("userid", userid); // 放入userID

			map.put("roles", delRoles);// 待删除的角色

			onOfRowsDeleted = this.accountDao.deleteUserRolesByUserIDAndRole(map);

		}

		if (newRoles != null && newRoles.size() > 0 && delRoles != null && delRoles.size() > 0) {
			if (onOfRowsInserted > 0 && onOfRowsDeleted > 0) {
				result = true;
			} else {
				result = false;
			}

		} else if (newRoles != null && newRoles.size() > 0) {
			if (onOfRowsInserted > 0) {
				result = true;
			} else {
				result = false;
			}

		} else if (delRoles != null && delRoles.size() > 0) {
			if (onOfRowsDeleted > 0) {
				result = true;
			} else {
				result = false;
			}
		} else {
			result = true;
		}

		return result;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Autowired
	@Required
	public void setAccountDao(@Qualifier("defaultAccountDao") AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
