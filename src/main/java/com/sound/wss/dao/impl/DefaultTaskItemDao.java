package com.sound.wss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.mybatis.mapper.TaskItemMapper;
import com.sound.wss.po.DueTaskDO;
import com.sound.wss.po.SupervisionInfoDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkViewDO;

@Repository("defaultTaskItemDao")
public class DefaultTaskItemDao implements TaskItemDao {

	private SqlSession sqlSession;

	@Override
	public int insertTaskItem(TaskItemDO taskItemDO) {

		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);

		return mapper.insertTaskItem(taskItemDO);
	}

	@Override
	public List<TaskItemDO> listMyTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listMyTask(myTaskCriteriaDTO);
	}

	@Override
	public List<TaskItemDO> listMyDoneTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listMyDoneTask(myTaskCriteriaDTO);
	}

	@Override
	public List<TaskActionCombineBO> listMyProcessingTask(MyTaskCriteriaDTO myTaskCriteriaDTO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listMyProcessingTask(myTaskCriteriaDTO);
	}

	@Override
	public TaskActionCombineBO queryLatestTaskItemActionRecord(String taskId) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.queryLatestTaskItemActionRecord(taskId);
	}

	@Override
	public TaskItemDetailsBO viewSingleTaskItemInfo(String taskId) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.viewSingleTaskItemInfo(taskId);
	}

	@Override
	public int updateTaskItemStatusByTaskID(TaskItemDO taskItemDO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.updateTaskItemStatusByTaskID(taskItemDO);
	}

	@Override
	public int completeTaskItemByTaskID(TaskItemDO taskItemDO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.completeTaskItemByTaskID(taskItemDO);
	}

	@Override
	public int updateTaskItemDoByTaskID(TaskItemDO taskItemDO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.updateTaskItemDoByTaskID(taskItemDO);
	}
	
	

	@Override
	public int cancelTaskItemStatusByTaskID(TaskItemDO taskItemDO) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.cancelTaskItemStatusByTaskID(taskItemDO);
	}

	
	
	
	@Override
	public List<SupervisionInfoDO> listAllSupervisionInfos(String assignee) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listAllSupervisionInfos(assignee);
	}
	
	
	

	@Override
	public DueTaskDO listDueTaskInfos(String assignee) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listDueTaskInfos(assignee);
	}
	
	
	

	@Override
	public WorkViewDO listAllWorkViewInfos(String assignee) {
		TaskItemMapper mapper = this.sqlSession.getMapper(TaskItemMapper.class);
		return mapper.listAllWorkViewInfos(assignee);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	@Required
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
