package com.sound.wss.po.wechat;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllDepts {

	@JsonProperty(value = "errcode")
	private String errcode;
	@JsonProperty(value = "errmsg")
	private String errmsg;
	private List<Dept> department;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<Dept> getDepartment() {
		return department;
	}

	public void setDepartment(List<Dept> department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "AllDepts [errcode=" + errcode + ", errmsg=" + errmsg + ", department=" + department + "]";
	}

}
