package com.sound.wss.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.sound.wss.bo.WorkItemBO;
import com.sound.wss.dao.WorkItemDao;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.mybatis.mapper.WorkItemMapper;
import com.sound.wss.po.FileAttachmentDO;
import com.sound.wss.po.NumberingDO;
import com.sound.wss.po.WorkItemDO;

@Repository("defaultWorkItemDao")
public class DefaultWorkItemDao implements WorkItemDao {

	private SqlSession sqlSession;

	@Override
	public NumberingDO queryNumbering(String parameter) {
		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);
		return mapper.queryNumbering(parameter);
	}

	@Override
	public NumberingDO queryTaskItemNumbering(String parameter) {
		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);
		return mapper.queryTaskItemNumbering(parameter);
	}

	@Override
	public int insertWorkItem(WorkItemDO workItemDO) {

		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);

		return mapper.insertWorkItem(workItemDO);
	}

	@Override
	public int insertFileAttachment(List<FileAttachmentDO> fileAttachmentDOList) {

		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);

		return mapper.insertFileAttachment(fileAttachmentDOList);
	}

	@Override
	public List<WorkItemDO> listWorkItem(WorkItemCriteriaDTO workItemCriteriaDTO) {
		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);
		return mapper.listWorkItem(workItemCriteriaDTO);
	}
	
	
	

	@Override
	public WorkItemBO singleWorkItemInfo(String workId) {
		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);
		return mapper.singleWorkItemInfo(workId);
	}
	
	
	

	@Override
	public int updateWorkItem(WorkItemDO workItemDO) {
		WorkItemMapper mapper = this.sqlSession.getMapper(WorkItemMapper.class);
		return mapper.updateWorkItem(workItemDO);
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
