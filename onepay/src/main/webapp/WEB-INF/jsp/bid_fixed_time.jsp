<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>竞价</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="jumbotron">
	<h1>
		<c:out value="${productVo.productTitle}" />
	</h1>
	<p>竞拍人数：<c:out value="${productVo.bidersCount}" />。。。当前属于：<c:out value="${productVo.currentOwer}" />...结束时间：<c:out value="${productVo.endTime}" /></p>
	<div class="thumbnail">
		<img alt="" src="product_pic/${productVo.picPath }" width="300"
			height="300">

	</div>
	<p class="lead">
		<c:forEach var="arow" items="${productTags}">
			<label class="label label-info"><c:out value="${arow.name}" /></label>
		</c:forEach>
	</p>
	<p>
	<div id="productPrice" class="alert alert-info" role="alert">
		现价：<c:out value="${productVo.price}" />猿
	</div>
	</p>

</div>
<div><p>我要举牌：</p></div>
<div class="row marketing">
	<div class="col-lg-4">
		<a href="javascript:addMoney(1);"
			class="btn btn-primary btn-lg btn-block" role="button">+1猿</a>
	</div>

	<div class="col-lg-4">
		<a href="javascript:addMoney(10);"
			class="btn btn-primary btn-lg btn-block" role="button">+10猿</a>
	</div>
	<div class="col-lg-4">
		<a href="javascript:addMoney(100);"
			class="btn btn-primary btn-lg btn-block" role="button">+100猿</a>
	</div>
</div>
<script src="js/bid_fixed_time.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


