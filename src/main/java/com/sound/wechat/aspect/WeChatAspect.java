package com.sound.wechat.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.sound.wss.bo.TaskActionCombineBO;
import com.sound.wss.dao.TaskItemDao;
import com.sound.wss.dto.ActionResultDTO;
import com.sound.wss.po.WeChatPersonInfoDO;
import com.sound.wss.po.wechat.Text;
import com.sound.wss.po.wechat.TextInfo;
import com.sound.wss.service.WeChatService;

@Aspect
@Component
public class WeChatAspect {

	private TaskItemDao taskItemDao;

	private WeChatService weChatService;

	@Pointcut("execution(public * com.sound.wss.service.impl.DefaultTaskItemService.insertTaskItemDO(..))")
	public void newTaskItemWeChat() {
	}

	@Pointcut("execution(public * com.sound.wss.service.impl.DefaultWorkTaskActionService.addCommContent(..))")
	public void sendWeChat() {
	}

	@AfterReturning(returning = "ret", pointcut = "newTaskItemWeChat()")
	public void doAfterReturningNew(Object ret) throws Throwable {
		// 处理完请求，返回内容

		ActionResultDTO actionResultDTO = (ActionResultDTO) ret;

		if (actionResultDTO.getFlag().equals("success")) {

			WeChatPersonInfoDO weChatPersonInfoDO = this.taskItemDao.viewWeChatPersonInfo(actionResultDTO.getMsg());

			TextInfo text = new TextInfo();
			text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getAssigneeId()).toString());
			text.setMsgtype("text");
			text.setAgentid(1000011);
			text.setSafe(0);
			Text content = new Text();
			content.setContent("您有一条新的督办任务【" + weChatPersonInfoDO.getTaskSummary() + "】，请在督办系统中处理!!");
			text.setText(content);	
			

			this.weChatService.sendWeChatSMS(text);

		} else {

		}

	}

	@AfterReturning(returning = "ret", pointcut = "sendWeChat()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容

		ActionResultDTO actionResultDTO = (ActionResultDTO) ret;

		if (actionResultDTO.getFlag().equals("success")) {

			System.out.println("---------------------------------------" + "处理完了" + actionResultDTO.getMsg());

			TaskActionCombineBO taskActionCombineBO = this.taskItemDao
					.queryLatestTaskItemActionRecord(actionResultDTO.getMsg());

			WeChatPersonInfoDO weChatPersonInfoDO = this.taskItemDao.viewWeChatPersonInfo(actionResultDTO.getMsg());

			TextInfo text = new TextInfo();
			// text.setTouser("8656|6920");
			text.setMsgtype("text");
			text.setAgentid(1000011);
			text.setSafe(0);
			Text content = new Text();
			// content.setContent("测试信息发送内容如下：\n文本测试信息发送。。SD001 \n
			// 文本测试信息发送。。SD002 \n 文本测试信息发送。。SD003 ");
			text.setText(content);

			// 沟通进度
			if (taskActionCombineBO.getActionType().equalsIgnoreCase("communicationprogress")) {
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getAssigneeId()).append("|")
						.append(weChatPersonInfoDO.getSupervisorId()).toString());
				content.setContent("您负责承办/督办的任务【" + weChatPersonInfoDO.getTaskSummary() + "】在和您沟通进度，请在督办系统中处理!!");

			} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforadjustment")) {
				// 申请变更
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getSupervisorId()).toString());
				content.setContent("您负责督办的任务【" + weChatPersonInfoDO.getTaskSummary() + "】申请变更，请在督办系统中处理!!");
			} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforcompleted")) {
				// 申请完成
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getSupervisorId()).toString());
				content.setContent("您负责督办的任务【" + weChatPersonInfoDO.getTaskSummary() + "】申请完成，请在督办系统中处理!!");
			} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("urging")) {
				// 催办
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getAssigneeId()).toString());
				content.setContent("您有一条催办任务【" + weChatPersonInfoDO.getTaskSummary() + "】，请在督办系统中处理!!");
			} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforadjustment_approval")) {
				// 变更审批
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getAssigneeId()).toString());
				content.setContent("您承办的任务【" + weChatPersonInfoDO.getTaskSummary() + "】已完成变更，请在督办系统中处理!!");
			} else if (taskActionCombineBO.getActionType().equalsIgnoreCase("applyforcompleted_approval")) {
				// 完成审批
				text.setTouser(new StringBuilder().append(weChatPersonInfoDO.getAssigneeId()).toString());
				content.setContent("您承办的任务【" + weChatPersonInfoDO.getTaskSummary() + "】已同意完成!!");
			}

			this.weChatService.sendWeChatSMS(text);

		} else {

		}

	}

	public TaskItemDao getTaskItemDao() {
		return taskItemDao;
	}

	@Autowired
	@Required
	public void setTaskItemDao(@Qualifier("defaultTaskItemDao") TaskItemDao taskItemDao) {
		this.taskItemDao = taskItemDao;
	}

	public WeChatService getWeChatService() {
		return weChatService;
	}

	@Autowired
	@Required
	public void setWeChatService(@Qualifier("defaultWeChatService") WeChatService weChatService) {
		this.weChatService = weChatService;
	}

}
