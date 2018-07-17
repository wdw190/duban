package com.sound.wss.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.po.OrgDeptDO;
import com.sound.wss.po.OrgUserDO;

@Mapper
public interface OrgMapper {
	
	
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
