package com.sound.wss.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sound.exception.WSSException;
import com.sound.wss.bo.WorkItemBO;
import com.sound.wss.bo.WorkItemResultBO;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.po.WorkItemDO;

public interface WorkItemService {
	
	/**
	 * 初始化工作项内容
	 * @return
	 */
	public WorkItemDO initWorkItemDO(String parameter);
	
	/**
	 * 保存工作项
	 * @param workItemPO
	 * @param files
	 * @param request
	 * @return
	 */
	public ActionResultDTO saveWorkItem(WorkItemDO workItemPO,MultipartFile[] files, HttpServletRequest request) throws WSSException;
	
	/**
	 *  查询工作项
	 * @param workItemCriteriaDTO
	 * @return
	 */
	public WorkItemResultBO listWorkItem(WorkItemCriteriaDTO workItemCriteriaDTO);
	
	
	public WorkItemBO singleWorkItemInfo(String workId); 
	
	/**
	 * 编辑保存
	 * @param workItemPO
	 * @return
	 */
	public WorkItemResultBO updateWorkItem(WorkItemDO workItemDO);

}
