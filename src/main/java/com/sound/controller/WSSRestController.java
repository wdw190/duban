package com.sound.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sound.exception.WSSException;
import com.sound.wss.bo.OrgBO;
import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.bo.TaskItemDetailsBO;
import com.sound.wss.bo.TreeNodeBO;
import com.sound.wss.bo.WorkItemResultBO;
import com.sound.wss.bo.WorkTaskResultBO;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.dto.MyTaskCriteriaDTO;
import com.sound.wss.dto.SupervisionCriteriaDTO;
import com.sound.wss.dto.TaskItemWorkIdCriticalDTO;
import com.sound.wss.dto.WorkItemCriteriaDTO;
import com.sound.wss.dto.WorkTypeDateCriticalDTO;
import com.sound.wss.po.SupervisionDO;
import com.sound.wss.po.TaskItemDO;
import com.sound.wss.po.WorkItemDO;
import com.sound.wss.po.WorkTaskActionDO;
import com.sound.wss.properties.WSSProperties;
import com.sound.wss.service.OrgService;
import com.sound.wss.service.SupervisionService;
import com.sound.wss.service.TaskItemService;
import com.sound.wss.service.WorkItemService;
import com.sound.wss.service.WorkTaskActionService;

@RestController
public class WSSRestController {

	private WorkItemService workItemService;

	private TaskItemService taskItemService;

	private WorkTaskActionService workTaskActionService;

	private SupervisionService supervisionService;

	private OrgService orgService;

	private WSSProperties wssProperties;

	/**
	 * 初始化工作项
	 * 
	 * @param workTypeDateCriticalDTO
	 * @param request
	 * @return
	 * @throws WSSException
	 */
	@RequestMapping(value = "/wss/init/workitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkItemDO initWorkItem(@RequestBody WorkTypeDateCriticalDTO workTypeDateCriticalDTO,
			HttpServletRequest request) throws WSSException {

		WorkItemDO workItemDO = this.workItemService.initWorkItemDO(workTypeDateCriticalDTO.getWorkTypeDate());

		HttpSession session = request.getSession(true);
		workItemDO.setReporter(session.getAttribute("currentusername").toString());

		return workItemDO;

	}

	/**
	 * 初始化任务项
	 * 
	 * @param taskItemWorkIdCriticalDTO
	 * @param request
	 * @return
	 * @throws WSSException
	 */
	@RequestMapping(value = "/wss/init/taskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public TaskItemDO initTaskItem(@RequestBody TaskItemWorkIdCriticalDTO taskItemWorkIdCriticalDTO,
			HttpServletRequest request) throws WSSException {

		TaskItemDO taskItemDO = this.taskItemService.initTaskItemDO(taskItemWorkIdCriticalDTO.getWorkId());

		HttpSession session = request.getSession(true);
		taskItemDO.setSupervisor(session.getAttribute("currentusername").toString());

		return taskItemDO;

	}

	/**
	 * 新增工作项
	 * 
	 * @param workItemPO
	 * @param files
	 * @param request
	 * @return
	 */
	// @RequestMapping(path = "/wss/addworkitem", method = RequestMethod.POST)
	@RequestMapping(value = "/wss/addworkitem", method = RequestMethod.POST)
	public ActionResultDTO registerTeacherWithFiles(WorkItemDO workItemPO,
			@RequestParam(name = "fileAttachment") MultipartFile[] files, HttpServletRequest request) {
		ActionResultDTO actionResultDTO = new ActionResultDTO();
		try {
			actionResultDTO = this.workItemService.saveWorkItem(workItemPO, files, request);
		} catch (WSSException e) {
			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
		}

		return actionResultDTO;

	}

	/**
	 * 查询工作项
	 * 
	 * @param workItemCriteriaDTO
	 * @return
	 * @throws WSSException
	 */
	@RequestMapping(value = "/wss/list/workitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkItemResultBO listWorkItem(@RequestBody WorkItemCriteriaDTO workItemCriteriaDTO,
			HttpServletRequest request) throws WSSException {

		System.out.println("------------------------------------" + workItemCriteriaDTO.toString());

		HttpSession session = request.getSession(true);
		workItemCriteriaDTO.setReporter(session.getAttribute("currentusername").toString());

		return this.workItemService.listWorkItem(workItemCriteriaDTO);

	}

	/**
	 * 新增任务项
	 * 
	 * @param taskItemDO
	 * @return
	 */
	@RequestMapping(value = "/wss/addtaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public ActionResultDTO insertTaskItem(@RequestBody TaskItemDO taskItemDO) {

		ActionResultDTO actionResultDTO = this.taskItemService.insertTaskItemDO(taskItemDO);

		return actionResultDTO;

	}

	/**
	 * 承办人的代办任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "/wss/listmytaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkTaskResultBO<TaskItemDO> listMyTaskItem(HttpServletRequest request) {

		MyTaskCriteriaDTO myTaskCriteriaDTO = new MyTaskCriteriaDTO();

		myTaskCriteriaDTO.setTaskResolution("open");
		HttpSession session = request.getSession(true);
		myTaskCriteriaDTO.setAssignee(session.getAttribute("currentusername").toString());

		return this.taskItemService.listMyTask(myTaskCriteriaDTO);

	}

	/**
	 * 承办人已处理完成的任务
	 * 
	 * @return
	 */
	@RequestMapping(value = "/wss/listmydonetaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkTaskResultBO<TaskItemDO> listMyDoneTaskItem(HttpServletRequest request) {

		MyTaskCriteriaDTO myTaskCriteriaDTO = new MyTaskCriteriaDTO();

		myTaskCriteriaDTO.setTaskResolution("done");
		HttpSession session = request.getSession(true);
		myTaskCriteriaDTO.setAssignee(session.getAttribute("currentusername").toString());

		return this.taskItemService.listMyDoneTask(myTaskCriteriaDTO);

	}

	/**
	 * 承办人的处理中的任务
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wss/listmyprocessingtaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkTaskResultBO<TaskActionCombineBO> listMyProcessingTaskItem(HttpServletRequest request) {

		MyTaskCriteriaDTO myTaskCriteriaDTO = new MyTaskCriteriaDTO();

		myTaskCriteriaDTO.setTaskResolution("open");
		HttpSession session = request.getSession(true);
		myTaskCriteriaDTO.setAssignee(session.getAttribute("currentusername").toString());

		return this.taskItemService.listMyProcessingTask(myTaskCriteriaDTO);

	}

	/**
	 * 我的代办任务详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/wss/details/{taskId}", method = RequestMethod.GET)
	public TaskItemDetailsBO taskItemDetails(@PathVariable(name = "taskId") String taskId) {

		return this.taskItemService.viewSingleTaskItemInfo(taskId);

	}

	/**
	 * 操作处理--沟通进度-申请调整-申请完成-催办-审批
	 * 
	 * @param workTaskActionDO
	 * @param taskItemDO
	 *            调整审批时候 要修改任务项的内容
	 * @param files
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wss/addcommcontent", method = RequestMethod.POST)
	public ActionResultDTO addCommContent(WorkTaskActionDO workTaskActionDO, TaskItemDO taskItemDO,
			@RequestParam(name = "fileAttachment") MultipartFile[] files, HttpServletRequest request) {
		ActionResultDTO actionResultDTO = new ActionResultDTO();
		try {
			System.out.println("--------------------------------------");

			System.out.println(workTaskActionDO.toString());

			System.out.println("--------------------------------------");
			System.out.println("--------------------------------------");

			System.out.println(taskItemDO.toString());

			System.out.println("--------------------------------------");
			actionResultDTO = this.workTaskActionService.addCommContent(workTaskActionDO, taskItemDO, files, request);
		} catch (WSSException e) {
			actionResultDTO.setFlag("failed");
			actionResultDTO.setMsg(e.getMessage());
		}

		return actionResultDTO;

	}

	/**
	 * 督办工作项
	 * 
	 * @param workItemCriteriaDTO
	 * @return
	 * @throws WSSException
	 */
	@RequestMapping(value = "/wss/list/supervisionitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkTaskResultBO<SupervisionDO> listSupervisionItem(
			@RequestBody SupervisionCriteriaDTO supervisionCriteriaDTO, HttpServletRequest request)
			throws WSSException {
		System.out.println("----------------------------------------------------------------");
		System.out.println(supervisionCriteriaDTO.toString());
		System.out.println("----------------------------------------------------------------");

		HttpSession session = request.getSession(true);
		supervisionCriteriaDTO.setReporter(session.getAttribute("currentusername").toString());
		supervisionCriteriaDTO.setSupervisior(session.getAttribute("currentusername").toString());

		return this.supervisionService.listSupervisionItem(supervisionCriteriaDTO);

	}

	/**
	 * 组织架构信息
	 * 
	 * @return
	 * @throws WSSException
	 */
	@RequestMapping(value = "/wss/list/orgs", method = RequestMethod.GET)
	public WorkTaskResultBO<OrgBO> listOrgs() throws WSSException {

		return this.orgService.listOrgInfo(wssProperties.getDepId());

	}

	@RequestMapping(value = "/wss/list/treenode", method = RequestMethod.GET)
	public WorkTaskResultBO<TreeNodeBO> listTreeNode() throws WSSException {

		System.out.println("-------------------------------------" + wssProperties.getDepId());

		return this.orgService.dealTreeNodes(350);

	}

	/**
	 * 编辑保存任务项
	 * 
	 * @param taskItemDO
	 * @return
	 */
	@RequestMapping(value = "/wss/updatetaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public ActionResultDTO updateTaskItem(@RequestBody TaskItemDO taskItemDO, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		taskItemDO.setReporter(session.getAttribute("currentusername").toString());

		ActionResultDTO actionResultDTO = this.taskItemService.updateTaskItemDoByTaskID(taskItemDO);

		return actionResultDTO;

	}

	/**
	 * 取消任务项
	 * 
	 * @param taskItemDO
	 * @return
	 */

	@RequestMapping(value = "/wss/canceltaskitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public ActionResultDTO cancelTaskItem(@RequestBody TaskItemDO taskItemDO, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		taskItemDO.setReporter(session.getAttribute("currentusername").toString());

		ActionResultDTO actionResultDTO = this.taskItemService.cancelTaskItemDoByTaskID(taskItemDO);

		return actionResultDTO;

	}

	/**
	 * 工作项编辑保存
	 * 
	 * @param workItemDO
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wss/updateworkitem", method = RequestMethod.POST, headers = "content-type=application/json")
	public WorkItemResultBO updateWorkItem(@RequestBody WorkItemDO workItemDO, HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		workItemDO.setReporter(session.getAttribute("currentusername").toString());

		WorkItemResultBO workItemResultBO = this.workItemService.updateWorkItem(workItemDO);

		return workItemResultBO;

	}

	public WorkItemService getWorkItemService() {
		return workItemService;
	}

	@Autowired
	@Required
	public void setWorkItemService(@Qualifier("defaultWorkItemService") WorkItemService workItemService) {
		this.workItemService = workItemService;
	}

	public TaskItemService getTaskItemService() {
		return taskItemService;
	}

	@Autowired
	@Required
	public void setTaskItemService(@Qualifier("defaultTaskItemService") TaskItemService taskItemService) {
		this.taskItemService = taskItemService;
	}

	public WorkTaskActionService getWorkTaskActionService() {
		return workTaskActionService;
	}

	@Autowired
	@Required
	public void setWorkTaskActionService(
			@Qualifier("defaultWorkTaskActionService") WorkTaskActionService workTaskActionService) {
		this.workTaskActionService = workTaskActionService;
	}

	public SupervisionService getSupervisionService() {
		return supervisionService;
	}

	@Autowired
	@Required
	public void setSupervisionService(@Qualifier("defaultSupervisionService") SupervisionService supervisionService) {
		this.supervisionService = supervisionService;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	@Autowired
	@Required
	public void setOrgService(@Qualifier("defaultOrgService") OrgService orgService) {
		this.orgService = orgService;
	}

	public WSSProperties getWssProperties() {
		return wssProperties;
	}

	@Autowired
	@Required
	public void setWssProperties(@Qualifier("wssProperties") WSSProperties wssProperties) {
		this.wssProperties = wssProperties;
	}

}
