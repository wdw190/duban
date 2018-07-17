function openOrgDialog(selectType) {

	$('#SupervisorId').val('');
	$('#SupervisorName').val('');

	$.ajax({
		type : 'GET',
		url : '/SoundWSS/wss/list/treenode',

		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
			$('#loadingInfoModal').modal('show');
		}
	}).then(function(data) {

		$('#treeview1').treeview({
			color : "#3e9ff8",
			data : data.workTaskList,
			onNodeSelected : function(event, node) {
				$('#SupervisorName').val(node.text);
				$('#SupervisorId').val(node.href);
			}
		});

		if (selectType == 'supervision') {
			$('#addSupervisionBtn').show();
			$('#addUndertakerBtn').hide();
			$('#addUndertakerdeptBtn').hide();
			$('#addAssistdeptpBtn').hide();
		} else if (selectType == 'undertaker') {
			$('#addUndertakerBtn').show();
			$('#addSupervisionBtn').hide();
			$('#addUndertakerdeptBtn').hide();
			$('#addAssistdeptpBtn').hide();
		}else if (selectType == 'undertakerdept') {
			$('#addUndertakerBtn').hide();
			$('#addSupervisionBtn').hide();
			$('#addUndertakerdeptBtn').show();
			$('#addAssistdeptpBtn').hide();
		}else if (selectType == 'assistdeptp') {
			$('#addUndertakerBtn').hide();
			$('#addSupervisionBtn').hide();
			$('#addUndertakerdeptBtn').hide();
			$('#addAssistdeptpBtn').show();
		}

		$('#loadingInfoModal').modal('hide');
		$('#OrgModal').modal('show');

	});

}

/**
 * 
 * @returns
 */
function addSupervisor(valueType) {

	if (valueType == 'supervision') {
		$('#supervisor').val($('#SupervisorId').val());
	} else if (valueType == 'undertaker') {
		$('#assignee').val($('#SupervisorId').val());
	}else if (valueType == 'undertakerdept') {
		$('#assigneeDept').val($('#SupervisorName').val());
	}else if (valueType == 'assistdeptp') {
		$('#assist').val($('#SupervisorName').val());
	}

	$('#OrgModal').modal('hide');
}