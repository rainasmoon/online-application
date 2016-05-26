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
function verifyPhone() {
	sendVerifyPhone();
	$("#modifyPhone")
			.html(
					"<input id='newInputVerifyPhone'/><button onclick='verifyPhoneCode()'>验证</button>");
}
function verifyFreezeCode() {
	$("#freezeCode")
			.html(
					"<input id='newInputFreezeCode'/><button onclick='sendVerifyCode()'>验证</button>");
}

function sendVerifyPhone() {
	$.get("restful/sendVerifyPhone");
}

function verifyPhoneCode() {
	$.post("restful/verifyPhoneCode", {
		phoneCode : $("#newInputVerifyPhone").val()
	}, function(data, status) {
		$("#modifyPhone").html(
				data + ' | <a href="javascript:verifyFreezeCode()">输入解冻码</a>');
	});
}

function sendVerifyCode() {
	$.post("restful/verifyFreezeCode", {
		verifyCode : $("#newInputFreezeCode").val()
	}, function(data, status) {
		$("#freezeCode").html(data + '');
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

function isEmailLegal(str) {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}

function saveUserInfoEmail() {
	if (!isEmailLegal($("#newInputEmail").val())) {
		$("#modifyEmail")
				.html(
						'邮箱格式不正确  | <a href="javascript:modifyEmail()">编辑</a> | <a href="send_verify_email.html">验证邮箱</a>');
		return;
	}
	$
			.post(
					"restful/saveUserInfo",
					{
						field : 'email',
						value : $("#newInputEmail").val()
					},
					function(data, status) {
						$("#modifyEmail")
								.html(
										data
												+ ' | <a href="javascript:modifyEmail()">编辑</a> | <a href="send_verify_email.html">验证邮箱</a>');
					});
}

function isPhoneLegal(str) {
	var reg = /^[1][3,4,5,8][0-9]{9}$/;
	return reg.test(str);
}

function saveUserInfoPhone() {
	if (!isPhoneLegal($("#newInputPhone").val())) {
		$("#modifyPhone")
				.html(
						'手机格式不正确  | <a href="javascript:modifyPhone()">编辑</a> | <a href="javascript:verifyPhone()">验证手机</a>');
		return;
	}
	$
			.post(
					"restful/saveUserInfo",
					{
						field : 'phone',
						value : $("#newInputPhone").val()
					},
					function(data, status) {
						$("#modifyPhone")
								.html(
										data
												+ ' | <a href="javascript:modifyPhone()">编辑</a> | <a href="javascript:verifyPhone()">验证手机</a>');
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