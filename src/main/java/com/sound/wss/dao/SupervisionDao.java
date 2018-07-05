package com.sound.wss.dao;

import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.po.SupervisionDO;

public interface SupervisionDao {

	/**
	 * 督办工作项
	 * @param supervisionCriteriaDTO
	 * @return
	 */
	public java.util.List<SupervisionDO> listSupervisionItem(SupervisionCriteriaDTO supervisionCriteriaDTO);

}
