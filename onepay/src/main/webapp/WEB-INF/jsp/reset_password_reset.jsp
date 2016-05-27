<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>重置密码</title>
<link href="css/signin.css" rel="stylesheet" />

<jsp:include page="./fragments/bodyHeader.jsp" />

<h1>重置密码</h1>
<form:form modelAttribute="resetPasswordVo" method="post"
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
		<onepayapp:hiddenField name="account" />
		<onepayapp:passwordField label="新密码" name="password"
			required="true" autofocus="true" />	
		<onepayapp:passwordField label="确认密码" name="confirmPassword"
			required="true"  />
		
		<button id="submit" type="submit" class="btn btn-primary">提交</button>
	</fieldset>
</form:form>



<jsp:include page="./fragments/footer.jsp" />