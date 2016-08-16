<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>用户反馈 － 您的第一印象是？ － 一元网</title>
<link href="css/signin.css" rel="stylesheet" />

<jsp:include page="./fragments/bodyHeader.jsp" />

<h1>用户反馈 － 您的第一印象是？ － 一元网</h1>
<form:form action="/feedback.html" modelAttribute="feedback" method="post"
	class="form-horizontal" id="add-feedback-form">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if> <spring:bind path="*">
			<c:if test="${status.error}">
				<div id="error" class="alert alert-danger" role="alert">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>
	<fieldset>
		<hr />
		<div>
			<label for="inputDescription">专业吐槽</label>
			<textarea id="content_id" name="content" class="form-control"
				rows="3" ></textarea>
		</div>
		<hr />

		<button id="submit" type="submit" class="btn btn-primary">提交</button>
	</fieldset>
</form:form>



<jsp:include page="./fragments/footer.jsp" />