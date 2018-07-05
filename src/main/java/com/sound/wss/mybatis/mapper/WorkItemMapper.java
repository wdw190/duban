package com.sound.wss.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sound.wss.bo.WorkItemBO;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.NumberingDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkItemDO;

/**
 * 
 * @author XPC
 *
 */
@Mapper
public interface WorkItemMapper {
	
	/**
	 * 查询工作项编号
	 * @param parameter
	 * @return
	 */
	public NumberingDO queryNumbering(String parameter);
	public NumberingDO queryTaskItemNumbering(String parameter);
	

	/**
	 * 新增工作项
	 * 
	 * @param workItemDO
	 * @return
	 */
	public int insertWorkItem(WorkItemDO workItemDO);

	/**
	 * 批量插入附件信息
	 * 
	 * @param fileAttachmentDOList
	 * @return
	 */
	public int insertFileAttachment(java.util.List<FileAttachmentDO> fileAttachmentDOList);

	/**
	 * 查询工作项
	 * @param workItemCriteriaDTO
	 * @return
	 */
	public List<WorkItemDO> listWorkItem(WorkItemCriteriaDTO workItemCriteriaDTO);
	
	/**
	 * 查询单个工作项的详情
	 * @param workId
	 * @return
	 */
	public WorkItemBO singleWorkItemInfo(String workId);
	
	/**
	 * 编辑保存
	 * @param workItemDO
	 * @return
	 */
	public int updateWorkItem(WorkItemDO workItemDO);
	
	
}

