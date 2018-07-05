package com.sound.wss.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.po.SupervisionDO;

@Mapper
public interface SupervisionMapper {

	/**
	 * 督办工作项
	 * @param supervisionCriteriaDTO
	 * @return
	 */
	public java.util.List<SupervisionDO> listSupervisionItem(SupervisionCriteriaDTO supervisionCriteriaDTO);
	
}
