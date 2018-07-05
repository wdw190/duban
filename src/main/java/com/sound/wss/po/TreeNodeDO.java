package com.sound.wss.po;

import java.io.Serializable;

public class TreeNodeDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8004778217226331986L;

	private String text;
	private String icon;
	// private String selectedIcon;
	// private String color;
	// private String backColor;
	private String href;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@Override
	public String toString() {
		return "TreeNodeDO [text=" + text + ", icon=" + icon + ", href=" + href + "]";
	}

	// private boolean selectable;

	
	

}
