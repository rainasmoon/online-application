<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="./fragments/headTag.jsp" />
<title>支付</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form action="order_sale_star.html" method="post" class="form-horizontal">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if>
	</span>
	<fieldset>
		<input type="hidden" name="orderId" value="${orderId }" />

		<div>
			<h1>Pay</h1>
			<p>定单号：<c:out value="${orderId }"></c:out></p>
			<p>定单金额：<c:out value="${amount }"></c:out></p>
			<p>账户余额：<c:out value="${account }"></c:out></p>
		</div>

		<button type="submit" class="btn btn-primary">支付</button>
	</fieldset>
</form>

<jsp:include page="./fragments/footer.jsp" />







