<%@page session="false" %>
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


				<h2>创建应用</h2>
				<form:form modelAttribute="application" method="post"
					class="form-horizontal" id="add-application-form">
					<span class="help-inline"> <c:if test="${not empty message}">
							<div id="message" class="success">${message}</div>
						</c:if> <spring:bind path="error">
							<c:if test="${status.error}">
								<div id="message" class="error">${status.errorMessage}</div>
							</c:if>
						</spring:bind>
					</span>
					<onlineapplication:inputField label="应用名称" name="applicationName" />
					<onlineapplication:radioButtonsField label="应用平台"
						name="applicationPlatform" names="${platformTypes}" />
					<onlineapplication:inputField label="应用包名"
						name="applicationPackageName" />
					<div class="alert alert-info">packageName / bundle
						identifier,如com.example.helloworld</div>

					<div class="form-actions">

						<button class="btn btn-lg btn-primary btn-block" type="submit">创建应用</button>

					</div>
				</form:form>




			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#applicationName').focus();
		});
	</script>
</body>

</html>
