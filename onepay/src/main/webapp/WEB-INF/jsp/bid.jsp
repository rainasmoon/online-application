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
	<p>

		当前属于：
		<div id="currentOwner"><c:out value="${productVo.currentOwer}" /></div>
	
		<c:if test="${not empty endDate }"> | 结束时间为： <c:out
				value="${endDate }" />
		</c:if>
	</p>
	<div class="thumbnail">
		<img alt="" src="product_pic/${productVo.picPath }" width="300"
			height="300" />

	</div>
	<p class="lead">
		<c:forEach var="arow" items="${productTags}">
			<label class="label label-info"><c:out value="${arow.name}" /></label>
		</c:forEach>
	</p>
	<h4>
		<div id="productPrice" class="alert alert-info text-center"
			role="alert">
			
			<c:if test="${saleModel != 'guess_price' }">
				<c:out value="${productVo.price}" />
			</c:if>
			<c:if test="${saleModel == 'guess_price' }">???</c:if>
		</div>
	</h4>

</div>
<div>
	<h3 class="bg-info text-center">
		<strong>我要举牌：</strong>
	</h3>
</div>
<c:if test="${saleModel != 'guess_price' }">
	<div class="row marketing">
		<div class="col-lg-4">
			<a href="javascript:addMoney('${productVo.productId}', 1);"
				class="btn btn-primary btn-lg btn-block" role="button">+1猿</a>
		</div>

		<div class="col-lg-4">
			<a href="javascript:addMoney('${productVo.productId}', 10);"
				class="btn btn-primary btn-lg btn-block" role="button">+10猿</a>
		</div>
		<div class="col-lg-4">
			<a href="javascript:addMoney('${productVo.productId}', 100);"
				class="btn btn-primary btn-lg btn-block" role="button">+100猿</a>
		</div>
	</div>
</c:if>

<c:if test="${saleModel == 'guess_price' }">
	<div class="row marketing">

		<div class="form-group">
			<label class="sr-only" for="guessPrice">猜个价钱</label>
			<div class="input-group">
				<div class="input-group-addon">$</div>
				<input type="number" class="form-control" id="guessPrice"
					placeholder="给个价">
				<div class="input-group-addon">.00</div>
			</div>
		</div>
		<button type="button" class="btn btn-primary"
			onclick="guessMoney('${productVo.productId}')">拍</button>

	</div>
</c:if>
<input type="hidden" id="saleModel" value="${saleModel }"/>
<input type="hidden" id="productId" value="${productVo.productId }"/>
<script src="js/bid.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


