<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>
<html lang="en">
<jsp:include page="../fragments/headTag.jsp" />
<body>
	<div class="container">
		<form:form modelAttribute="loginVo" method="post" class="form-signin"
			id="login-form" role="form">
			<h2 class="form-signin-heading">登录</h2>
			<span class="help-inline"> <c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>
				</c:if> <spring:bind path="error">
					<c:if test="${status.error}">
						<div id="message" class="error">${status.errorMessage}</div>
					</c:if>
				</spring:bind>
			</span>
			<onlineapplication:inputField label="邮箱" name="email" />
			<onlineapplication:passwordField label="密码" name="password" />
			<onlineapplication:inputField label="验证码" name="checkCode" />
			<div>
				<br/>
				<img id="jcaptchaImg"
					src="<spring:url value="/jcaptcha.jpg" htmlEscape="true" />" /> <a
					href="javascript:refreshJcaptchaImg()">看不清？</a>
			</div>
			<div class="row">
				<div class="col-md-6">
					<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
				</div>
				<div class="col-md-6">
					<a class="btn btn-lg btn-primary btn-block"
						href="<spring:url value="/register.html" htmlEscape="true" />">
						注册</a>
				</div>
			</div>
		</form:form>

		<jsp:include page="../fragments/footer.jsp" />
	</div>

	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#email').focus();
		});
		function refreshJcaptchaImg() {
		d = new Date();
		$("#jcaptchaImg").attr("src", "./jcaptcha.jpg?"+d.getTime());
	}
	</script>

</body>

</html>
