<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>定单 - 添写</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form:form modelAttribute="fillOrderVo" method="post"
	class="form-horizontal">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if>
	</span>
	<fieldset>
		<input type="hidden" name="orderId" value="${orderId }" />

		<div>
			<h1>完善信息</h1>
			<p>
				定单号：
				<c:out value="${orderId }"></c:out>
			</p>
			<onepayapp:inputField label="发件人姓名" name="senderName"
				autofocus="true" required="true" />
			<onepayapp:inputField label="发件人电话" name="senderPhone"
				required="true" />
			<onepayapp:inputField label="发件人地址" name="senderAddress"
				required="true" />
			<onepayapp:inputField label="发件人邮编" name="senderPostcode"
				required="true" />

			<onepayapp:inputField label="收件人姓名" name="receiverName"
				required="true" />
			<onepayapp:inputField label="收件人电话" name="receiverPhone"
				required="true" />
			<onepayapp:inputField label="收件人地址" name="receiverAddress"
				required="true" />
			<onepayapp:inputField label="收件人邮编" name="receiverPostcode"
				required="true" />
		</div>
		<button class="btn btn-primary" type="button" onclick="goBack()">返回</button>
		<button type="submit" class="btn btn-primary">完成</button>
	</fieldset>
</form:form>

<script src="js/order.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />