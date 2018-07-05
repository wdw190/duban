package com.sound.roles.controller;

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

import com.sound.roles.bo.RoleBO;
import com.sound.roles.dao.RoleDao;
import com.sound.roles.po.MenuDO;
import com.sound.roles.po.RoleMenuDO;

@Controller
@RequestMapping(path = "/roles")
public class RolesController {

	private RoleDao roleDao;

	@GetMapping(path = "/index")
	public ModelAndView roleIndex() {
		ModelAndView mav = new ModelAndView("roles/index");
		return mav;
	}

	@GetMapping(path = "/new")
	public ModelAndView roleNew() {
		ModelAndView mav = new ModelAndView("roles/new");

		mav.addObject("menulist", this.roleDao.listAllMenus());
		return mav;
	}
	
	
	@GetMapping(path = "/modifyrole/{roleId}")
	public ModelAndView roleModify(@PathVariable(name="roleId") int roleId) {
		
		ModelAndView mav = new ModelAndView("roles/modify");
		
		List<MenuDO> menuDOList=this.roleDao.listAllMenus();
		
		Map<String,MenuDO> map = new HashMap<String,MenuDO>();
		
		for(MenuDO menuDO:menuDOList){
			map.put(menuDO.getMenuId(), menuDO);
		}
		
		RoleBO roleBO=this.roleDao.singleRoleInfo(roleId);
		
		for(RoleMenuDO roleMenuDO:roleBO.getRoleMenuDOList()){
			if(map.containsKey(roleMenuDO.getMenuId())){
				map.get(roleMenuDO.getMenuId()).setHaved("1");
			}
		}

		mav.addObject("roleBO", roleBO);
		
		mav.addObject("menuDOList", menuDOList);
		return mav;
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
