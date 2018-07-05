package com.sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.account.mybatis.dao.AccountDao;
import com.sound.account.mybatis.model.Roles;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserResultM;
import com.sound.account.mybatis.model.UserRoles;
import com.sound.account.service.AccountService;
import com.sound.battery.mybatis.dao.BatteryDao;
import com.sound.battery.mybatis.dao.BatteryParamDao;
import com.sound.battery.mybatis.model.BatteryParamM;
import com.sound.battery.service.BatteryOutputService;
import com.sound.battery.service.BatteryParamService;
import com.sound.battery.service.BatteryService;
import com.sound.model.CustomerRequirementM;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoundappApplicationTests {

	private BatteryDao batteryDao;

	private BatteryService batteryService;

	private BatteryOutputService batteryOutputService;

	private BatteryParamDao batteryParamDao;

	private BatteryParamService batteryParamService;

	private AccountDao accountDao;

	private AccountService accountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void deleteUserRolesByUserIDAndRoleTest() {

		java.util.Map<String, Object> map = new HashMap<String, Object>();
		java.util.List<String> delRoles = new ArrayList<String>();
		map.put("userid", 18);
		delRoles.add("ROLE_ADMIN");
		delRoles.add("ROLE_USER");
		map.put("roles", delRoles);

		int onOfRowsDeleted = this.accountDao.deleteUserRolesByUserIDAndRole(map);

		System.out.println("-----------------------------------");

		System.out.println("-----删除了" + onOfRowsDeleted + "行");

		System.out.println("-----------------------------------");

	}

	@Test
	public void insertUserRoles() {
		java.util.List<UserRoles> list = new ArrayList<UserRoles>();

		UserRoles userrole = new UserRoles();
		userrole.setUserid(17);
		userrole.setRole("ROLE_ADMIN");
		list.add(userrole);

		UserRoles userrole1 = new UserRoles();
		userrole1.setUserid(16);
		userrole1.setRole("ROLE_USER");
		list.add(userrole1);
		int onOfRowsInserted = this.accountService.insertUserRoles(list);
		System.out.println("插入了" + onOfRowsInserted + "行");
	}

	@Test
	public void deleteUserRoleTest() {
		int onOfDeletedRows = this.accountService.deleteUserRoleByUserId(18);
		System.out.println("删除了" + onOfDeletedRows + "行");
	}

	@Test
	public void selectAllRolesByUserID() {
		List<UserRoles> userRolesList = this.accountService.selectUserRolesByUserID(1);
		if (userRolesList != null && userRolesList.size() > 0) {
			for (UserRoles role : userRolesList) {
				System.out.println("------------------------------");
				System.out.println(role.toString());
				System.out.println("------------------------------");
			}
		} else {

			System.out.println("未查询到数据");

		}
	}

	@Test
	public void selectAllRolesTest() {
		List<Roles> roleList = this.accountService.selectAllRoles();
		if (roleList != null && roleList.size() > 0) {
			for (Roles role : roleList) {
				System.out.println("------------------------------");
				System.out.println(role.toString());
				System.out.println("------------------------------");
			}
		} else {

			System.out.println("未查询到数据");

		}
	}

	@Test
	public void forbiddernOrEnableUser() {

		int num = this.accountService.forbiddenUser(17);

		if (num > 0) {
			System.out.println("禁用成功");
		} else {
			System.out.println("禁用失败");

		}

		System.out.println("--------------------------------");
		int num2 = this.accountService.enableUser(17);

		if (num2 > 0) {
			System.out.println("启用成功");
		} else {
			System.out.println("启用失败");

		}

	}

	@Test
	public void selectSingleUser() {
		User user = this.accountService.selectUserByUserName("demo03");// this.accountService.selectUserByUserid(1);

		if (user != null) {
			System.out.println("-----------------------------");
			System.out.println(user.toString());
			System.out.println("-----------------------------");
		} else {
			System.out.println("未查询到数据");
		}
	}

	@Test
	public void accountQueryTest() {

		List<UserResultM> UserResultMList = this.accountService.selectAllUsers(null);

		if (UserResultMList != null && UserResultMList.size() > 0) {

			for (UserResultM userResultM : UserResultMList) {

				System.out.println("--------------------------");
				System.out.println(userResultM.toString());
			}
		} else {
			System.out.println("没有查询到数据");
		}

	}

	@Test
	public void accountTest() {

		User user = new User();
		// user.setUserid(2);
		// user.setEnabled(1);
		user.setUsername("lvbo");
		user.setPassword(new BCryptPasswordEncoder(4).encode("wdw123"));
		user.setEnabled(1);

		int onOfRowsInserted = this.accountService.insertUser(user);

		if (onOfRowsInserted > 0) {
			System.out.println("----------------------");
			System.out.println("插入成功");
			System.out.println(user.toString());
			System.out.println("----------------------");
		} else {
			System.out.println("----------------------");
			System.out.println("插入失败");
			System.out.println("----------------------");
		}

	}

	@Test
	public void testQueryData() {
		CustomerRequirementM customerRequirementM = new CustomerRequirementM();
		// customerRequirementM.setDymin(100);
		// customerRequirementM.setDymax(600);
		// customerRequirementM.setDlmin(100);
		// customerRequirementM.setDlmax(200);
		// customerRequirementM.setDcxslmin(1);
		// customerRequirementM.setDcxslmax(20);

		// customerRequirementM.setCc("TA");
		// List<BatteryConfigM> lists =
		// this.batteryDao.queryByConditionModel(customerRequirementM);
		// List<BatteryConfigM> lists =
		// this.batteryService.queryData(customerRequirementM);
		// if (lists != null && lists.size() > 0) {
		// for (BatteryConfigM list : lists) {
		//
		// System.out.println(list.toString());
		// }
		// } else {
		// System.out.println("---------未查询到数据----------");
		// }

		// BatteryConfigM batteryConfigM =
		// this.batteryService.queryById("2a064612-fb4d-421b-831a-6f55290e6065");
		//
		// if (batteryConfigM != null) {
		// System.out.println(batteryConfigM.toString());
		// } else {
		// System.out.println("未查询到数据");
		// }

		// OutputM outputm =
		// this.batteryOutputService.queryById("2a064612-fb4d-421b-831a-6f55290e6065");
		//
		// if (outputm != null) {
		// System.out.println(outputm.toString());
		// } else {
		// System.out.println("未查询到数据");
		// }
		// BatteryParamRequirementM batteryParamRequirementM = new
		// BatteryParamRequirementM();
		// batteryParamRequirementM.setXxh("B箱（820*660*250）");
		// batteryParamRequirementM.setDm("A4");
		// List<BatteryParamM> batteryParamMList =
		// this.batteryParamDao.queryByAnyCondition(batteryParamRequirementM);
		// if (batteryParamMList != null && batteryParamMList.size() > 0) {
		//
		// for (BatteryParamM batteryParamM : batteryParamMList) {
		// System.out.println("-------------------------------------");
		// System.out.println(batteryParamM.toString());
		// System.out.println("-------------------------------------");
		// }
		// } else {
		// System.out.println("未查询到数据");
		// }
		// System.out.println("------------------------------");
		//
		// System.out.println(
		// this.batteryParamService.queryBatteryParamById("d626335c-d6bc-4f28-9131-8921815b4b1b").toString());
		// System.out.println("------------------------------");

		// BatteryParamResultM batteryParamResultM =
		// this.batteryParamService.queryData(batteryParamRequirementM);
		// if (batteryParamResultM != null) {
		// if (batteryParamResultM.getMsg().equalsIgnoreCase("s")) {
		// List<BatteryParamM> batteryParamMResult =
		// batteryParamResultM.getBatteryParamMResult();
		// if (batteryParamMResult != null && batteryParamMResult.size() > 0) {
		//
		// for (BatteryParamM batteryParamM : batteryParamMResult) {
		// System.out.println("------------------------------");
		// System.out.println(batteryParamM.toString());
		// System.out.println("------------------------------");
		// }
		//
		// } else {
		// System.out.println("未查询到数据");
		// }
		//
		// } else {
		// System.out.println("未查询到数据");
		// }
		// }

		BatteryParamM batteryParamM = new BatteryParamM();
		// batteryParamM.setId("a9470f5a-d1de-4ecb-b32f-e861633fd016");
		batteryParamM.setXxh("1");
		batteryParamM.setCpbh("1");
		batteryParamM.setDm("1");
		batteryParamM.setCbs1("1");
		batteryParamM.setCbs2("1");
		batteryParamM.setCbs3(1);
		batteryParamM.setCbs4("1");
		batteryParamM.setDtdxbcdl(1);
		batteryParamM.setDtdxgzdy(1);
		batteryParamM.setDxdl(1);
		batteryParamM.setSjdl(1);
		batteryParamM.setZlexptc(1);
		batteryParamM.setZlinptc(1);
		batteryParamM.setDxnlmdexptc(1);
		batteryParamM.setDxnlmdinptc(1);
		batteryParamM.setSjnlmdexptc(1);
		batteryParamM.setSjnlmdinptc(1);

		batteryParamM.setXtrl(1);
		batteryParamM.setXtdy(1);
		batteryParamM.setBzxczxl(1);
		batteryParamM.setBzxczxlexptc(1);
		int noofRowsInserted = this.batteryParamService.insertBatteryParamM(batteryParamM);
		System.out.println("-------------------------");
		System.out.println("noofRowsInserted=" + noofRowsInserted);

		if (noofRowsInserted > 0) {
			System.out.println("-------------------------");
			// System.out.println(batteryParamM.toString());
			System.out.println("插入了" + noofRowsInserted + "条数据");
			System.out.println("-------------------------");
		} else {
			System.out.println("-------------------------");
			System.out.println("插入失败");
			System.out.println("-------------------------");
		}

		// List<BatteryXXH> BatteryXXHList =
		// this.batteryParamService.queryDistinctXXH();
		// if (BatteryXXHList != null) {
		// for (BatteryXXH batteryXXH : BatteryXXHList) {
		// System.out.println(batteryXXH.toString()+"------箱型号");
		// }
		// }else {
		// System.out.println("----------------箱-型号无-------------------");
		// }
		//
		//
		// List<BatteryCPBH> BatteryCPBHList =
		// this.batteryParamService.queryDistinctCPBH();
		// if (BatteryCPBHList != null) {
		// for (BatteryCPBH batteryCPBH : BatteryCPBHList) {
		// System.out.println(batteryCPBH.toString()+"------产品编号");
		// }
		// }else {
		// System.out.println("----------------产品编号无-------------------");
		// }
		//
		//
		// List<BatteryDM> BatteryDMList =
		// this.batteryParamService.queryDistinctDM();
		// if (BatteryDMList != null) {
		// for (BatteryDM batteryDM : BatteryDMList) {
		// System.out.println(batteryDM.toString()+"------代码");
		// }
		// }else {
		// System.out.println("----------------代码无-------------------");
		// }

	}

	@Test
	public void testDM() {
		System.out.println("-------------------------------------------------------------");
		System.out.println(this.batteryParamService.queryBatteryParamByDm("A4").toString());
		System.out.println("-------------------------------------------------------------");
	}

	public BatteryDao getBatteryDao() {
		return batteryDao;
	}

	@Autowired
	@Required
	public void setBatteryDao(@Qualifier("defaultBatteryDao") BatteryDao batteryDao) {
		this.batteryDao = batteryDao;
	}

	public BatteryService getBatteryService() {
		return batteryService;
	}

	@Autowired
	@Required
	public void setBatteryService(@Qualifier("defaultBatteryService") BatteryService batteryService) {
		this.batteryService = batteryService;
	}

	public BatteryOutputService getBatteryOutputService() {
		return batteryOutputService;
	}

	@Autowired
	@Required
	public void setBatteryOutputService(
			@Qualifier("defaultBatteryOutputService") BatteryOutputService batteryOutputService) {
		this.batteryOutputService = batteryOutputService;
	}

	public BatteryParamDao getBatteryParamDao() {
		return batteryParamDao;
	}

	@Autowired
	@Required
	public void setBatteryParamDao(@Qualifier("defaultBatteryParamDao") BatteryParamDao batteryParamDao) {
		this.batteryParamDao = batteryParamDao;
	}

	public BatteryParamService getBatteryParamService() {
		return batteryParamService;
	}

	@Autowired
	@Required
	public void setBatteryParamService(
			@Qualifier("defaultBatteryParamService") BatteryParamService batteryParamService) {
		this.batteryParamService = batteryParamService;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Autowired
	@Required
	public void setAccountDao(@Qualifier("defaultAccountDao") AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Autowired
	@Required
	public void setAccountService(@Qualifier("defaultAccountService") AccountService accountService) {
		this.accountService = accountService;
	}

}
