<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>用户信息</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<h2 class="sub-header">英雄详情</h2>
<div class="table-responsive">
	<table class="table table-striped">
		<tbody>
			
			<tr>
				<td>邮箱</td>
				<td><div id="modifyEmail">
						<c:out value="${user.email}" />
						| <a href="javascript:modifyEmail()">编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><div id="modifyPhone">
						<c:out value="${user.phone}" />
						| <a href="javascript:modifyPhone()">编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><div id="modifyNickName">
						<c:out value="${user.nickName}" />
						| <a href="javascript:modifyNickName()">编辑</a>
					</div></td>
			</tr>
			<tr>
				<td>标签</td>
				<td><div id="listTags"><c:forEach var="arow" items="${userTags}">
						<label class="label label-info"><c:out value="${arow.name}" /></label>
					</c:forEach></div>
					<div id="addTag">
						| <a href="javascript:addTag()">add </a>
					</div></td>
			</tr>
			<tr>
				<td>卖出总额（猿币）</td>
				<td><c:out value="${user.sellAmount}" /></td>
			</tr>
			<tr>
				<td>买入总额（猿币）</td>
				<td><c:out value="${user.buyAmount}" /></td>
			</tr>
			<tr>
				<td>合计（猿币）</td>
				<td><c:out value="${user.totalAmount}" /></td>
			</tr>
			<tr>
				<td>账户（猿币）</td>
				<td><c:out value="${user.account}" /></td>
			</tr>
			<tr>
				<td>冻结（猿币）</td>
				<td><c:out value="${user.freezeAccount}" /><a>输入解冻码</a></td>
			</tr>
			<tr>
				<td>级别</td>
				<td><c:out value="${user.levelName}" /></td>
			</tr>
			<tr>
				<td>信用</td>
				<td><c:out value="${user.credit}" /></td>
			</tr>
		</tbody>
	</table>
</div>

<script src="js/view_me.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


