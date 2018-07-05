package com.sound.wss.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.po.WorkTaskActionDO;

@Mapper
public interface WorkTaskActionMapper {

	/**
	 * 插入任务操作内容
	 * 
	 * @param workTaskActionDO
	 * @return
	 */
	public int insertWorkTaskAction(WorkTaskActionDO workTaskActionDO);

}
