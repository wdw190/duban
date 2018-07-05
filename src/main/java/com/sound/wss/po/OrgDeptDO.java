package com.sound.wss.po;

import java.io.Serializable;

public class OrgDeptDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8355589857634305555L;

	private Integer deptId;
	private String deptName;
	private Integer supDepid;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getSupDepid() {
		return supDepid;
	}
	public void setSupDepid(Integer supDepid) {
		this.supDepid = supDepid;
	}
	@Override
	public String toString() {
		return "OrgDeptDO [deptId=" + deptId + ", deptName=" + deptName + ", supDepid=" + supDepid + "]";
	}

	

}
