<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>list product</title>

<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">

<!-- 		<div class="jumbotron"> -->
<!-- 			<h1> -->
<!-- 				总成交额： -->
<%-- 				<c:out value="${vo.totalAmount}" /> --%>
<!-- 			</h1> -->
<!-- 			<p> -->
<!-- 				今日成交： -->
<%-- 				<c:out value="${vo.todayAmount}" /> --%>
<!-- 				；注册用户数： -->
<%-- 				<c:out value="${vo.totalUserCount}" /> --%>
<!-- 				；在线人数： -->
<%-- 				<c:out value="${vo.onlineUserCount}" /> --%>
<!-- 				；总商品数： -->
<%-- 				<c:out value="${vo.totalGoodCount}" /> --%>
<!-- 			</p> -->
<!-- 		</div> -->
		<div class="row">
			<c:forEach var="arow" items="${vo.products}">
				<div class="col-xs-6 col-lg-4">
				<img class="img-circle" src="product_pic/${arow.picPath }"
					alt="Generic placeholder image" width="140" height="140">
					<h2>
						<c:out value="${arow.adTitle}" />
					</h2>
					<p><c:out value="${arow.adDescription}" /></p>
					<p>
						<a class="btn btn-default" href="bid.html?productId=${arow.objId }" role="button">View details
							&raquo;</a>
					</p>
				</div>
				<!--/.col-xs-6.col-lg-4-->
			</c:forEach>
		</div>
		<!--/row-->
	</div>
	<!--/.col-xs-12.col-sm-9-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		<ul class="list-group">
			<a href="top10users.html" class="list-group-item active">用户排行榜</a>
			<c:forEach var="arow" items="${vo.activeTop5Users}">
				<li href="#" class="list-group-item"><c:out
						value="${arow.nickName}" /> <c:out value="${arow.totalAmount}" /></li>
			</c:forEach>
		</ul>
	</div>
	<!--/.sidebar-offcanvas-->
</div>
<!--/row-->

<hr>

<script src="js/listproduct.js"></script>
<jsp:include page="./fragments/footer.jsp" />

