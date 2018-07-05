package com.sound.roles.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.exception.WSSException;
import com.sound.roles.bo.RoleResultBO;
import com.sound.roles.bo.SimpleRoleBO;
import com.sound.roles.dao.RoleDao;
import com.sound.roles.dto.RoleCriticalDTO;
import com.sound.roles.dto.RoleDTO;
import com.sound.roles.po.RoleDO;
import com.sound.roles.po.RoleMenuDO;
import com.sound.wss.dto.ActionResultDTO;

@Service("defaultRoleService")
public class DefaultRoleService implements RoleService {

	private RoleDao roleDao;

	@Override
	public RoleResultBO listAllRoles(RoleCriticalDTO roleCriticalDTO) {

		RoleResultBO roleResultBO = new RoleResultBO();

		try {
			List<SimpleRoleBO> simpleRoleBOList = roleDao.listAllRoles(roleCriticalDTO);

			if (simpleRoleBOList != null && simpleRoleBOList.size() > 0) {
				roleResultBO.setFlag("success");
				roleResultBO.setSimpleRoleBOList(simpleRoleBOList);
			} else {
				roleResultBO.setFlag("none");
			}

		} catch (Exception e) {
			roleResultBO.setFlag("failed");
			roleResultBO.setMsg(e.getMessage());

		}

		return roleResultBO;
	}

	@Override
	@Transactional
	public ActionResultDTO addNewRoles(RoleDTO roleDTO) throws WSSException {

		ActionResultDTO actionResultDTO = new ActionResultDTO();

		try {

			RoleDO roleDO = new RoleDO();

			roleDO.setRole(roleDTO.getRoleCode());
			roleDO.setRoleDesc(roleDTO.getRoleDesc());
			this.roleDao.insertRole(roleDO);

			if (roleDTO.getMenus() != null && roleDTO.getMenus().length() > 0) {

				List<RoleMenuDO> list = new ArrayList<>();
				
				String[] menus = roleDTO.getMenus().split(",");
				
				for(String menuid:menus){
					
					RoleMenuDO roleMenuDO = new RoleMenuDO();
					
					roleMenuDO.setRoleId(String.valueOf(roleDO.getRoleId()));
					roleMenuDO.setMenuId(menuid);
					
					list.add(roleMenuDO);
					
				}

				this.roleDao.insertRoleMenus(list);

			}

			actionResultDTO.setFlag("success");

		} catch (Exception e) {

			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
			
			throw new WSSException(e.getMessage());
		}

		return actionResultDTO;
	}
	
	
	

	@Override
	public ActionResultDTO modifyRoles(RoleDTO roleDTO) throws WSSException {
		
		ActionResultDTO actionResultDTO = new ActionResultDTO();
		
		try {
			this.roleDao.deleteRoleMenuByRoleId(String.valueOf(roleDTO.getRoleId()));
			
			if (roleDTO.getMenus() != null && roleDTO.getMenus().length() > 0) {

				List<RoleMenuDO> list = new ArrayList<>();
				
				String[] menus = roleDTO.getMenus().split(",");
				
				for(String menuid:menus){
					
					RoleMenuDO roleMenuDO = new RoleMenuDO();
					
					roleMenuDO.setRoleId(String.valueOf(roleDTO.getRoleId()));
					roleMenuDO.setMenuId(menuid);
					
					list.add(roleMenuDO);
					
				}

				this.roleDao.insertRoleMenus(list);

			}
			
			actionResultDTO.setFlag("success");
		} catch (Exception e) {
			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
			throw new WSSException(e.getMessage());
		}
		
		
		return actionResultDTO;
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
