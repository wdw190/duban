package com.sound.wss.dao;

import java.util.List;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.po.OrgDeptDO;
import com.sound.wss.po.OrgUserDO;

public interface OrgDao {
	
	public List<OrgBO> listAllOrgs(Integer deptId);
	
	public List<TreeNodeBO> listAllNodes(Integer deptId);
	
	/**
	 * 批量插入部门
	 * @param list
	 * @return
	 */
	public int insertOrgDeptDO(java.util.List<OrgDeptDO> list);
	/**
	 * 批量插入人员
	 * @param list
	 * @return
	 */
	public int insertOrgUserDO(java.util.List<OrgUserDO> list);

}
