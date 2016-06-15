<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="./fragments/headTag.jsp" />
<title>定单 - 收货</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form action="order_receive.html" method="post" class="form-horizontal">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if>
	</span>
	<fieldset>
		<input type="hidden" name="orderId" value="${orderId }" />

		<div>
			<h1>收货</h1>
			<p>
				定单号：
				<c:out value="${orderId }"></c:out>
			</p>

		</div>
		<button class="btn btn-primary" type="button" onclick="goBack()">返回</button>
		<button type="submit" class="btn btn-primary">收货</button>
	</fieldset>
</form>
<script src="js/order.js" type="text/javascript"></script>
<jsp:include page="./fragments/footer.jsp" />







