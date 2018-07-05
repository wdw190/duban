var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
// 初始化单选按钮样式
function initRadioButtonTaskItem(){
	
	$(':radio').iCheck({
	    // checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	  });
	
	
}
// 初始化操作记录表
function initDataTable_ActionTable(dataSet){
	
	if ($.fn.dataTable.isDataTable('#taskItemCommRecordTablesResults')) {
		var table_tmp = $('#taskItemCommRecordTablesResults').DataTable();
		table_tmp.clear();
		table_tmp.destroy();
	}
	
	$('#taskItemCommRecordTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"pageLength":2,
		"pagingType" : "full_numbers",
		"language" : {
			"emptyTable" : "无沟通记录",
			"info" : "显示 _START_ 到  _END_ 条沟通记录,总计 _TOTAL_ 条沟通记录",
			"infoEmpty" : "无沟通记录",
			"paginate" : {
				"first" : "首页",
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"data":dataSet,
		"columns": [
	        { "data": "author" },
	        { "data": "created" },
	        { "data": "actionType" },
	        { "data": "actionBody" },
	        { "data": "actionBody" }
	    ],
		"columnDefs" : []

	});
	
	
}
// 初始化表格
function initDataTable_MyTaskListTable() {
	var table = $('#taskOpenItemTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"language" : {
			"emptyTable" : "无承办工作项",
			"infoEmpty" : "无承办工作项",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"columnDefs" : []

	});
}

function initDataTable_MyProcessingTaskListTable() {
	var table = $('#taskProcessingItemTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"language" : {
			"emptyTable" : "无承办工作项",
			"infoEmpty" : "无承办工作项",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"columnDefs" : [{
			"visible" : false,
			"targets" : [ 1 ]
		}]

	});
}

function initDataTable_MyDoneTaskListTable() {
	var table = $('#taskDoneItemTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"language" : {
			"emptyTable" : "无承办工作项",
			"infoEmpty" : "无承办工作项",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"columnDefs" : [{
			"visible" : false,
			"targets" : [ 1 ]
		}]

	});
}

/**
 * 处理承办任务
 */
function dealTaskItem(taskItemId){
	
	// 重置表单
	document.getElementById("add-commcontent-form").reset();
	
	$.ajax({
		type : 'GET',
		url : '/SoundWSS/wss/details/'+taskItemId,
		
		beforeSend : function(xhr) {
			$('#loadingInfoModal').modal("show");
			xhr.setRequestHeader(header, token);
		}
	})
	.then(
			function(data) {
				
				
				// 工作项
				$('#workType').val(data.workItemSimpleBO.workType);
				$('#workSummary').val(data.workItemSimpleBO.workSummary);
				$('#workDescription').val(data.workItemSimpleBO.workDescription);
				
				var files = data.workItemSimpleBO.fileAttachmentDOList;
				var bodyHtml01='';
				for( i=0;i< files.length;i++){
					
					var trHtml01='<tr>'
						+'<td>'+files[i].filename+'</td>'
						+'<td><a href="'+files[i].path+'">浏览</a></td>'
						+'<td><a href="'+files[i].downloadPath+'">下载</a></td>'
					    +'</tr>'
					    bodyHtml01 = bodyHtml01+trHtml01;
				}
				
				$('#workItemFilesablesResults tbody').html(bodyHtml01);
				
				// 任务项
				$('#workOrTaskId').val(data.taskId);
				$('#taskSummary').val(data.taskSummary);
				$('#taskDescription').val(data.taskDescription);
				$('#reporterTaskItem').val(data.reporter);
				$('#supervisor').val(data.supervisor);
				$('#taskCreated').val(data.taskCreated);
				$('#assignee').val(data.assignee);
				$('#assigneeDept').val(data.assigneeDept);
				$('#assist').val(data.assist);
				$('#taskDuedate').val(data.taskDuedate);
				
				var operationContents = data.workTaskActionDOList;
				var bodyHtml02='';
				for(k=0;k<operationContents.length;k++){
					var trHtml02 = '<tr>'
						+'<td>'+operationContents[k].author+'</td>'
						+'<td>'+operationContents[k].created+'</td>';
						if(operationContents[k].actionType=='new'){
							trHtml02 = trHtml02 +'<td>新建</td>'
						}else if(operationContents[k].actionType=='cancel'){
							trHtml02 = trHtml02 +'<td>取消</td>'
						}else if(operationContents[k].actionType=='update'){
							trHtml02 = trHtml02 +'<td>编辑修改</td>'
						}else if(operationContents[k].actionType=='communicationprogress'){
							trHtml02 = trHtml02 +'<td>沟通进度</td>'
						}else if(operationContents[k].actionType=='applyforadjustment'){
							trHtml02 = trHtml02 +'<td>申请变更</td>'
						}else if(operationContents[k].actionType=='applyforcompleted'){
							trHtml02 = trHtml02 +'<td>申请完成</td>'
						}else if(operationContents[k].actionType=='urging'){
							trHtml02 = trHtml02 +'<td>催办</td>'
						}else if(operationContents[k].actionType=='applyforadjustment_approval'){
							trHtml02 = trHtml02 +'<td>变更-审批</td>'
						}else if(operationContents[k].actionType=='applyforcompleted_approval'){
							trHtml02 = trHtml02 +'<td>完成-审批</td>'
						}
						
						trHtml02 = trHtml02 +'<td>'+operationContents[k].actionBody+'</td>';
					
					var commFiles=operationContents[k].fileAttachmentDOList;
					if(commFiles.length>0){
					for(j=0;j<commFiles.length;j++){
						trHtml02= trHtml02+'<td><a href="'+commFiles[j].downloadPath+'">'+commFiles[j].filename+'</a></td>';
					}
					}else{
						trHtml02= trHtml02+'<td></td>';
					}
					trHtml02= trHtml02+'</tr>';
					bodyHtml02 = bodyHtml02+trHtml02;
				}
				$('#taskItemCommRecordTablesResults tbody').html(bodyHtml02);
				
				// 初始化操作记录表
				// initDataTable_ActionTable(data.workTaskActionDOList);
				// 初始化按钮样式
				initRadioButtonTaskItem();
				$('#loadingInfoModal').modal("hide");
				$('#dealTaskItemModalCenter').modal('show');
				
			});
	
	
	
	
}
/**
 * 加载我的代办
 * 
 * @returns
 */
function loadMyTaskItem() {

	

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/listmytaskitem',
				
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}
			})
			.then(
					function(data) {

						
						if ($.fn.dataTable.isDataTable('#taskOpenItemTablesResults')) {
							var table = $('#taskOpenItemTablesResults').DataTable();
							table.clear();
							table.destroy();
						}
						if (data.flag == "success") {
							var table = $('#taskOpenItemTablesResults')
									.DataTable(
											{

												"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
												"searching" : false,// 是否允许Datatables开启本地搜索
												"pagingType" : "full_numbers",
												"language" : {
													"emptyTable" : "无承办工作",
													"info" : "显示 _START_ 到  _END_ 工作任务,总计 _TOTAL_ 个工作任务",
													"infoEmpty" : "无承办工作",
													"paginate" : {
														"first" : "首页",
														"previous" : "上一页",
														"next" : "下一页",
														"last" : "尾页"
													}
												},
												data : data.workTaskList,
												columns : [ {

													data : null
												}, {

													data : 'taskId'
												}, {

													data : 'taskSummary'
												}, {

													data : 'assignee'
												}, {

													data : 'assigneeDept'
												}, {

													data : 'taskUpdated'
												},  {

													data : 'taskCreated'
												}],
												"columnDefs" : [
													
													{
														"visible" : false,
														"targets" : [ 1 ]
													},{
														"targets" : 2,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                        
										                        var dealhtml =  '<button   type="button" class="btn-link" onclick="dealTaskItem(\'' + row.taskId + '\')">'+row.taskSummary+'</button>';
										                       
										                        return dealhtml;
															}

													}
													
													 ],
												"drawCallback" : function(settings) {
													var api = this.api();
													
													　　// var startIndex=
														// api.context[0]._iDisplayStart;//获取到本页开始的条数
													　　api.column(0).nodes().each(function(cell, i) {

													　　　　// 此处 startIndex + i +
														// 1;会出现翻页序号不连续，主要是因为startIndex
														// 的原因,去掉即可。
													　　　　// cell.innerHTML =
														// startIndex + i + 1;

													　　　　cell.innerHTML = new Number(i + 1).toString();

													　　}); 

													// ----------------------
												}
											

											});
						} else {
							initDataTable_MyTaskListTable();
						}

					});// then方法结束

}

/**
 * 承办人处理中的任务
 * 
 * @returns
 */
function loadMyProcessingTaskItem() {

	

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/listmyprocessingtaskitem',
				
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}
			})
			.then(
					function(data) {

						
						if ($.fn.dataTable.isDataTable('#taskProcessingItemTablesResults')) {
							var table = $('#taskProcessingItemTablesResults').DataTable();
							table.clear();
							table.destroy();
						}
						if (data.flag == "success") {
							var table = $('#taskProcessingItemTablesResults')
									.DataTable(
											{

												"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
												"searching" : false,// 是否允许Datatables开启本地搜索
												"pagingType" : "full_numbers",
												"language" : {
													"emptyTable" : "无承办工作",
													"info" : "显示 _START_ 到  _END_ 工作任务,总计 _TOTAL_ 个工作任务",
													"infoEmpty" : "无承办工作",
													"paginate" : {
														"first" : "首页",
														"previous" : "上一页",
														"next" : "下一页",
														"last" : "尾页"
													}
												},
												data : data.workTaskList,
												columns : [ {

													data : null
												}, {

													data : 'taskId'
												}, {

													data : 'taskSummary'
												}, {

													data : 'taskCreated'
												}, {

													data : 'taskDuedate'
												}, {

													data : 'created'
												},  {

													data : 'taskStatus'
												}],
												"columnDefs" : [
													
													{
														"visible" : false,
														"targets" : [ 1 ]
													},{
														"targets" : 2,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                        
										                        var dealhtml =  '<button   type="button" class="btn-link" onclick="dealTaskItem(\'' + row.taskId + '\')">'+row.taskSummary+'</button>';
										                       
										                        return dealhtml;
															}

													},{
														"targets" : 6,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                        
										                        var dealhtml =  '';
										                        
										                        if(row.taskStatus == 'communicationprogress'){
										                        	dealhtml='<span class="glyphicon glyphicon-flash"></span><span class="text-danger"> 沟通进度中</span>';
										                        }else if(row.taskStatus == 'applyforadjustment'){
										                        	dealhtml='<span class="glyphicon glyphicon-edit text-danger"></span><span class="text-danger"> 申请调整</span>';
										                        }else if(row.taskStatus == 'applyforcompleted'){
										                        	dealhtml='<span class="glyphicon glyphicon-upload text-warning"></span><span class="text-warning"> 申请完成</span>';
										                        }else if(row.taskStatus == 'completechanges'){
										                        	dealhtml='<span class="glyphicon glyphicon-flash text-danger"></span><span class="text-danger"> 已变更</span>';
										                        }else if(row.taskStatus == 'cancel'){
										                        	dealhtml='<span class="glyphicon glyphicon-flash text-danger"></span><span class="text-danger"> 已取消</span>';
										                        }
										                       
										                        return dealhtml;
															}

													}
													
													 ],
												"drawCallback" : function(settings) {
													var api = this.api();
													
													　　// var startIndex=
														// api.context[0]._iDisplayStart;//获取到本页开始的条数
													　　api.column(0).nodes().each(function(cell, i) {

													　　　　// 此处 startIndex + i +
														// 1;会出现翻页序号不连续，主要是因为startIndex
														// 的原因,去掉即可。
													　　　　// cell.innerHTML =
														// startIndex + i + 1;

													　　　　cell.innerHTML = new Number(i + 1).toString();

													　　}); 

													// ----------------------
												}
											

											});
						} else {
							initDataTable_MyProcessingTaskListTable();
						}

					});// then方法结束

}

/**
 * 承办人处理完成的任务
 * 
 * @returns
 */
function loadMyDoneTaskItem() {

	

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/listmydonetaskitem',
				
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}
			})
			.then(
					function(data) {

						
						if ($.fn.dataTable.isDataTable('#taskDoneItemTablesResults')) {
							var table = $('#taskDoneItemTablesResults').DataTable();
							table.clear();
							table.destroy();
						}
						if (data.flag == "success") {
							var table = $('#taskDoneItemTablesResults')
									.DataTable(
											{

												"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
												"searching" : false,// 是否允许Datatables开启本地搜索
												"pagingType" : "full_numbers",
												"language" : {
													"emptyTable" : "无承办工作",
													"info" : "显示 _START_ 到  _END_ 工作任务,总计 _TOTAL_ 个工作任务",
													"infoEmpty" : "无承办工作",
													"paginate" : {
														"first" : "首页",
														"previous" : "上一页",
														"next" : "下一页",
														"last" : "尾页"
													}
												},
												data : data.workTaskList,
												columns : [ {

													data : null
												}, {

													data : 'taskId'
												}, {

													data : 'taskSummary'
												}, {

													data : 'taskDuedate'
												}, {

													data : 'taskCreated'
												}, {

													data : 'taskResolutiondate'
												}],
												"columnDefs" : [
													
													{
														"visible" : false,
														"targets" : [ 1 ]
													},{
														"targets" : 2,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                        
										                        var dealhtml =  '<button   type="button" class="btn-link" onclick="dealTaskItem(\'' + row.taskId + '\')">'+row.taskSummary+'</button>';
										                       
										                        return dealhtml;
															}

													}
													
													 ],
												"drawCallback" : function(settings) {
													var api = this.api();
													
													　　// var startIndex=
														// api.context[0]._iDisplayStart;//获取到本页开始的条数
													　　api.column(0).nodes().each(function(cell, i) {

													　　　　// 此处 startIndex + i +
														// 1;会出现翻页序号不连续，主要是因为startIndex
														// 的原因,去掉即可。
													　　　　// cell.innerHTML =
														// startIndex + i + 1;

													　　　　cell.innerHTML = new Number(i + 1).toString();

													　　}); 

													// ----------------------
												}
											

											});
						} else {
							initDataTable_MyDoneTaskListTable();
						}

					});// then方法结束

}

/**
 * 新增沟通内容
 * 
 * @returns
 */
function addCommContent() {	

	$.ajax({
		url : $('#add-commcontent-form').attr("action"),
		type : $('#add-commcontent-form').attr("method"),
		data : new FormData($("#add-commcontent-form")[0]),
		enctype : 'multipart/form-data',
		processData : false,
		contentType : false,
		cache : false
	/*
	 * , beforeSend : function(xhr) { xhr.setRequestHeader(header, token); }
	 */
	}).then(function(data) {

		// alert(data.flag);
		if (data.flag == 'success') {
			$('#infoModalDealTaskItemModalBody').html('<span class="glyphicon glyphicon-saved" aria-hidden="true"></span><span>&nbsp;成功！！</span>');
		} else {
			$('#infoModalDealTaskItemModalBody').html('<span class="glyphicon glyphicon-flash" aria-hidden="true"></span><span>&nbsp;失败！！</span>');
		}
		$('#infoModalDealTaskItem').modal('show');

	});// then方法结束;

} // ---end

$(document).ready(function() {

	// initDataTable_MyTaskListTable();
	
	loadMyTaskItem();
	loadMyProcessingTaskItem();
	loadMyDoneTaskItem();
	/**
	 * 确定
	 */
	$('#dealTaskItemBtn').click(function(addCommContentEvent){
		
		addCommContentEvent.preventDefault();
		addCommContent();
		
	});
	/**
	 * 取消
	 */
	$('#cancelTaskItemBtn').click(function(cancelCommContentEvent){
		
		cancelCommContentEvent.preventDefault();
		
		$('#dealTaskItemModalCenter').modal('hide');
	});
	
	/**
	 * 关闭确认
	 */
	
   $('#closeDealTaskItemModal').click(function(closeDealCommContentEvent){
		
	   closeDealCommContentEvent.preventDefault();
		
		$('#dealTaskItemModalCenter').modal('hide');
		$('#infoModalDealTaskItem').modal('hide');
	});
	
	

});