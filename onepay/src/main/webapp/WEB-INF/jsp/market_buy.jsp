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
<form:form modelAttribute="yunOrder" method="post"
	class="form-horizontal" >
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if> <spring:bind path="*">
			<c:if test="${status.error}">
				<div id="error" class="alert alert-danger" role="alert">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>
	<fieldset>
	<div class="control-group">
			<label for="inputPicFile" class="control-label">交易类型</label> <label
				class="radio-inline"> <input type="radio" name="tradeModel"
				id="tradeModel1" value="buy" checked /> 买
			</label> <label class="radio-inline"> <input type="radio"
				name="tradeModel" id="tradeModel2" value="sell" /> 卖
			</label> 
		</div>
		<onepayapp:inputField label="猿币" name="amount" type="number" />
		<onepayapp:inputField label="底价" name="price" type="number" />
		<hr />
		<div>
			<label for="description">描述</label>
			<textarea id="description" name="description" class="form-control"
				rows="3"></textarea>
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</fieldset>
</form:form>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="js/addproduct.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


