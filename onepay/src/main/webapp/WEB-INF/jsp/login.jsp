<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>Signin</title>
<link href="css/signin.css" rel="stylesheet" />

<jsp:include page="./fragments/bodyHeader.jsp" />

<form:form modelAttribute="loginVo" method="post" class="form-signin"
	id="login-form" role="form">
	<h2 class="form-signin-heading">Please sign in</h2>
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if> <spring:bind path="error">
			<c:if test="${status.error}">
				<div id="error" class="alert alert-danger" role="alert">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>

	<fieldset>
		<onlineapplication:inputField label="手机号|邮箱" name="account"
			required="true" autofocus="true"/>
		<onlineapplication:passwordField label="密码" name="password"
			required="true" />
	</fieldset>

	<div class="checkbox">
<!-- 		<label> <input type="checkbox" value="remember-me" /> -->
<!-- 			Remember me -->
<!-- 		</label> -->
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">登录|注册</button>
</form:form>

<jsp:include page="./fragments/footer.jsp" />