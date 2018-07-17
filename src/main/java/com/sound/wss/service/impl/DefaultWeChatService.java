package com.sound.wss.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sound.exception.WSSException;
import com.sound.wss.po.wechat.AccessToken;
import com.sound.wss.po.wechat.AllDepts;
import com.sound.wss.po.wechat.AllUserInfos;
import com.sound.wss.po.wechat.ResponseType;
import com.sound.wss.po.wechat.TextInfo;
import com.sound.wss.properties.WeChatProperties;
import com.sound.wss.service.WeChatService;

@Service("defaultWeChatService")
public class DefaultWeChatService implements WeChatService {

	private RestTemplate restTemplate;

	private WeChatProperties weChatProperties;

	@Override
	public AccessToken getWeChatAccessToken() throws WSSException {

		AccessToken accessToken = this.restTemplate.getForObject(this.weChatProperties.getAccessTokenUrl(),
				AccessToken.class);

		return accessToken;
	}

	@Override
	public AllDepts getWeChatAllDepts() throws WSSException {

		AccessToken accessToken = this.getWeChatAccessToken();

		AllDepts allDepts = restTemplate.getForObject(
				String.format(weChatProperties.getOrgUrl(), accessToken.getAccessToken()), AllDepts.class);
		return allDepts;
	}

	@Override
	public AllUserInfos getWeChatAllUserInfos() throws WSSException {
		AccessToken accessToken = this.getWeChatAccessToken();

		AllUserInfos AllUserInfos = restTemplate.getForObject(
				String.format(weChatProperties.getUserUrl(), accessToken.getAccessToken()), AllUserInfos.class);
		return AllUserInfos;
	}

	@Override
	public void sendWeChatSMS(TextInfo text) throws WSSException {

		AccessToken accessToken = this.getWeChatAccessToken();

		String url = String.format(weChatProperties.getSendSmsUrl(), accessToken.getAccessToken());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity request = new HttpEntity(text, headers);

		Map<String, String> uriVariables = new HashMap<String, String>();

		ResponseType responseType=this.restTemplate.postForObject(url, request, ResponseType.class, uriVariables);
		
		System.out.println("--------------------------------------------------");
		System.out.println(responseType.toString());

	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	@Autowired
	@Required
	public void setRestTemplate(@Qualifier("restTemplate") RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public WeChatProperties getWeChatProperties() {
		return weChatProperties;
	}

	@Autowired
	@Required
	public void setWeChatProperties(@Qualifier("weChatProperties") WeChatProperties weChatProperties) {
		this.weChatProperties = weChatProperties;
	}

}
