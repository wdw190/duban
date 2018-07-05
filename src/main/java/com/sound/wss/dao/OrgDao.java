package com.sound.wss.dao;

import java.util.List;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;

public interface OrgDao {
	
	public List<OrgBO> listAllOrgs(Integer deptId);
	
	public List<TreeNodeBO> listAllNodes(Integer deptId);

}
