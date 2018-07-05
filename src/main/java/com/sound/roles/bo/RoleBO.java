package com.sound.roles.bo;

import java.io.Serializable;
import java.util.List;

import com.sound.roles.po.RoleDO;
import com.sound.roles.po.RoleMenuDO;

public class RoleBO extends RoleDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2927845880830141571L;
	
	private List<RoleMenuDO> roleMenuDOList;

	public List<RoleMenuDO> getRoleMenuDOList() {
		return roleMenuDOList;
	}

	public void setRoleMenuDOList(List<RoleMenuDO> roleMenuDOList) {
		this.roleMenuDOList = roleMenuDOList;
	}

	@Override
	public String toString() {
		return "RoleBO [roleMenuDOList=" + roleMenuDOList + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
	
	

}
