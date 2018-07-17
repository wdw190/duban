package com.sound.wss.po.wechat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseType {
	private long  errcode;
	private String errmsg;
	private String invaliduser;
	private String invalidparty;
	private String invalidtag;
	public long getErrcode() {
		return errcode;
	}
	public void setErrcode(long errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getInvaliduser() {
		return invaliduser;
	}
	public void setInvaliduser(String invaliduser) {
		this.invaliduser = invaliduser;
	}
	public String getInvalidparty() {
		return invalidparty;
	}
	public void setInvalidparty(String invalidparty) {
		this.invalidparty = invalidparty;
	}
	public String getInvalidtag() {
		return invalidtag;
	}
	public void setInvalidtag(String invalidtag) {
		this.invalidtag = invalidtag;
	}
	@Override
	public String toString() {
		return "ResponseType [errcode=" + errcode + ", errmsg=" + errmsg + ", invaliduser=" + invaliduser
				+ ", invalidparty=" + invalidparty + ", invalidtag=" + invalidtag + "]";
	}
	
	
	
//	{
//		   "errcode" : 0,
//		   "errmsg" : "ok",
//		   "invaliduser" : "UserID1", // 不区分大小写，返回的列表都统一转为小写
//		   "invalidparty" : "PartyID1",
//		   "invalidtag":"TagID1"
//		 }

}
