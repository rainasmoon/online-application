function addTag(productId) {
	$("#addTag").html(
			"<input id='newInputTag' autofocus/><button onclick='saveProductTag("
					+ productId + ")'>保存</button>");
}
function modifyDescription(productId) {
	$("#modifyDescription")
			.html(
					'<textarea id="newInputDescription" class="form-control" rows="3"></textarea><button onclick="saveProductDescription('
							+ productId + ')">保存</button>');
}

function saveProductTag(productId) {
	$.post("restful/saveProductTag", {
		productId : productId,
		value : $("#newInputTag").val()
	}, function(data, status) {
		$("#addTag").html(' | <a href="javascript:addTag()">add</a>');
		$("#listTags").append(
				'<label class="label label-info">' + data + '</label>');
	});
}

function saveProductDescription(productId) {
	$.post("restful/saveProductInfo", {
		productId : productId,
		field : 'description',
		value : $("#newInputDescription").val()
	}, function(data, status) {
		$("#modifyDescription").html(
				data + ' | <a href="javascript:modifyDescription()">编辑</a>');
	});
}