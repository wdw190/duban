package com.sound.wss.service;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.bo.WorkTaskResultBO;


public interface OrgService {
	
	public WorkTaskResultBO<OrgBO> listOrgInfo(Integer deptId);
	
	
	public WorkTaskResultBO<TreeNodeBO> dealTreeNodes(Integer deptId);
	
	public void dealOrg();
	
	public void dealUser();

}
