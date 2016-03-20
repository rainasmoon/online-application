<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>市场</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<h1>买</h1>
<form:form method="post"
	class="form-horizontal">
		<input type="hidden" name="yunOrderId" value="${yunOrderId }" />

		<div>
			<h1>买猿币</h1>
			<p>交易号：<c:out value="${yunOrderId }"></c:out></p>
			<p>交易猿币数：<c:out value="${amount }"></c:out></p>
			<p>交易价格（人民币）：<c:out value="${price }"></c:out><strong>这可是真金发银啊，想好了？:)</strong></p>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="js/addproduct.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


