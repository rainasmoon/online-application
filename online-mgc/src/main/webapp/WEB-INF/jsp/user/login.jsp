
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
			id="login-form">
			<h2 class="form-signin-heading">MGC数据开放系统</h2>
			<span class="help-inline"> <c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>
				</c:if> <spring:bind path="error">
					<c:if test="${status.error}">
						<div id="message" class="alert alert-danger" role="alert">${status.errorMessage}</div>
					</c:if>
				</spring:bind>
			</span>
			<onlineapplication:inputField label="账号" name="userName" />
			<onlineapplication:passwordField label="密码" name="password" />
			<div class="">

				<button class="btn btn-lg btn-primary " type="submit">登录系统</button>

			</div>
		</form:form>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#userName').focus();
		});		
	</script>

</body>

</html>
