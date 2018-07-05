package com.sound.wss.bo;

import java.util.List;

import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.WorkTaskActionDO;

public class WorkTaskActionSimpleBO extends WorkTaskActionDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5488845728421983702L;
	
	private List<FileAttachmentDO> fileAttachmentDOList;

	public List<FileAttachmentDO> getFileAttachmentDOList() {
		return fileAttachmentDOList;
	}

	public void setFileAttachmentDOList(List<FileAttachmentDO> fileAttachmentDOList) {
		this.fileAttachmentDOList = fileAttachmentDOList;
	}

	@Override
	public String toString() {
		return "WorkTaskActionSimpleBO [fileAttachmentDOList=" + fileAttachmentDOList + "]";
	}
	
	

}
