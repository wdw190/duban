package com.sound.roles.po;

import java.io.Serializable;

public class MenuDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8058213331628727341L;

	private String menuId;
	private String menuName;
	private String menuCode;
	private String menuCreated;
	private String menuUpdated;
	private String haved;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuCreated() {
		return menuCreated;
	}
	public void setMenuCreated(String menuCreated) {
		this.menuCreated = menuCreated;
	}
	public String getMenuUpdated() {
		return menuUpdated;
	}
	public void setMenuUpdated(String menuUpdated) {
		this.menuUpdated = menuUpdated;
	}
	public String getHaved() {
		return haved;
	}
	public void setHaved(String haved) {
		this.haved = haved;
	}
	@Override
	public String toString() {
		return "MenuDO [menuId=" + menuId + ", menuName=" + menuName + ", menuCode=" + menuCode + ", menuCreated="
				+ menuCreated + ", menuUpdated=" + menuUpdated + ", haved=" + haved + "]";
	}

	

}
