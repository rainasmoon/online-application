function addTag() {
	$("#addTag")
			.html(
					"<input id='newInputTag' autofocus/><button onclick='saveUserTag()'>保存</button>");
}
function modifyEmail() {
	$("#modifyEmail")
			.html(
					"<input id='newInputEmail'/><button onclick='saveUserInfoEmail()'>保存</button>");
}
function modifyPhone() {
	$("#modifyPhone")
			.html(
					"<input id='newInputPhone'/><button onclick='saveUserInfoPhone()'>保存</button>");
}
function modifyNickName() {
	$("#modifyNickName")
			.html(
					"<input id='newInputNickName'/><button onclick='saveUserInfoNickName()'>保存</button>");
}
function verifyFreezeCode() {
	$("#freezeCode")
			.html(
					"<input id='newInputFreezeCode'/><button onclick='sendVerifyCode()'>验证</button>");
}
function sendVerifyCode() {
	$.post("restful/verifyFreezeCode", {
		freezeCode : $("#newInputFreezeCode").val()
	}, function(data, status) {
		$("#freezeCode").html(
				data + ' | <a href="javascript:verifyFreezeCode()">输入解冻码</a>');
	});
}

function saveUserTag() {
	$.post("restful/saveUserTag", {
		value : $("#newInputTag").val()
	}, function(data, status) {
		$("#addTag").html(' | <a href="javascript:addTag()">add</a>');
		$("#listTags").append(
				'<label class="label label-info">' + data + '</label>');
	});
}
function saveUserInfoEmail() {
	$.post("restful/saveUserInfo", {
		field : 'email',
		value : $("#newInputEmail").val()
	}, function(data, status) {
		$("#modifyEmail").html(
				data + ' | <a href="javascript:modifyEmail()">编辑</a> | <a href="send_verify_email.html">验证邮箱</a>');
	});
}
function saveUserInfoPhone() {
	$.post("restful/saveUserInfo", {
		field : 'phone',
		value : $("#newInputPhone").val()
	}, function(data, status) {
		$("#modifyPhone").html(
				data + ' | <a href="javascript:modifyPhone()">编辑</a>');
	});
}
function saveUserInfoNickName() {
	$.post("restful/saveUserInfo", {
		field : 'nickName',
		value : $("#newInputNickName").val()
	}, function(data, status) {
		$("#modifyNickName").html(
				data + ' | <a href="javascript:modifyNickName()">编辑</a>');
	});
}