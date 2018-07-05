package com.sound.account.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sound.account.mybatis.model.Roles;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserCriticalM;
import com.sound.account.mybatis.model.UserResultM;
import com.sound.account.mybatis.model.UserRoles;

@Mapper
public interface AccountMapper {

	/**
	 * 新增用户 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int insertUser(User user);

	/**
	 * 查询用户 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * List<UserResultM> 返回类型 @throws
	 *
	 */
	public List<UserResultM> selectAllUsers(UserCriticalM userCriticalM);

	/**
	 * 查询用户 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return User
	 * 返回类型 @throws
	 *
	 */

	public User selectUserByUserid(int userid);

	/**
	 * 修改用户信息 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */

	public int updateUser(User user);

	/**
	 * 查询用户 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return User
	 * 返回类型 @throws
	 *
	 */

	public User selectUserByUserName(String username);

	/**
	 * 禁用账号 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int forbiddenUser(int userid);

	/**
	 * 启用账号 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int enableUser(int userid);

	/**
	 * 查询所有角色 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return List<Roles>
	 * 返回类型 @throws
	 *
	 */
	public List<Roles> selectAllRoles();

	/**
	 * 根据用户ID查询用户的角色 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * List<UserRoles> 返回类型 @throws
	 *
	 */
	public List<UserRoles> selectUserRolesByUserID(int userid);

	/**
	 * 根据用户ID，删除用户的角色 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int deleteUserRoleByUserId(int userid);

	/**
	 * 批量插入用户角色 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return int
	 * 返回类型 @throws
	 *
	 */
	public int insertUserRoles(java.util.List<UserRoles> list);

	/**
	 * 基于用户ID和角色代码删除用户角色 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * int 返回类型 @throws
	 *
	 */
	public int deleteUserRolesByUserIDAndRole(Map<String, Object> map);

}
