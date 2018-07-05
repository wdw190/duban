package com.sound.wss.po;

import java.io.Serializable;

public class OrgUserDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4215160019400650045L;

	private Integer ID;
	private String workerId;
	private String name;
	private String sex;
	private String telephone;
	private String mobile;
	private Integer jobTitle;
	private Integer deptId;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(Integer jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "OrgUserDO [ID=" + ID + ", workerId=" + workerId + ", name=" + name + ", sex=" + sex + ", telephone="
				+ telephone + ", mobile=" + mobile + ", jobTitle=" + jobTitle + ", deptId=" + deptId + "]";
	}

	

}
