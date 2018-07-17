package com.sound.wss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dao.OrgDao;
import com.sound.wss.po.OrgDeptDO;
import com.sound.wss.po.OrgUserDO;
import com.sound.wss.po.wechat.AllDepts;
import com.sound.wss.po.wechat.AllUserInfos;
import com.sound.wss.po.wechat.Dept;
import com.sound.wss.po.wechat.UserInfo;
import com.sound.wss.service.OrgService;
import com.sound.wss.service.WeChatService;

@Service("defaultOrgService")
public class DefaultOrgService implements OrgService {

	private OrgDao orgDao;

	private WeChatService weChatService;

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

	@Override
	public void dealOrg() {

		AllDepts allDepts = this.weChatService.getWeChatAllDepts();

		if (allDepts.getErrcode().equalsIgnoreCase("0") && allDepts.getErrmsg().equalsIgnoreCase("ok")) {

			List<OrgDeptDO> orgDeptDOList = new ArrayList<OrgDeptDO>();

			for (Dept dept : allDepts.getDepartment()) {
				OrgDeptDO orgDeptDO = new OrgDeptDO();
				orgDeptDO.setDeptId(Integer.valueOf(dept.getId()).intValue());
				orgDeptDO.setDeptName(dept.getName());
				orgDeptDO.setSupDepid(Integer.valueOf(dept.getParentid()).intValue());

				orgDeptDOList.add(orgDeptDO);

				if (orgDeptDOList.size() % 100 == 0) {

					this.orgDao.insertOrgDeptDO(orgDeptDOList);

					orgDeptDOList.clear();

				}
			}

			if (orgDeptDOList.size() > 0) {

				this.orgDao.insertOrgDeptDO(orgDeptDOList);

			}

		} else {

		}

	}

	@Override
	public void dealUser() {

		AllUserInfos allUserInfos = this.weChatService.getWeChatAllUserInfos();

		if (allUserInfos.getErrcode().equalsIgnoreCase("0") && allUserInfos.getErrmsg().equalsIgnoreCase("ok")) {

			java.util.List<OrgUserDO> orgUserDOList = new ArrayList<OrgUserDO>();

			for (UserInfo userInfo : allUserInfos.getUserlist()) {

				OrgUserDO orgUserDO = new OrgUserDO();
				orgUserDO.setId(Integer.valueOf(userInfo.getUserid()).intValue());
				orgUserDO.setWorkerId(userInfo.getMobile().trim());
				orgUserDO.setName(userInfo.getName());
				orgUserDO.setTelephone(userInfo.getTelephone());
				orgUserDO.setMobile(userInfo.getMobile().trim());
				orgUserDO.setJobTitle(userInfo.getPosition());
				orgUserDO.setDeptId(Integer.valueOf(userInfo.getDepartment()[0]).intValue());
				
				System.out.println(orgUserDO.toString());

				orgUserDOList.add(orgUserDO);

				if (orgUserDOList.size() % 100 == 0) {
					this.orgDao.insertOrgUserDO(orgUserDOList);
					orgUserDOList.clear();
				}

			}

			if (orgUserDOList.size() > 0) {

				this.orgDao.insertOrgUserDO(orgUserDOList);

			}

		} else {

		}

	}

	public OrgDao getOrgDao() {
		return orgDao;
	}

	@Autowired
	@Required
	public void setOrgDao(@Qualifier("defaultOrgDao") OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public WeChatService getWeChatService() {
		return weChatService;
	}

	@Autowired
	@Required
	public void setWeChatService(@Qualifier("defaultWeChatService") WeChatService weChatService) {
		this.weChatService = weChatService;
	}

}
