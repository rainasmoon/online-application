<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>我的收藏</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">

		<div class="jumbotron">
			<h1>我的收藏</h1>
			<p>遇到好东西到这里来找</p>
		</div>
		<div class="row">
			<c:forEach var="arow" items="${products}">
				<div class="col-xs-6 col-lg-4">
					<h2>
						<c:out value="${arow.adTitle}" />
					</h2>
					<p>Donec id elit non mi porta gravida at eget metus. Fusce
						dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
						ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
						magna mollis euismod. Donec sed odio dui.</p>
					<p>
						<a class="btn btn-default" href="#" role="button">View details
							&raquo;</a>
					</p>
				</div>
				<!--/.col-xs-6.col-lg-4-->
			</c:forEach>
		</div>
		<!--/row-->
	</div>
	<!--/.col-xs-12.col-sm-9-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"></div>
	<!--/.sidebar-offcanvas-->
</div>
<!--/row-->

<hr>

<jsp:include page="./fragments/footer.jsp" />





