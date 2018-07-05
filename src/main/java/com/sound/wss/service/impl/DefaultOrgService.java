package com.sound.wss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dao.OrgDao;
import com.sound.wss.service.OrgService;

@Service("defaultOrgService")
public class DefaultOrgService implements OrgService {

	private OrgDao orgDao;

	@Override
	public WorkTaskResultBO<OrgBO> listOrgInfo(Integer deptId) {

		WorkTaskResultBO<OrgBO> workTaskResultBO = new WorkTaskResultBO<OrgBO>();

		try {
			List<OrgBO> orgBOList = this.orgDao.listAllOrgs(deptId);
			if (orgBOList != null && orgBOList.size() > 0) {

				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(orgBOList);

			} else {

				workTaskResultBO.setFlag("none");

			}
		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;
	}

	@Override
	public WorkTaskResultBO<TreeNodeBO> dealTreeNodes(Integer deptId) {

		WorkTaskResultBO<TreeNodeBO> workTaskResultBO = new WorkTaskResultBO<TreeNodeBO>();

		try {
			List<TreeNodeBO> treeNodeBOList = this.orgDao.listAllNodes(deptId);
			if (treeNodeBOList != null && treeNodeBOList.size() > 0) {

				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(treeNodeBOList);

			} else {

				workTaskResultBO.setFlag("none");

			}
		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;
	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	@Autowired
	@Required
	public void setOrgDao(@Qualifier("defaultOrgDao") OrgDao orgDao) {
		this.orgDao = orgDao;
	}

}
