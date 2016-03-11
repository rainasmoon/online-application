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

<h2 class="sub-header">英雄榜</h2>
<div class="table-responsive">
	<table class="table table-striped">
		<tbody>
			<tr>
				<td>用户名</td>
				<td><c:out value="${user.id}" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><c:out value="${user.id}" /></td>
			</tr>
			<tr>
				<td>手机</td>
				<td><c:out value="${user.id}" /></td>
			</tr>
		</tbody>
	</table>
</div>

<jsp:include page="./fragments/footer.jsp" />


