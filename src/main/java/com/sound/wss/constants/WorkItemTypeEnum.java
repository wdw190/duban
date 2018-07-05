package com.sound.wss.constants;

public enum WorkItemTypeEnum {

	GROUPWORK("集团工作督办"), 
	CHAIRMAN("董事长督办"), 
	PRESIDENT("总裁督办"), 
	CONFERENCE("会议督办"), 
	ANNUALKEYWORK("年度重点工作督办"), 
	SPECIALWORK("专项工作督办"), 
	OFKEYDEPARTMENTS("部门重点工作督办"), 
	OTHER("其它督办");// 记住要用分号结束

	private String desc;// 中文描述

	/**
	 * 私有构造,防止被外部调用
	 * 
	 * @param desc
	 */
	private WorkItemTypeEnum(String desc) {
		this.desc = desc;
	}

	/**
	 * 定义方法,返回描述,跟常规类的定义没区别
	 * 
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

}
