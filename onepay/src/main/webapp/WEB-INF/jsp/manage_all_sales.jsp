<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>所有商品</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/manageBodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div >
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>名称</th>
						<th>卖者</th>
						<th>当前竞拍者</th>
						<th>拍卖形式</th>						
						<th>价钱</th>
						<th>原价</th>
						<th>状态</th>
						<th>操作</th>
						<th>aging</th>
						<th>description</th>
						<th>end date</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${products}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><a href="view_product.html?productId=${arow.id }"><c:out value="${arow.name}"/></a></td>
							<td><c:out value="${arow.ownerId}" /></td>
							<td><c:out value="${arow.currentBiderName}" /></td>
							<td><c:out value="${arow.enumSaleModel.name}" /></td>
							<td><c:out value="${arow.price}" /></td>
							<td><c:out value="${arow.originalPrice}" /></td>
							<td><c:out value="${arow.enumStatus.name}" /></td>
							<td><c:out value="${arow.operation}" /></td>
							<td><c:out value="${arow.aging}" /></td>
							<td><c:out value="${arow.description}" /></td>
							<td><c:out value="${arow.endDate}" /></td>
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

<hr/>

<jsp:include page="./fragments/footer.jsp" />




