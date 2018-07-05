package com.sound.wss.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.sound.exception.WSSException;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.po.WorkTaskActionDO;

public interface WorkTaskActionService {
	/**
	 * 新增沟通内容
	 * @param workTaskActionDO
	 * @param files
	 * @param request
	 * @return
	 * @throws WSSException
	 */
	public ActionResultDTO addCommContent(WorkTaskActionDO workTaskActionDO,MultipartFile[] files, HttpServletRequest request) throws WSSException;
	
	
	
	public void approvalTask(WorkTaskActionDO workTaskActionDO) throws WSSException;

}
