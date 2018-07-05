/**
 * 编辑工作项
 * 
 * @returns
 */
function editWorkItem() {

	$('#workSummary').removeAttr("disabled");
	$('#workDescription').removeAttr("disabled");

}

/**
 * 编辑保存
 * 
 * @returns
 */
function updateWorkItem() {

	var workItemPojo_Updted = new Object();

	workItemPojo_Updted.workId = $('#workId').val();
	workItemPojo_Updted.workSummary = $('#workSummary').val();
	workItemPojo_Updted.workDescription = $('#workDescription').val();

	var json = JSON.stringify(workItemPojo_Updted);

	// alert(json);

	$
			.ajax({

				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/updateworkitem',
				data : json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}

			})
			.then(
					function(data) {

						if (data.flag == "success") {
							$('#inftoUpdateTaskItem')
									.html(
											'<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>编辑保存--成功!!</span>');

						} else {
							$('#inftoUpdateTaskItem')
									.html(
											'<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span><span>编辑保存--失败!!</span>');

						}
						$('#infoModalUpdateTaskItem').modal('show');

					});// then方法结束

}

/**
 * 编辑
 * 
 * @param index
 * @returns
 */

function editItem(index) {

	$('#taskSummary' + index).removeAttr("disabled");
	$('#taskDescription' + index).removeAttr("disabled");
	$('#supervisor' + index).removeAttr("disabled");
	$('#taskCreated' + index).removeAttr("disabled");
	$('#assignee' + index).removeAttr("disabled");
	$('#assigneeDept' + index).removeAttr("disabled");
	$('#assist' + index).removeAttr("disabled");
	$('#taskDuedate' + index).removeAttr("disabled");

}

/**
 * 保存
 * 
 * @param savedIndex
 * @returns
 */

function saveItem(savedIndex) {

	var taskItemPojo_Updted = new Object();

	taskItemPojo_Updted.taskId = $('#taskId' + savedIndex).val();
	taskItemPojo_Updted.taskSummary = $('#taskSummary' + savedIndex).val();
	taskItemPojo_Updted.taskDescription = $('#taskDescription' + savedIndex)
			.val();
	taskItemPojo_Updted.assignee = $('#assignee' + savedIndex).val();
	taskItemPojo_Updted.assigneeDept = $('#assigneeDept' + savedIndex).val();
	taskItemPojo_Updted.assist = $('#assist' + savedIndex).val();
	taskItemPojo_Updted.taskDuedate = $('#taskDuedate' + savedIndex).val();
	taskItemPojo_Updted.supervisor = $('#supervisor' + savedIndex).val();
	taskItemPojo_Updted.reporter = $('#reporterTaskItem' + savedIndex).val();

	var json = JSON.stringify(taskItemPojo_Updted);

	// alert(json);

	$
			.ajax({

				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/updatetaskitem',
				data : json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}

			})
			.then(
					function(data) {

						if (data.flag == "success") {
							$('#inftoUpdateTaskItem')
									.html(
											'<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>编辑保存--成功!!</span>');

						} else {
							$('#inftoUpdateTaskItem')
									.html(
											'<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span><span>编辑保存--失败!!</span>');

						}
						$('#infoModalUpdateTaskItem').modal('show');

					});// then方法结束

}

/**
 * 取消任务
 * 
 * @param deletedIndex
 * @returns
 */
function delItem(deletedIndex) {

	var taskItemPojo_Cancel = new Object();

	taskItemPojo_Cancel.taskId = $('#taskId' + deletedIndex).val();
	taskItemPojo_Cancel.taskStatus = 'cancel';
	taskItemPojo_Cancel.taskResolution = 'cancel';

	var json = JSON.stringify(taskItemPojo_Cancel);

	// alert(json);

	$
			.ajax({

				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/canceltaskitem',
				data : json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}

			})
			.then(
					function(data) {

						if (data.flag == "success") {
							$('#inftoCancelTaskItem')
									.html(
											'<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span><span>取消--成功!!</span>');

						} else {
							$('#inftoCancelTaskItem')
									.html(
											'<span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span><span>取消--失败!!</span>');

						}
						$('#infoModalCancelTaskItem').modal('show');

					});// then方法结束

}

function closeUpdaeTaskItemInfoModal() {
	$('#infoModalUpdateTaskItem').modal('hide');

}

function closeCancelTaskItemInfoModal() {
	$('#infoModalCancelTaskItem').modal('hide');

}