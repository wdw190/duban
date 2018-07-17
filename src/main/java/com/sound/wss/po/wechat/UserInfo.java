package com.sound.wss.po.wechat;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
	
	
	@JsonProperty(value = "userid")
	private String userid;
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "department")
	private String[] department;
	@JsonProperty(value = "position")
	private String position;
	@JsonProperty(value = "mobile")
	private String mobile;
	@JsonProperty(value = "gender")
	private String gender;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "avatar")
	private String avatar;
	@JsonProperty(value = "status")
	private String status;
	@JsonProperty(value = "enable")
	private String enable;
	@JsonProperty(value = "isleader")
	private String isleader;
//	@JsonProperty(value = "extattr")
//	private String extattr;
	@JsonProperty(value = "hide_mobile")
	private String hide_mobile;
	@JsonProperty(value = "english_name")
	private String english_name;
	@JsonProperty(value = "telephone")
	private String telephone;
	@JsonProperty(value = "order")
	private String[] order;
	@JsonProperty(value = "qr_code")
	private String qr_code;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getDepartment() {
		return department;
	}
	public void setDepartment(String[] department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getIsleader() {
		return isleader;
	}
	public void setIsleader(String isleader) {
		this.isleader = isleader;
	}
	public String getHide_mobile() {
		return hide_mobile;
	}
	public void setHide_mobile(String hide_mobile) {
		this.hide_mobile = hide_mobile;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String[] getOrder() {
		return order;
	}
	public void setOrder(String[] order) {
		this.order = order;
	}
	public String getQr_code() {
		return qr_code;
	}
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", name=" + name + ", department=" + Arrays.toString(department)
				+ ", position=" + position + ", mobile=" + mobile + ", gender=" + gender + ", email=" + email
				+ ", avatar=" + avatar + ", status=" + status + ", enable=" + enable + ", isleader=" + isleader
				+ ", hide_mobile=" + hide_mobile + ", english_name=" + english_name + ", telephone=" + telephone
				+ ", order=" + Arrays.toString(order) + ", qr_code=" + qr_code + "]";
	}
	
	
	
	
	
	
	

}
