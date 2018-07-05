package com.sound.roles.po;

import java.io.Serializable;

public class RoleMenuDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6300771795767234678L;

	private int id;

	private String roleId;
	private String menuId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenuDO [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}

}
