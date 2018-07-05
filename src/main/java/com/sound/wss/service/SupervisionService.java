package com.sound.wss.service;

import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.po.SupervisionDO;

public interface SupervisionService {
	/**
	 * 督办列表
	 * @param supervisionCriteriaDTO
	 * @return
	 */
	public WorkTaskResultBO<SupervisionDO> listSupervisionItem(SupervisionCriteriaDTO supervisionCriteriaDTO);

}
