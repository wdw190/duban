package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.wss.po.wechat.AccessToken;
import com.sound.wss.po.wechat.AllDepts;
import com.sound.wss.po.wechat.AllUserInfos;
import com.sound.wss.service.OrgService;
import com.sound.wss.service.WeChatService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatServiceTest {

	private WeChatService weChatService;

	private OrgService orgService;

	@Test
	public void m1() {

		AccessToken accessToken = weChatService.getWeChatAccessToken();

		System.out.println("----------AccessToken-----------------");

		System.out.println(accessToken.toString());

		System.out.println("---------------------------");
	}

	@Test
	public void m2() {

		AllDepts allDepts = this.weChatService.getWeChatAllDepts();

		allDepts.getDepartment().stream().forEach((dept) -> System.out.println(dept.toString()));

	}

	@Test
	public void m3() {

		AllUserInfos AllUserInfos = this.weChatService.getWeChatAllUserInfos();
		System.out.println("--------------------------");

		AllUserInfos.getUserlist().stream().forEach((userinfo) -> System.out.println(userinfo.toString()));

		System.out.println("---------------------------");

	}

	@Test
	public void m4() {

		this.orgService.dealOrg();;
	}

	public WeChatService getWeChatService() {
		return weChatService;
	}

	@Autowired
	@Required
	public void setWeChatService(@Qualifier("defaultWeChatService") WeChatService weChatService) {
		this.weChatService = weChatService;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	@Autowired
	@Required
	public void setOrgService(@Qualifier("defaultOrgService") OrgService orgService) {
		this.orgService = orgService;
	}

}
