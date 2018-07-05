function openOrgDialog(selectType) {

	$('#SupervisorId').val('');
	$('#SupervisorName').val('');

	$.ajax({
		type : 'GET',
		url : '/SoundWSS/wss/list/treenode',

		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
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
		} else if (selectType == 'undertaker') {
			$('#addUndertakerBtn').show();
			$('#addSupervisionBtn').hide();
		}

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
	}

	$('#OrgModal').modal('hide');
}