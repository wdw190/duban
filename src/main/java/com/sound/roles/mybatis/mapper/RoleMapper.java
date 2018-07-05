package com.sound.roles.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.roles.bo.RoleBO;
import com.sound.roles.bo.SimpleRoleBO;
import com.sound.roles.dto.RoleCriticalDTO;
import com.sound.roles.po.MenuDO;
import com.sound.roles.po.RoleDO;
import com.sound.roles.po.RoleMenuDO;

@Mapper
public interface RoleMapper {

	public List<SimpleRoleBO> listAllRoles(RoleCriticalDTO roleCriticalDTO);
	
	
	public List<MenuDO> listAllMenus();
	
	
	public int insertRole(RoleDO roleDO);
	
	
	public int insertRoleMenus(List<RoleMenuDO> list);
	
	
	public RoleBO singleRoleInfo(int roleId);
	
	public List<RoleMenuDO> listMenusInfo(String roleId);
	
	
	public int deleteRoleMenuByRoleId(String roleId);

}
