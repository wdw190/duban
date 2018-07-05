package com.sound.roles.service.impl;

import com.sound.exception.WSSException;
import com.sound.roles.bo.RoleResultBO;
import com.sound.roles.dto.RoleCriticalDTO;
import com.sound.roles.dto.RoleDTO;
import com.sound.wss.dto.ActionResultDTO;

public interface RoleService {
	
	public RoleResultBO listAllRoles(RoleCriticalDTO roleCriticalDTO);
	
	
	public ActionResultDTO addNewRoles( RoleDTO roleDTO) throws WSSException;
	
	public ActionResultDTO modifyRoles( RoleDTO roleDTO) throws WSSException;
	
	

}
