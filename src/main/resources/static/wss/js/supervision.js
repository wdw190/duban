var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
//初始化单选按钮样式
function initRadioButtonTaskItem(){
	
	$(':radio').iCheck({
	    // checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	  });
	
	
}
// 初始化日期选择器
function initSupervisionDateSelector() {

	// 初始化日期选择器

	$('#startdatefield').datetimepicker({

		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'bottom-left'
	}).on('changeDate', function(ev) {

		var startdate = $('#createdStart').val();
		$('#enddatefield').datetimepicker('setStartDate', startdate);
		$('#startdatefield').datetimepicker('hide');

	});

	$('#enddatefield').datetimepicker({
		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'bottom-left'
	});

	$('#taskDuedateStartfield').datetimepicker({

		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'bottom-left'
	}).on('changeDate', function(ev) {

		var startdate = $('#createdStart').val();
		$('#taskDuedateEndfield').datetimepicker('setStartDate', startdate);
		$('#taskDuedateStartfield').datetimepicker('hide');

	});

	$('#taskDuedateEndfield').datetimepicker({
		minView : "month", // 选择日期后，不会再跳转去选择时分秒
		language : 'zh-CN',
		format : 'yyyy-mm-dd',
		todayBtn : 1,
		autoclose : 1,
		pickerPosition : 'bottom-left'
	});

}

/**
 * 初始化开始和结束日期
 */
function initRecordDate() {

	// 实例化一个对象date
	var date = new Date();
	// 获取年份
	var year = date.getFullYear();
	// 获取月份
	var month = date.getMonth() + 1;
	// 获取日子
	var dayStart = date.getDate();
	var dayEnd = dayStart + 1;
	// 拼接日期
	var thisDateStart = year + "-" + (month < 10 ? "0" + month : month) + "-"
			+ (dayStart < 10 ? "0" + dayStart : dayStart);
	var thisDateEnd = year + "-" + (month < 10 ? "0" + month : month) + "-"
			+ (dayEnd < 10 ? "0" + dayEnd : dayEnd);

	// 打印日期
	$('#createdStart').val(thisDateStart);
	$('#taskDuedateStart').val(thisDateStart);
	
	$('#createdEnd').val(thisDateEnd);
	$('#taskDuedateEnd').val(thisDateEnd);
	

}
/**
 * 督办任务
 * @param taskId
 * @returns
 */
function SupervisionTaskItem(taskItemId){
	

	
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
						}else if(operationContents[k].actionType=='update'){
							trHtml02 = trHtml02 +'<td>编辑修改</td>'
						}else if(operationContents[k].actionType=='cancel'){
							trHtml02 = trHtml02 +'<td>取消</td>'
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
						trHtml02= trHtml02+'<td>';
					    for(j=0;j<commFiles.length;j++){
						   trHtml02= trHtml02+'<a href="'+commFiles[j].downloadPath+'">'+commFiles[j].filename+'</a><br />';
					    }
					    trHtml02= trHtml02+'</td>';
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
				
				 if(data.taskStatus == 'approval' || data.taskStatus == 'cancel'){
					$('#communicationRow').hide();
				}else if(data.taskStatus == 'applyforadjustment' || data.taskStatus == 'applyforcompleted'){
					$('#radioapproval').show();
					$('#radiourging').hide();
					$('#communicationRow').show();
				}else{
					$('#radioapproval').hide();
					$('#radiourging').show();
					$('#communicationRow').show();
				}
				
				$('#dealTaskItemModalCenter').modal('show');
				
			});
	
	
	
	
	
}
/**
 * 初始化督办任务列表
 * @returns
 */
function initDataTable_MySupervisionTaskListTable() {
	var table = $('#supervisionTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"language" : {
			"emptyTable" : "无督办工作项",
			"infoEmpty" : "无督办工作项",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"columnDefs" : [{
			"visible" : false,
			"targets" : [ 4 ]
		}]

	});
}
/**
 * 查询督办任务
 * @returns
 */
function querySupervisionTaskItem() {

	var initPojo = new Object();

	initPojo.taskCreatedStart = $('#createdStart').val();
	initPojo.taskCreatedEnd = getNewDateByAddDays($('#createdEnd').val(),1);
	initPojo.workType = $('#workTypeSupervision').val();
	initPojo.taskDuedateStart = $('#taskDuedateStart').val();
	initPojo.taskDuedateEnd = getNewDateByAddDays($('#taskDuedateEnd').val(),1);
	initPojo.taskResolutionStatus = $('#taskResolutionStatus').val();
	initPojo.summaryDesc = $('#summaryDesc').val();

	var json = JSON.stringify(initPojo);
	
	//alert('json='+json);

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/list/supervisionitem',
				data:json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
					//$('#queryingInfoModal').modal('show');
				}
			})
			.then(
					function(data) {

						
						if ($.fn.dataTable.isDataTable('#supervisionTablesResults')) {
							var table = $('#supervisionTablesResults').DataTable();
							table.clear();
							table.destroy();
						}
						if (data.flag == "success") {
							var table = $('#supervisionTablesResults')
									.DataTable(
											{

												"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
												"searching" : false,// 是否允许Datatables开启本地搜索
												"pageLength":4,
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

													data : 'taskResolution'
												}, {

													data : 'workType'
												}, {

													data : 'workSummary'
												}, {

													data : 'taskId'
												}, {

													data : 'taskSummary'
												}, {

													data : 'taskStatus'
												},  {

													data : 'assignee'
												},  {

													data : 'assigneeDept'
												},  {

													data : 'supervisor'
												},  {

													data : 'taskCreated'
												},  {

													data : 'taskDuedate'
												}],
												"columnDefs" : [
													
													{
														"visible" : false,
														"targets" : [ 4 ]
													},{
														"targets" : 1,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                     
															 var statusHtml='';
															 
										                        if(row.taskResolution=='cancel'){
										                        	statusHtml='<div class="colorBlockBorder colorInfo"></div>';
										                        }else if(row.taskResolution=='done'){
										                        	statusHtml='<div class="colorBlockBorder colorSuccess"></div>';
										                        }else if(row.taskResolution=='delayeddone'){
										                        	statusHtml='<div class="colorBlockBorder colorWarning"></div>';
										                        }else if(row.taskResolution=='undone'){
										                        	statusHtml='<div class="colorBlockBorder colorDanger"></div>';
										                        }else if(row.taskResolution=='processing'){
										                        	statusHtml='<div class="colorBlockBorder colorPrimary"></div>';
										                        }
										                       
										                        return statusHtml;
															}

													},{
														"targets" : 5,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                        
										                        var dealhtml =  '<button   type="button" class="btn-link" onclick="SupervisionTaskItem(\'' + row.taskId + '\')">'+row.taskSummary+'</button>';
										                       
										                        return dealhtml;
															}

													},{
														"targets" : 6,// 操作按钮目标列
														
														"data" : null,
														// "defaultContent":
														// "<button>Click!</button>",
														 "render" : function(data,type,row,meta) {
										                     
															 var statusTaskHtml='';
															 
										                        if(row.taskStatus=='released'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-circle-arrow-down text-info"></span><span class="text-info"> 已下达</span>';
										                        }else if(row.taskStatus=='communicationprogress'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-earphone"></span><span> 沟通处理中</span>';
										                        }else if(row.taskStatus=='applyforadjustment'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-edit text-danger"></span><span class="text-danger"> 申请调整</span>';
										                        }else if(row.taskStatus=='completechanges'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-flash"></span><span class="text-danger"> 已变更</span>';
										                        }else if(row.taskStatus=='applyforcompleted'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-upload text-warning"></span><span class="text-warning"> 申请完成</span>';
										                        }else if(row.taskStatus=='urging'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-volume-up text-primary"></span><span class="text-primary"> 催办</span>';
										                        }else if(row.taskStatus=='approval'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-ok-sign text-success"></span><span class="text-success"> 同意完成</span>';
										                        }else if(row.taskStatus=='cancel'){
										                        	statusTaskHtml='<span class="glyphicon glyphicon-ban-circle"></span><span class="text-success"> 已取消</span>';
										                        }
										                       
										                        return statusTaskHtml;
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
							initDataTable_MySupervisionTaskListTable();
						}

						//$('#queryingInfoModal').modal('hide');
					});// then方法结束

}

/**
 * 督办处理
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

$(document).ready(function(){
	
	
	initSupervisionDateSelector();
	initRecordDate();
	initDataTable_MySupervisionTaskListTable();
	
	$('#querySupervisionBtn').click(function(SupervisionEvent){
		
		SupervisionEvent.preventDefault();
		
		querySupervisionTaskItem();
		
		
	});
	
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