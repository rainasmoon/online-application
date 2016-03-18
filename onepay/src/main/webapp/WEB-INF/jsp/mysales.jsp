<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>我的产品</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">

		<div class="jumbotron">
			<h1>我的出售</h1>
			<p>今天也努力卖东西</p>
		</div>
		<h2 class="sub-header">我的出售货品</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>current bider</th>
						<th>sale model</th>
						<th>price</th>
						<th>status</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${products}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><a href="view_product.html?productId=${arow.id }"><c:out value="${arow.name}"/></a></td>
							<td><c:out value="${arow.currentBiderId}" /></td>
							<td><c:out value="${arow.saleModel}" /></td>
							<td><c:out value="${arow.price}" /></td>
							<td><c:out value="${arow.status}" /></td>
							<td><c:out value="${arow.id}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!--/.col-xs-12.col-sm-9-->

	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"></div>
	<!--/.sidebar-offcanvas-->
</div>
<!--/row-->

<hr>

<jsp:include page="./fragments/footer.jsp" />




