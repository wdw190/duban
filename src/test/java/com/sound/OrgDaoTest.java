package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.wss.dao.OrgDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrgDaoTest {
	
	private OrgDao orgDao;
	
	@Test
	public void m1(){
		System.out.println("--------------------------------------------------------------");
		this.orgDao.listAllOrgs(350).stream().forEach((temp)->System.out.println(temp.toString()));
		System.out.println("--------------------------------------------------------------");
	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	@Autowired
	@Required
	public void setOrgDao(@Qualifier("defaultOrgDao") OrgDao orgDao) {
		this.orgDao = orgDao;
	}
	
	

}
