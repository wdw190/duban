// alert(typedate);
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

// 初始化表格
function initDataTable_WorkItemTable() {
	var table = $('#workItemTablesResults').DataTable({

		"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
		"searching" : false,// 是否允许Datatables开启本地搜索
		"language" : {
			"emptyTable" : "没有工作项数据",
			"infoEmpty" : "无工作项显示",
			"paginate" : {
				"previous" : "上一页",
				"next" : "下一页",
				"last" : "尾页"
			}
		},
		"columnDefs" : []

	});
}
// 查询

// 新增工作项

function addWorkItem() {

	// var token = $("meta[name='_csrf']").attr("content");
	// var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		url : $('#add-workitem-form').attr("action"),
		type : $('#add-workitem-form').attr("method"),
		data : new FormData($("#add-workitem-form")[0]),
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

			$('#infoModalAddWorkItemModalBody').html('<span class="glyphicon glyphicon-info-sign"></span><span> 成功!!</span>');
			
		} else {
			$('#infoModalAddWorkItemModalBody').html('<span class="glyphicon glyphicon-flash"></span><span> 失败!!</span>');
		}
		$('#infoModal').modal('show');

	});// then方法结束;

} // ---end

function editWorkTask(workId){
	
	$('#workifrm').attr('src','/SoundWSS/workitem/maintain/'+workId)
	
	$('#workItemDetailModalCenter').modal('show');
	
}

// 初始化日期选择器
function initDateSelector() {

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
	var thisDateStart = year + "-" + (month < 10 ? "0" + month : month)
			+ "-" + (dayStart < 10 ? "0" + dayStart : dayStart);
	var thisDateEnd = year + "-" + (month < 10 ? "0" + month : month) + "-"
			+ (dayEnd < 10 ? "0" + dayEnd : dayEnd);

	// 打印日期
	$('#createdStart').val(thisDateStart);
	$('#createdEnd').val(thisDateEnd);

}
/**
 * 获取日期
 * 
 */
function findDate() {
	// 实例化一个对象date
	var date = new Date();
	// 获取年份
	var year = date.getFullYear();
	// 获取月份
	var month = date.getMonth() + 1;
	// 获取日子
	var day = date.getDate();
	// 拼接日期
	var thisDate = year + (month < 10 ? "0" + month : month)
			+ (day < 10 ? "0" + day : day);
	// 打印日期
	return thisDate;
}

function initWorkItemDO(typedate) {
	

	var initPojo = new Object();

	initPojo.workTypeDate = typedate;

	var json = JSON.stringify(initPojo);

	$.ajax({

		type : 'POST',
		contentType : 'application/json',
		url : '/SoundWSS/wss/init/workitem',
		data : json,
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		}

	}).then(function(data) {

		$('#workId').val(data.workId);
		$('#reporter').val(data.reporter);
		$('#created').val(data.created);

		$('#workItemModalCenter').modal('show');

	});// then方法结束;

}

/**
 * 查询
 */
function queryWorkItemData() {

	var queryPojo = new Object();

	queryPojo.createdStart = $('#createdStart').val();
	queryPojo.createdEnd = getNewDateByAddDays($('#createdEnd').val(),1);	
	queryPojo.workSummary = $('#workSummary').val();	

	var json = JSON.stringify(queryPojo);

	 //alert(json);

	$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : '/SoundWSS/wss/list/workitem',
				data : json,
				beforeSend : function(xhr) {
					xhr.setRequestHeader(header, token);
				}
			})
			.then(
					function(data) {

						
						if ($.fn.dataTable.isDataTable('#workItemTablesResults')) {
							var table = $('#workItemTablesResults').DataTable();
							table.clear();
							table.destroy();
						}
						if (data.flag == "success") {
							var table = $('#workItemTablesResults')
									.DataTable(
											{

												"lengthChange" : false,// 是否允许工作项改变表格每页显示的记录数
												"searching" : false,// 是否允许Datatables开启本地搜索
												 "pageLength": 6,
												"pagingType" : "full_numbers",
												"language" : {
													"emptyTable" : "没有数据",
													"info" : "显示 _START_ 到  _END_ 工作项,总计 _TOTAL_ 个工作项",
													"infoEmpty" : "无工作项显示",
													"paginate" : {
														"first" : "首页",
														"previous" : "上一页",
														"next" : "下一页",
														"last" : "尾页"
													}
												},
												data : data.workItemDOList,
												columns : [ {

													data : null
												}, {

													data : 'workId'
												}, {

													data : 'workSummary'
												}, {

													data : 'reporter'
												}, {

													data : 'created'
												}, {

													data : 'workStatus'
												},  {

													data : null
												}],
												"columnDefs" : [
													
													{
														"targets" : 1,// 目标列
														"width": "10%"
														
													},
													{
														"targets" : 2,// 目标列
														"width": "20%"
														
													},
													{
														"targets" : 4,// 目标列
														"width": "15%"
														
													},
													{
															"targets" : 6,// 操作按钮目标列
															"width": "20%",
															"data" : null,
															 "defaultContent": "<button>Click!</button>",
															 "render" : function(data,type,row,meta) {
																 
																    var btnhtml ="";
																    
																    //if(row.enabled == 1){
																    	
																    	btnhtml = btnhtml + '&nbsp;'+'&nbsp;<a title="添加任务项" onclick="addTaskItem(\''+row.workId+'\')"  class="btn btn-info" role="button" ><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>'+'</a>';
																    //}else {
																    	
																    	btnhtml = btnhtml + '&nbsp;'+'<a title="编辑工作项" onclick="editWorkTask(\''+row.workId+'\')"  class="btn btn-warning" role="button" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>'+'</a>';
																    //}
																    	//btnhtml = btnhtml + '<a title="删除工作项" onclick="delWorkTask(\''+row.workId+'\')"  class="btn btn-danger" role="button" ><span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>'+'</a>';
																    	
																    	//btnhtml = btnhtml + '<a title="下达所有任务项" onclick="releasedAllTaskItem(\''+row.workId+'\')"  class="btn btn-success" role="button" ><span class="glyphicon glyphicon-arrow-down" aria-hidden="true" ></span>'+'</a>';
																    	
																    	btnhtml = btnhtml + '&nbsp;'+'<a title="查看所有任务项" onclick="editWorkTask(\''+row.workId+'\')"  class="btn btn-primary" role="button" ><span class="glyphicon glyphicon-eye-open" aria-hidden="true" ></span>'+'</a>';
																    
																    

																	return btnhtml;
																}

														} ],
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
							initDataTable_WorkItemTable();
						}

					});// then方法结束

}

$(document).ready(function() {

	initDataTable_WorkItemTable();

	/*
	 * queryData_SalesOrder();
	 * 
	 * $('#queryBtn').click(function(event){
	 * 
	 * event.preventDefault();
	 * 
	 * queryData_SalesOrder();
	 * 
	 * });
	 */
	/*
	 * 新增按钮事件
	 */
	$('.btnAdd').click(function(event) {

		event.preventDefault();
		// 重置表单
		document.getElementById("add-workitem-form").reset();

		var id_ = $(this).attr('id');
		var type_ = '';
		if (id_ == 'btnAdd01') {
			$('#workType').val('GROUPWORK');
			$('#workTypeDesc').val('集团工作督办');
			type_ = 'GROUPWORK';
		} else if (id_ == 'btnAdd02') {
			$('#workType').val('CHAIRMAN');
			$('#workTypeDesc').val('董事长督办');
			type_ = 'CHAIRMAN';
		} else if (id_ == 'btnAdd03') {
			$('#workType').val('PRESIDENT');
			$('#workTypeDesc').val('总裁督办');
			type_ = 'PRESIDENT';
		} else if (id_ == 'btnAdd04') {
			$('#workType').val('CONFERENCE');
			$('#workTypeDesc').val('会议督办');
			type_ = 'CONFERENCE';
		} else if (id_ == 'btnAdd05') {
			$('#workType').val('ANNUALKEYWORK');
			$('#workTypeDesc').val('年度重点工作督办');
			type_ = 'ANNUALKEYWORK';
		} else if (id_ == 'btnAdd06') {
			$('#workType').val('SPECIALWORK');
			$('#workTypeDesc').val('专项工作督办');
			type_ = 'SPECIALWORK';
		} else if (id_ == 'btnAdd07') {
			$('#workType').val('OFKEYDEPARTMENTS');
			$('#workTypeDesc').val('部门重点工作督办');
			type_ = 'OFKEYDEPARTMENTS';
		} else if (id_ == 'btnAdd08') {
			$('#workType').val('OTHER');
			$('#workTypeDesc').val('其它督办');
			type_ = 'OTHER';
		}

		initWorkItemDO(type_ + findDate());

	});

	/**
	 * 保存按钮事件
	 */
	$('#saveBtn').click(function(eventsave) {
		eventsave.preventDefault();

		addWorkItem();

	});
	
	/**
	 * 查询按钮事件
	 */
	$('#queryBtn').click(function(eventquery){
		
		eventquery.preventDefault();
		queryWorkItemData();
		
	});
	initRecordDate();
	initDateSelector();
	
	//关闭确认按钮事件
	$('#closeAddWorkItemModal').click(function(closeDealCommContentEvent){
		
		   closeDealCommContentEvent.preventDefault();
			
			$('#infoModal').modal('hide');
			$('#workItemModalCenter').modal('hide');
		});

});
