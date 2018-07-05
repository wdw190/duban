package com.sound.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sound.account.mybatis.model.AccountResultM;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserCriticalM;
import com.sound.account.mybatis.model.UserResultM;
import com.sound.account.mybatis.model.UserRoles;
import com.sound.account.service.AccountService;
import com.sound.model.ResponseMessageM;

@RestController
public class AccountController {

	private AccountService accountService;

	@RequestMapping(value = "/account/querydata", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public AccountResultM queryAccountData(@RequestBody UserCriticalM userCriticalM) {

		AccountResultM accountResultM = new AccountResultM();

		List<UserResultM> userResultM = this.accountService.selectAllUsers(userCriticalM);

		if (userResultM != null && userResultM.size() > 0) {
			accountResultM.setMsg("S");
			accountResultM.setUserResultM(userResultM);
		} else {
			accountResultM.setMsg("F");
			accountResultM.setUserResultM(null);
		}
		return accountResultM;
	}

	/**
	 * 新增用户 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */

	@RequestMapping(value = "/account/adddata", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM addUser(@RequestBody User user) {

		ResponseMessageM responseMessageM = new ResponseMessageM();

		user.setEnabled(1);
		user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword().trim()));

		int onOfRowsInserted = this.accountService.insertUser(user);

		if (onOfRowsInserted > 0) {
			responseMessageM.setMsg("新增用户成功");
			responseMessageM.setFlag("S");
		} else {
			responseMessageM.setMsg("新增用户失败，请重试!!");
			responseMessageM.setFlag("F");
		}

		return responseMessageM;
	}

	/**
	 * 修改用户信息 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */
	@RequestMapping(value = "/account/updateuserinfo", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM updateUserPassword(@RequestBody User user) {

		ResponseMessageM responseMessageM = new ResponseMessageM();

		user.setPassword(new BCryptPasswordEncoder(4).encode(user.getPassword().trim())); // 密码加密
		int onOfRowsUpdated = this.accountService.updateUser(user);
		if (onOfRowsUpdated > 0) {
			responseMessageM.setMsg("修改成功");
			responseMessageM.setFlag("S");
		} else {
			responseMessageM.setMsg("修改失败，请重试!!");
			responseMessageM.setFlag("F");
		}

		return responseMessageM;
	}

	@RequestMapping(value = "/account/updateusername", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM updateUserName(@RequestBody User user) {

		ResponseMessageM responseMessageM = new ResponseMessageM();

		int onOfRowsUpdated = this.accountService.updateUser(user);
		if (onOfRowsUpdated > 0) {
			responseMessageM.setMsg("修改成功");
			responseMessageM.setFlag("S");
		} else {
			responseMessageM.setMsg("修改失败，请重试!!");
			responseMessageM.setFlag("F");
		}

		return responseMessageM;
	}

	/**
	 * 基于用户名检查用户是否存在 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */
	@RequestMapping(value = "/account/checkuser", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM checkUser(@RequestBody User user) {

		// System.out.println("----------------------------");
		// System.out.println(user.toString());
		// System.out.println("----------------------------");

		ResponseMessageM responseMessageM = new ResponseMessageM();

		User userChecked = this.accountService.selectUserByUserName(user.getUsername());
		if (userChecked != null) {
			responseMessageM.setFlag("exist");
			responseMessageM.setMsg("用户名已存在");
		} else {
			responseMessageM.setFlag("notexist");
			responseMessageM.setMsg("用户名可用");
		}

		System.out.println(responseMessageM.toString());

		return responseMessageM;
	}

	/**
	 * 禁用 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */
	@RequestMapping(path = "/account/forbidden/{userid}")
	@ResponseBody
	public ResponseMessageM forbiddenUser(@PathVariable(name = "userid") int userid) {
		ResponseMessageM responseMessageM = new ResponseMessageM();
		int onOfRowsForbidden = this.accountService.forbiddenUser(userid);
		if (onOfRowsForbidden > 0) {
			responseMessageM.setFlag("S");
			responseMessageM.setMsg("账号禁用成功");
		} else {
			responseMessageM.setFlag("F");
			responseMessageM.setMsg("账号禁用失败");
		}
		// System.out.println(responseMessageM.toString());
		return responseMessageM;
	}

	/**
	 * 启用 @Title: @Description: (这里用一句话描述这个方法的作用) @param @return
	 * ResponseMessageM 返回类型 @throws
	 *
	 */
	@RequestMapping(path = "/account/enable/{userid}")
	@ResponseBody
	public ResponseMessageM enableUser(@PathVariable(name = "userid") int userid) {
		ResponseMessageM responseMessageM = new ResponseMessageM();
		int onOfRowsForbidden = this.accountService.enableUser(userid);
		if (onOfRowsForbidden > 0) {
			responseMessageM.setFlag("S");
			responseMessageM.setMsg("账号启用成功");
		} else {
			responseMessageM.setFlag("F");
			responseMessageM.setMsg("账号啟用失败");
		}
		// System.out.println(responseMessageM.toString());
		return responseMessageM;
	}

	@RequestMapping(value = "/account/updateroles", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ResponseMessageM updateUserRoles(@RequestBody UserRoles userRoles) {

		int effectRowsDeleted = -1;// 影响的行数
		int effectRowsInserted = -1;// 影响的行数
		boolean insertAndDeleteFlag = false;

		System.out.println("----------------------------");
		System.out.println(userRoles.toString());
		System.out.println("----------------------------");

		if (userRoles.getRole() != null && userRoles.getRole().trim().length() > 0) {
			// 查询用户已有的角色
			List<UserRoles> userRolesList = this.accountService.selectUserRolesByUserID(userRoles.getUserid());

			// java.util.Map<String, UserRoles> userOwnedRoles = new
			// HashMap<String, UserRoles>();
			//
			// if (userRolesList != null && userRolesList.size() > 0) {
			// for (UserRoles urole : userRolesList) {
			// userOwnedRoles.put(urole.getRole(), urole);
			// }
			// }

			// 前台传过来的角色
			String[] rolesCandidate = userRoles.getRole().substring(0, userRoles.getRole().length() - 1).split(",");

			java.util.List<String> rolesCandidateList = Arrays.asList(rolesCandidate);

			// 如果用户擁有角色
			if (userRolesList != null && userRolesList.size() > 0) {

				// 用户已拥有的角色列表
				List<String> userOwnedRoles = new ArrayList<String>();
				for (UserRoles urole : userRolesList) {
					userOwnedRoles.add(urole.getRole());
				}
				// 判断哪些是新增的角色

				java.util.List<String> newRoles = new ArrayList<String>();

				for (String newrole : rolesCandidateList) {
					if (!userOwnedRoles.contains(newrole)) {
						newRoles.add(newrole);
					}
				}

				// 判断哪些是需要删除的角色
				java.util.List<String> delRoles = new ArrayList<String>();
				for (String delrole : userOwnedRoles) {
					if (!rolesCandidateList.contains(delrole)) {
						delRoles.add(delrole);
					}
				}

				insertAndDeleteFlag = this.accountService.insertAndDelUserRoles(userRoles.getUserid(), newRoles,
						delRoles);

			} else {

				// 用户无任何角色的话，直接插入前台传过来的角色

				java.util.List<UserRoles> insertUserRolesList = new ArrayList<UserRoles>();
				for (String userrole : rolesCandidate) {
					UserRoles tempUserRole = new UserRoles();
					tempUserRole.setUserid(userRoles.getUserid());
					tempUserRole.setRole(userrole);
					insertUserRolesList.add(tempUserRole);
				}

				effectRowsInserted = this.accountService.insertUserRoles(insertUserRolesList);
			}

		} else {
			// 删除所有的角色

			effectRowsDeleted = this.accountService.deleteUserRoleByUserId(userRoles.getUserid());
		}

		ResponseMessageM responseMessageM = new ResponseMessageM();
		
		if(effectRowsDeleted > -1 || effectRowsInserted >0 || insertAndDeleteFlag == true){
			responseMessageM.setFlag("S");
			responseMessageM.setMsg("角色更新成功");
		}else{
			responseMessageM.setFlag("F");
			responseMessageM.setMsg("角色更新失败");
		}

		return responseMessageM;
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
