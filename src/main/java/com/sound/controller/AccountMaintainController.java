package com.sound.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sound.account.mybatis.model.Roles;
import com.sound.account.mybatis.model.User;
import com.sound.account.mybatis.model.UserRoles;
import com.sound.account.service.AccountService;

@Controller
@RequestMapping(path = "/accountmaintain")
public class AccountMaintainController {

	private AccountService accountService;

	@GetMapping(path = "/index")
	public ModelAndView accountIndex() {
		ModelAndView mav = new ModelAndView("account/index");
		return mav;
	}

	@GetMapping(path = "/new")
	public ModelAndView createAccount() {
		ModelAndView mav = new ModelAndView("account/create");
		return mav;
	}

	@GetMapping(path = "/maintain/{userid}")
	public ModelAndView maintainAccount(@PathVariable(name = "userid") int userid) {
		ModelAndView mav = new ModelAndView("account/maintain");

		User user = this.accountService.selectUserByUserid(userid);

		List<Roles> rolesList = this.accountService.selectAllRoles();

		Map<String, Roles> mapRoles = new HashMap<String, Roles>();

		if (rolesList != null && rolesList.size() > 0) {

			for (Roles role : rolesList) {
				mapRoles.put(role.getRole(), role);
				// System.out.println("---------------------------------");
				// System.out.println(role.toString());
				// System.out.println("---------------------------------");

			}

		}

		List<UserRoles> userRolesList = this.accountService.selectUserRolesByUserID(userid);

		if (mapRoles != null && mapRoles.entrySet().size() > 0 && userRolesList != null && userRolesList.size() > 0) {

			for (UserRoles userRole : userRolesList) {

				if (mapRoles.containsKey(userRole.getRole())) {
					mapRoles.get(userRole.getRole()).setHave(1);
				}
			}

		}

		mav.addObject("accountuser", user);
		mav.addObject("rolesList", rolesList);

		return mav;
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
