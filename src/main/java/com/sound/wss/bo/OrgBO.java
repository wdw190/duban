package com.sound.wss.bo;

import java.io.Serializable;
import java.util.List;

import com.sound.wss.po.OrgDeptDO;
import com.sound.wss.po.OrgUserDO;

public class OrgBO extends OrgDeptDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1232922580085328226L;

	private List<OrgDeptDO> orgDeptDOList;

	private List<OrgUserDO> orgUserDOList;

	public List<OrgDeptDO> getOrgDeptDOList() {
		return orgDeptDOList;
	}

	public void setOrgDeptDOList(List<OrgDeptDO> orgDeptDOList) {
		this.orgDeptDOList = orgDeptDOList;
	}

	public List<OrgUserDO> getOrgUserDOList() {
		return orgUserDOList;
	}

	public void setOrgUserDOList(List<OrgUserDO> orgUserDOList) {
		this.orgUserDOList = orgUserDOList;
	}

	@Override
	public String toString() {
		return "OrgBO [orgDeptDOList=" + orgDeptDOList + ", orgUserDOList=" + orgUserDOList + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
