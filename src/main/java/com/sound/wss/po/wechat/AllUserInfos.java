package com.sound.wss.po.wechat;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllUserInfos {
	@JsonProperty(value = "errcode")
	private String errcode;
	@JsonProperty(value = "errmsg")
	private String errmsg;
	private List<UserInfo> userlist;
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
	public List<UserInfo> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<UserInfo> userlist) {
		this.userlist = userlist;
	}
	@Override
	public String toString() {
		return "AllUserInfos [errcode=" + errcode + ", errmsg=" + errmsg + ", userlist=" + userlist + "]";
	}
	
	
	

}
