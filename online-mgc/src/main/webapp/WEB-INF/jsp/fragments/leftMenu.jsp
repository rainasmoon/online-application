<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="list-group">
	<c:if test="${userRole == 'manager' }">
		<a class="list-group-item active" href="#"> 后台管理</a>
		<a class="list-group-item"
			href="<spring:url value="/users.html" htmlEscape="true" />"> 用户</a>
		<a class="list-group-item"
			href="<spring:url value="/packages.html" htmlEscape="true" />"> 包</a>
	</c:if>

	<a class="list-group-item active" href="#"> 合作商管理</a> <a
		class="list-group-item"
		href="<spring:url value="/channels.html" htmlEscape="true" />">
		渠道查询</a> <a class="list-group-item"
		href="<spring:url value="/users.html" htmlEscape="true" />"> 用户查询</a>

</div>

