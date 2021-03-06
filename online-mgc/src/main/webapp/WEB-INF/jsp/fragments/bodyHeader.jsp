<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button data-target=".navbar-collapse" data-toggle="collapse"
			class="navbar-toggle" type="button">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="#" class="navbar-brand">数据查询系统</a>
	</div>

	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">
			<li><a><c:out value="${userName}" /></a></li>
			<li><a
				href="<spring:url value="/logout.html" htmlEscape="true" />">退出</a></li>
		</ul>
	</div>
</div>

