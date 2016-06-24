<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>重置密码 - 申请</title>
<link href="css/signin.css" rel="stylesheet" />

<jsp:include page="./fragments/bodyHeader.jsp" />

<h1>重置密码申请</h1>
<form:form action="/reset_password_application.html" modelAttribute="resetPasswordApplication" method="post"
	class="form-horizontal" id="add-resetpassword-application-form">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if> <spring:bind path="*">
			<c:if test="${status.error}">
				<div id="error" class="alert alert-danger" role="alert">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>
	<fieldset>
		<onepayapp:inputField label="账号" name="loginAccount" autofocus="true"
			required="true" />
		<hr />
		<div>
			<label for="inputDescription">事实描述</label>
			<textarea id="description" name="description" class="form-control"
				rows="3"></textarea>
		</div>
		<hr />
		<onepayapp:inputField label="曾用密码1" name="password1" required="true" />
		<onepayapp:inputField label="曾用密码2" name="password2" />
		<onepayapp:inputField label="曾用密码3" name="password3" />
		<hr />
		<onepayapp:inputField label="接收新密码邮箱" name="receiveResetEmail" required="true" />
		<button id="submit" type="submit" class="btn btn-primary">提交</button>
	</fieldset>
</form:form>



<jsp:include page="./fragments/footer.jsp" />