<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>1元起拍闲置网</title>

<style type="text/css">
body {
	padding-top: 0px;
}
</style>

<jsp:include page="./fragments/bodyHeader.jsp" />
<h1>一元网 － 拍闲置</h1>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach var="arow" items="${vo.ads}" varStatus="status">
			<li data-target="#myCarousel" data-slide-to="${status.index}"
				<c:if test="${status.first}"> class="active"</c:if>></li>
		</c:forEach>

	</ol>
	<div class="carousel-inner" role="listbox">
		<c:forEach var="arow" items="${vo.ads}" varStatus="status">
			<div class="item <c:if test="${status.first}">active</c:if>">
				<img class="first-slide" src="${arow.picPath }" alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h2>${arow.adTitle }</h2>
						<p>${arow.adDescription }</p>
						<p>
							<a class="btn btn-lg btn-primary" href="${arow.urlLink }" role="button">${arow.urlName }</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<c:forEach var="arow" items="${vo.top3}">
			<div class="col-lg-4">
				<img class="img-circle" src="${arow.picPath }"
					alt="Generic placeholder image" width="140" height="140">
				<h2>${arow.adTitle }</h2>
				<p>${arow.adDescription }</p>
				
			</div>
			<!-- /.col-lg-4 -->
		</c:forEach>
	</div>
	<!-- /.row -->


	<!-- START THE FEATURETTES -->

	<hr class="featurette-divider">

	<c:forEach var="arow" items="${vo.imp3}" varStatus="status">
		<div class="row featurette">
			<c:if test="${status.count%2 == '0'}">
				<div class="col-md-7">
					<h2 class="featurette-heading">
						${arow.adTitle } <span class="text-muted"><a href="bid-${arow.objId }.html" role="button">查看 &raquo;</a></span>
					</h2>
					<p class="lead">${arow.adDescription }</p>
				</div>
				<div class="col-md-5">
					<img class="featurette-image img-responsive center-block"
						src="product_pic/${arow.picPath }" alt="${arow.adTitle };${arow.adDescription }">
				</div>
			</c:if>
			<c:if test="${status.count%2 != '0'}">
				<div class="col-md-7 col-md-push-5">
					<h2 class="featurette-heading">
						${arow.adTitle } <span class="text-muted"><a href="bid-${arow.objId }.html" role="button">查看 &raquo;</a></span>
					</h2>
					<p class="lead">${arow.adDescription }</p>
				</div>
				<div class="col-md-5 col-md-pull-7">
					<img class="featurette-image img-responsive center-block"
						src="product_pic/${arow.picPath }" alt="${arow.adTitle };${arow.adDescription }">
				</div>
			</c:if>
		</div>

		<hr class="featurette-divider">
	</c:forEach>

	<!-- /END THE FEATURETTES -->
</div>

<jsp:include page="./fragments/footer.jsp" />
