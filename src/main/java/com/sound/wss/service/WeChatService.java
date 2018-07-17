package com.sound.wss.service;

import com.sound.exception.WSSException;
import com.sound.wss.po.wechat.AccessToken;
import com.sound.wss.po.wechat.AllDepts;
import com.sound.wss.po.wechat.AllUserInfos;
import com.sound.wss.po.wechat.TextInfo;

public interface WeChatService {
	
	
	public AccessToken getWeChatAccessToken() throws WSSException;
	
	public AllDepts getWeChatAllDepts()  throws WSSException;
	
	public AllUserInfos getWeChatAllUserInfos() throws WSSException;
	
	
	public void sendWeChatSMS(TextInfo text) throws WSSException;

}
