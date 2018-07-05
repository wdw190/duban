package com.sound;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.wss.constants.WorkItemTypeEnum;
import com.sound.wss.dao.WorkItemDao;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.NumberingDO;
import com.sound.wss.po.WorkItemDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkItemDaoTest {

	private WorkItemDao workItemDao;

	@Test
	public void m1() {

		WorkItemDO workItemDO = new WorkItemDO();

		workItemDO.setCreated("2018-06-15 11:20:20");
		workItemDO.setReporter("wangdaowen");
		workItemDO.setWorkDescription("工作项详细描述");
		workItemDO.setWorkSummary("工作项概述");
		workItemDO.setWorkType(WorkItemTypeEnum.GROUPWORK.name());
		workItemDO.setWorkId("GROUPWORKSUPERVISION201806150001");

		int insertedCount = this.workItemDao.insertWorkItem(workItemDO);
		if (insertedCount == 1) {
			System.out.println("------------------------");
		}

	}

	@Test
	public void m2() {

		java.util.List<FileAttachmentDO> fileAttachmentDOList = new ArrayList<FileAttachmentDO>();

		FileAttachmentDO fileAttachmentDO1 = new FileAttachmentDO();
		fileAttachmentDO1.setAuthor("wangdaowen");
		fileAttachmentDO1.setCreated("2018-06-15 11:43:43");
		fileAttachmentDO1.setFilename("测试.doc");
		fileAttachmentDO1.setFilesize(11);
		fileAttachmentDO1.setId(UUID.randomUUID().toString());
		fileAttachmentDO1.setMimetype("doc");
		fileAttachmentDO1.setPath("SoundWSS/测试.doc");
		fileAttachmentDO1.setWorkOrTaskId("workid");
		FileAttachmentDO fileAttachmentDO2 = new FileAttachmentDO();
		fileAttachmentDO2.setAuthor("wangdaowen");
		fileAttachmentDO2.setCreated("2018-06-15 11:43:43");
		fileAttachmentDO2.setFilename("测试.doc");
		fileAttachmentDO2.setFilesize(11);
		fileAttachmentDO2.setId(UUID.randomUUID().toString());
		fileAttachmentDO2.setMimetype("doc");
		fileAttachmentDO2.setPath("SoundWSS/测试.doc");
		fileAttachmentDO2.setWorkOrTaskId("workid");

		fileAttachmentDOList.add(fileAttachmentDO1);
		fileAttachmentDOList.add(fileAttachmentDO2);

		this.workItemDao.insertFileAttachment(fileAttachmentDOList);

	}

	@Test
	public void m3() {

		NumberingDO numberingDO = this.workItemDao.queryNumbering("GROUPWORK20180615");

		System.out.println("-----------------------------------------------------");

		System.out.println(numberingDO.toString());

		System.out.println("-----------------------------------------------------" + String.format("%04d", 10));

		String.format("%04d", 10);

	}

	@Test
	public void m4() {
		System.out.println("-----------------------------------------------------");
		this.workItemDao.listWorkItem(new WorkItemCriteriaDTO() ).stream().forEach((wi) -> System.out.println(wi.toString()));
		System.out.println("-----------------------------------------------------");

	}
	
	@Test
	public void m5(){
		
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------"+this.workItemDao.singleWorkItemInfo("GROUPWORK201806210001").toString());
		System.out.println("-----------------------------------------------------");
	}

	public WorkItemDao getWorkItemDao() {
		return workItemDao;
	}

	@Autowired
	@Required
	public void setWorkItemDao(@Qualifier("defaultWorkItemDao") WorkItemDao workItemDao) {
		this.workItemDao = workItemDao;
	}

}
