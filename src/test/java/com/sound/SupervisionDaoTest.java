package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.wss.dao.SupervisionDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupervisionDaoTest {
	
	private SupervisionDao supervisionDao;
	
	@Test
	public void m1(){
		System.out.println("----------------------------------------------");
		this.supervisionDao.listSupervisionItem(null).stream().forEach((temp)->System.out.println(temp.toString()));
		System.out.println("----------------------------------------------");
	}

	public SupervisionDao getSupervisionDao() {
		return supervisionDao;
	}

	
	@Autowired
	@Required
	public void setSupervisionDao(@Qualifier("defaultSupervisionDao") SupervisionDao supervisionDao) {
		this.supervisionDao = supervisionDao;
	}
	
	
	
	
	

}
