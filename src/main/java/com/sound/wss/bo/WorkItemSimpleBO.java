package com.sound.wss.bo;

import java.util.List;

import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.WorkItemDO;

public class WorkItemSimpleBO extends WorkItemDO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2913230046743021195L;

	private List<FileAttachmentDO> fileAttachmentDOList;

	public List<FileAttachmentDO> getFileAttachmentDOList() {
		return fileAttachmentDOList;
	}

	public void setFileAttachmentDOList(List<FileAttachmentDO> fileAttachmentDOList) {
		this.fileAttachmentDOList = fileAttachmentDOList;
	}

	@Override
	public String toString() {
		return "WorkItemSimpleBO [fileAttachmentDOList=" + fileAttachmentDOList + "]";
	}

}
