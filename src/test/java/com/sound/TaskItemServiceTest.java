package com.sound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.service.TaskItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskItemServiceTest {

	private TaskItemService taskItemService;

	private TaskItemDao taskItemDao;

	@Test
	public void m1() {
		MyTaskCriteriaDTO myTaskCriteriaDTO = new MyTaskCriteriaDTO();
		myTaskCriteriaDTO.setAssignee("wangfeixiang");
		myTaskCriteriaDTO.setTaskResolution("open");
		WorkTaskResultBO<TaskItemDO> workTaskResultBO = this.taskItemService.listMyTask(myTaskCriteriaDTO);
		System.out.println("----------------------------------------------");
		workTaskResultBO.getWorkTaskList().stream().forEach((temp) -> System.out.println(temp.toString()));
		System.out.println(workTaskResultBO.toString());

	}
	
	
	@Test
	public void m2(){
		System.out.println("----------------------------------------------");
		TaskItemDetailsBO taskItemDetailsBO=this.taskItemDao.viewSingleTaskItemInfo("5665778b-88c1-414f-b188-45ab71c3f014");
		System.out.println(taskItemDetailsBO.toString());
		System.out.println("----------------------------------------------");
	}

	public TaskItemService getTaskItemService() {
		return taskItemService;
	}

	@Autowired
	@Required
	public void setTaskItemService(@Qualifier("defaultTaskItemService") TaskItemService taskItemService) {
		this.taskItemService = taskItemService;
	}

	public TaskItemDao getTaskItemDao() {
		return taskItemDao;
	}

	@Autowired
	@Required
	public void setTaskItemDao(@Qualifier("defaultTaskItemDao") TaskItemDao taskItemDao) {
		this.taskItemDao = taskItemDao;
	}

}
