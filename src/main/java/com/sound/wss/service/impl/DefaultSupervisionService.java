package com.sound.wss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dao.SupervisionDao;
import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.po.SupervisionDO;
import com.sound.wss.service.SupervisionService;

@Service("defaultSupervisionService")
public class DefaultSupervisionService implements SupervisionService {

	private SupervisionDao supervisionDao;

	@Override
	public WorkTaskResultBO<SupervisionDO> listSupervisionItem(SupervisionCriteriaDTO supervisionCriteriaDTO) {

		WorkTaskResultBO<SupervisionDO> workTaskResultBO = new WorkTaskResultBO<SupervisionDO>();

		try {
			List<SupervisionDO> supervisionDOList = this.supervisionDao.listSupervisionItem(supervisionCriteriaDTO);

			if (supervisionDOList != null && supervisionDOList.size() > 0) {
				workTaskResultBO.setFlag("success");
				workTaskResultBO.setWorkTaskList(supervisionDOList);
			} else {
				workTaskResultBO.setFlag("none");
			}

		} catch (Exception e) {
			workTaskResultBO.setFlag("failed");
			workTaskResultBO.setMsg(e.getMessage());
		}

		return workTaskResultBO;
	}

	public SupervisionDao getSupervisionDao() {
		return supervisionDao;
	}

	@Autowired
	@Required
	public void setSupervisionDao(@Qualifier("defaultSupervisionDao") SupervisionDao supervisionDao) {
		this.supervisionDao = supervisionDao;
	}

}
