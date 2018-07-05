package com.sound.roles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sound.roles.bo.RoleResultBO;
import com.sound.roles.dto.RoleCriticalDTO;
import com.sound.roles.dto.RoleDTO;
import com.sound.roles.service.impl.RoleService;
import com.sound.wss.dto.ActionResultDTO;

@RestController
public class RoleRestController {

	private RoleService roleService;

	/**
	 * 查询
	 */
	@RequestMapping(value = "/role/listroles", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public RoleResultBO listRoles(@RequestBody RoleCriticalDTO roleCriticalDTO) {

		return this.roleService.listAllRoles(roleCriticalDTO);
	}
	/**
	 * 新增
	 * @param roleCriticalDTO
	 * @return
	 */
	@RequestMapping(value = "/role/saverole", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ActionResultDTO addNewRoles(@RequestBody RoleDTO roleDTO) {
		
	

		return this.roleService.addNewRoles(roleDTO);
	}
	
	/**
	 * 调整
	 * @param roleDTO
	 * @return
	 */
	@RequestMapping(value = "/role/modifyrole", method = RequestMethod.POST, headers = "content-type=application/json")
	@ResponseBody
	public ActionResultDTO modifyRoles(@RequestBody RoleDTO roleDTO) {
		
	

		return this.roleService.modifyRoles(roleDTO);
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Autowired
	@Required
	public void setRoleService(@Qualifier("defaultRoleService") RoleService roleService) {
		this.roleService = roleService;
	}

}
