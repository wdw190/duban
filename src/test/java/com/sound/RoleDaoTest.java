package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.roles.bo.RoleBO;
import com.sound.roles.dao.RoleDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
	
	private RoleDao roleDao;
	@Test
	public void m1(){
		
		RoleBO roleBO=this.roleDao.singleRoleInfo(5);
		
		System.out.println("----------------------------------");
		
		System.out.println(roleBO.toString());
		
		System.out.println("----------------------------------");
		
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	@Required
	public void setRoleDao(@Qualifier("defaultRoleDao") RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
	

}
