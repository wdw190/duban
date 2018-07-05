package com.sound.wss.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;

@Mapper
public interface OrgMapper {
	
	
	public List<OrgBO> listAllOrgs(Integer deptId);
	
	public List<TreeNodeBO> listAllNodes(Integer deptId);

}
