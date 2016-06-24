<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="./fragments/headTag.jsp" />
<title>定单 - 发货</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form action="/order_send.html" method="post" class="form-horizontal">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if>
	</span>
	<fieldset>
		<input type="hidden" name="orderId" value="${orderId }" />

		<div>
			<h1>发货</h1>
			<p>
				定单号：
				<c:out value="${orderId }"></c:out>
			</p>
			<p>
				买家：
				<c:out value="${orderVo.buyerName }"></c:out>
			</p>
			<p>
				商品名：
				<c:out value="${orderVo.productName }"></c:out>
			</p>
			<p>
				收件人：
				<c:out value="${orderVo.receiverName }"></c:out>
			</p>
			<p>
				收件人电话：
				<c:out value="${orderVo.receiverPhone }"></c:out>
			</p>
			<p>
				收件人地址：
				<c:out value="${orderVo.receiverAddress }"></c:out>
			</p>
			<p>
				收件人邮编：
				<c:out value="${orderVo.receiverPostcode }"></c:out>
			</p>

		</div>
		<button class="btn btn-primary" type="button" onclick="goBack()">返回</button>
		<button type="submit" class="btn btn-primary">发货</button>
	</fieldset>
</form>
<script src="js/order.js" type="text/javascript"></script>
<jsp:include page="./fragments/footer.jsp" />







