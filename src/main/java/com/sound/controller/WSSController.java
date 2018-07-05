package com.sound.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.po.DueTaskDO;
import com.sound.wss.po.SupervisionInfoDO;
import com.sound.wss.po.WorkViewDO;
import com.sound.wss.service.WorkItemService;

@Controller
public class WSSController {

	private WorkItemService workItemService;

	private TaskItemDao taskItemDao;

	@RequestMapping("/workitem/treeview")
	public String treeview() {
		return "treeview/treeview";
	}

	/**
	 * 工作录入
	 * 
	 * @return
	 */
	@RequestMapping("/workitem/index")
	public String index() {
		return "workitem/index";
	}

	/**
	 * 任务办理
	 * 
	 * @return
	 */
	@RequestMapping("/workitem/worklist")
	public ModelAndView worklist(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("workitem/worklist");

		HttpSession session = request.getSession(true);

		// 督办提醒
		List<SupervisionInfoDO> supervisionInfoDOList = this.taskItemDao
				.listAllSupervisionInfos(session.getAttribute("currentusername").toString());

		// 逾期提醒
		DueTaskDO dueTaskDO = this.taskItemDao.listDueTaskInfos(session.getAttribute("currentusername").toString());

		// 工作总览
		WorkViewDO workViewDO = this.taskItemDao
				.listAllWorkViewInfos(session.getAttribute("currentusername").toString());

		mav.addObject("supervisionInfoDOList", supervisionInfoDOList);

		mav.addObject("dueTaskDO", dueTaskDO);

		mav.addObject("workViewDO", workViewDO);

		return mav;
	}

	/**
	 * 督办工作
	 * 
	 * @return
	 */
	@RequestMapping("/workitem/supervisionlist")
	public String supervisionlist() {
		return "workitem/supervision";
	}

	/**
	 * 查看或编辑界面
	 * 
	 * @param workid
	 * @return
	 */
	@GetMapping(path = "/workitem/maintain/{workid}")
	public ModelAndView maintainAccount(@PathVariable(name = "workid") String workid) {
		ModelAndView mav = new ModelAndView("workitem/maintain");

		mav.addObject("workItemBO", this.workItemService.singleWorkItemInfo(workid));

		return mav;
	}

	public WorkItemService getWorkItemService() {
		return workItemService;
	}

	@Autowired
	@Required
	public void setWorkItemService(@Qualifier("defaultWorkItemService") WorkItemService workItemService) {
		this.workItemService = workItemService;
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
