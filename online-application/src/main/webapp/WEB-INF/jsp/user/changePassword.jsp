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
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">

				<h2>重设密码</h2>
				<form:form modelAttribute="changePasswordVo" method="post"
					class="form-horizontal" id="login-form">
					<span class="help-inline"> <c:if test="${not empty message}">
							<div id="message" class="success">${message}</div>
						</c:if> <spring:bind path="error">
							<c:if test="${status.error}">
								<div id="message" class="alert alert-danger" role="alert">${status.errorMessage}</div>
							</c:if>
						</spring:bind>
					</span>
					<fieldset>
						<onlineapplication:passwordField label="旧密码" name="oldPassword" required="true" />
						<onlineapplication:passwordField label="新密码" name="newPassword" required="true" />
						<onlineapplication:passwordField label="确认密码"
							name="confirmPassword" required="true" />
						<div class="form-actions">

							<button class="btn btn-lg btn-primary " type="submit">修改</button>

						</div>
					</fieldset>
				</form:form>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#oldPassword').focus();
		});
	</script>
</body>

</html>
