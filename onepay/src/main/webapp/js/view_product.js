function addTag() {
	$("#addTag")
			.html(
					"<input id='newInputTag' autofocus/><button onclick='saveProductTag()'>保存</button>");
}
function modifyDescription() {
	$("#modifyDescription")
			.html(
					'<textarea id="newInputDescription" class="form-control" rows="3"></textarea><button onclick="saveProductDescription()">保存</button>');
}

function saveProductTag() {
	$.post("restful/saveProductTag", {
		productId : '${product.id}',
		value : $("#newInputTag").val()
	}, function(data, status) {
		$("#addTag").html(' | <a href="javascript:addTag()">add</a>');
		$("#listTags").append(
				'<label class="label label-info">' + data + '</label>');
	});
}

function saveProductDescription() {
	$.post("restful/saveProductInfo", {
		productId : '${product.id}',
		field : 'description',
		value : $("#newInputDescription").val()
	}, function(data, status) {
		$("#modifyDescription").html(
				data + ' | <a href="javascript:modifyDescription()">编辑</a>');
	});
}