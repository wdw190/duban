package com.sound.wss.properties;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("weChatProperties")
@ConfigurationProperties(prefix = "wechat")
public class WeChatProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1328859075910943468L;

	private String accessTokenUrl;
	private String orgUrl;
	private String userUrl;
	
	private String sendSmsUrl;

	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public String getOrgUrl() {
		return orgUrl;
	}

	public void setOrgUrl(String orgUrl) {
		this.orgUrl = orgUrl;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getSendSmsUrl() {
		return sendSmsUrl;
	}

	public void setSendSmsUrl(String sendSmsUrl) {
		this.sendSmsUrl = sendSmsUrl;
	}

	@Override
	public String toString() {
		return "WeChatProperties [accessTokenUrl=" + accessTokenUrl + ", orgUrl=" + orgUrl + ", userUrl=" + userUrl
				+ ", sendSmsUrl=" + sendSmsUrl + "]";
	}

	

}
