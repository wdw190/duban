function initTaskItemDO(workId) {

	var initPojo = new Object();

	initPojo.workId = workId;

	var json = JSON.stringify(initPojo);

	$.ajax({

		type : 'POST',
		contentType : 'application/json',
		url : '/SoundWSS/wss/init/taskitem',
		data : json,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}

	}).then(function(data) {

		$('#workIdForItem').val(workId);
		$('#workTaskNum').val(data.workTaskNum);
		
		$('#reporterTaskItem').val(data.supervisor);
		$('#supervisor').val(data.supervisor);
		$('#taskCreated').val(data.taskCreated);

		$('#taskItemModalCenter').modal('show');

	});// then方法结束;

}
/**
 * 新增子任务项
 * 
 * @param workId
 * @returns
 */
function addTaskItem(workId) {
	initTaskItemDO(workId);
}

// 初始化日期选择器
function initTaskItemDateSelector() {

	// 初始化日期选择器

	$('#taskCreatedField').datetimepicker({
		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'top-left'
	});

	$('#taskDuedateField').datetimepicker({
		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'top-left'
	});

}

function insertTaskItem_DO() {

	var taskItemPojo_Added = new Object();

	taskItemPojo_Added.workId = $('#workIdForItem').val();
	taskItemPojo_Added.workTaskNum = $('#workTaskNum').val();
	taskItemPojo_Added.taskSummary = $('#taskSummary').val();
	taskItemPojo_Added.taskDescription = $('#taskDescription').val();
	taskItemPojo_Added.taskCreated = $('#taskCreated').val();
	taskItemPojo_Added.assignee = $('#assignee').val();
	taskItemPojo_Added.assigneeDept = $('#assigneeDept').val();
	taskItemPojo_Added.assist = $('#assist').val();
	taskItemPojo_Added.taskDuedate = $('#taskDuedate').val();
	taskItemPojo_Added.taskResolution = 'open';
	taskItemPojo_Added.taskStatus='released';
	
	taskItemPojo_Added.reporter=$('#reporterTaskItem').val();
	taskItemPojo_Added.supervisor=$('#supervisor').val();

	var json = JSON.stringify(taskItemPojo_Added);
	
	$
			.ajax({

				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/addtaskitem',
				data : json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}

			})
			.then(
					function(data) {

						if (data.flag == "success") {
							$('#inftoAddTaskItem')
									.html(
											'<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>新增任务项--成功!!</span>');

						} else {
							$('#inftoAddTaskItem')
									.html(
											'<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span><span>新增任务项--失败!!</span>');

						}
						$('#infoModalTaskItem').modal('show');

					});// then方法结束

}

$(document).ready(function() {
	initTaskItemDateSelector();

	// 保存添加任务项
	$('#saveTaskItemBtn').click(function(eventaddtask) {

		eventaddtask.preventDefault();

		insertTaskItem_DO();

	});
	// 再添加一个任务项
	$('#addNextTaskItem').click(function(eventaddnexttask) {

		eventaddnexttask.preventDefault();

		$('#infoModalTaskItem').modal('hide');

		// $('#taskItemModalCenter').modal('hide');

		var tempWorkId = $('#workIdForItem').val();

		// 重置表单
		document.getElementById("add-taskitem-form").reset();

		initTaskItemDO(tempWorkId);

	});
	// 关闭
	$('#closeTaskItemModal').click(function(eventclose) {

		eventclose.preventDefault();

		$('#infoModalTaskItem').modal('hide');

		$('#taskItemModalCenter').modal('hide');

	});

});