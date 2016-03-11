<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>用户信息</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<h2 class="sub-header">英雄详情</h2>
<div class="table-responsive">
	<table class="table table-striped">
		<tbody>
			<tr>
				<td>用户名</td>
				<td><c:out value="${user.id}" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><div id="modifyEmail">
						<c:out value="${user.email}" />
						<a href="javascript:modifyEmail()"> | 编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><div id="modifyPhone">
						<c:out value="${user.phone}" />
						<a href="javascript:modifyPhone()"> | 编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><div id="modifyNickName">
						<c:out value="${user.nickName}" />
						<a href="javascript:modifyNickName()"> | 编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>标签</td>
				<td><c:out value="${user.tags}" />
					<div id="addTag">
						<a href="javascript:addTag()"> | add </a>
					</div></td>
			</tr>
			<tr>
				<td>卖出总额</td>
				<td><c:out value="${user.sellAmount}" /></td>
			</tr>
			<tr>
				<td>买入总额</td>
				<td><c:out value="${user.buyAmount}" /></td>
			</tr>
			<tr>
				<td>合计</td>
				<td><c:out value="${user.totalAmount}" /></td>
			</tr>
			<tr>
				<td>级别</td>
				<td><c:out value="${user.level}" /></td>
			</tr>
			<tr>
				<td>信用</td>
				<td><c:out value="${user.credit}" /></td>
			</tr>
		</tbody>
	</table>
</div>
<script type="text/javascript">
	function addTag() {
		$("#addTag")
				.html(
						"<input id='newInputTag'/><button onclick='saveUserTag()'>保存</button>");
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
	function saveUserTag() {
		$.post("saveUserTag", {
			userId : '${user.id}',
			value : $("#newInputTag").val()
		}, function(data, status) {
			$("#addTag").html(
					data + ' | <a href="javascript:addTag()">add</a>');
		});
	}
	function saveUserInfoEmail() {
		$.post("saveUserInfo", {
			userId : '${user.id}',
			field : 'email',
			value : $("#newInputEmail").val()
		}, function(data, status) {
			$("#modifyEmail").html(
					data + ' | <a href="javascript:modifyEmail()">编辑</a>');
		});
	}
	function saveUserInfoPhone() {
		$.post("saveUserInfo", {
			userId : '${user.id}',
			field : 'phone',
			value : $("#newInputPhone").val()
		}, function(data, status) {
			$("#modifyPhone").html(
					data + ' | <a href="javascript:modifyPhone()">编辑</a>');
		});
	}
	function saveUserInfoNickName() {
		$.post("saveUserInfo", {
			userId : '${user.id}',
			field : 'nickName',
			value : $("#newInputNickName").val()
		}, function(data, status) {
			$("#modifyNickName").html(
					data + ' | <a href="javascript:modifyNickName()">编辑</a>');
		});
	}
</script>
<jsp:include page="./fragments/footer.jsp" />


