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
		<a href="#" class="navbar-brand">开发者中心</a>
	</div>

	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li style="width: 100px;"><a
				href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-home"></i> 首页</a></li>
			<li style="width: 130px;"><a
				href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-search"></i> 常见问题</a></li>
			<li style="width: 140px;"><a
				href="<spring:url value="/" htmlEscape="true" />"><i
					class="icon-th-list"></i> 下载ＳＤＫ</a></li>


		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"><c:out value="${userEmail}" /><b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a
						href="<spring:url value="/viewMe.html" htmlEscape="true" />">基本信息</a></li>
					<li><a
						href="<spring:url value="/changePassword.html" htmlEscape="true" />">修改密码</a></li>
					<li><a
						href="<spring:url value="/logout.html" htmlEscape="true" />">退出</a></li>
				</ul></li>
		</ul>

	</div>
</div>

