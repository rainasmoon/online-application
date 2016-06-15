<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>猿币市场</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">

		<div class="jumbotron">
			<h1>
				猿币市场<small><a href="market_add_info.html">发布信息</a></small>
			</h1>
		</div>

		<div class="table-responsive">
			<table class="table table-striped ">
				<thead>
					<tr>
						<th>#</th>
						<th>交易类型</th>
						<th>猿币</th>
						<th>价钱（人民币）</th>
						<th>交易人</th>
						<th>交易人级别</th>
						<th>交易人信用</th>
						<th>成交人</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${yunOrders}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}" /></td>
							<td><c:if test="${arow.model ==1 }">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								</c:if>
								<c:if test="${arow.model ==2 }">
									<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
								</c:if>
								<c:out value="${arow.enumModel.name}" /></td>
							<td><c:out value="${arow.amount}" /></td>
							<td><c:out value="${arow.price}" /></td>
							<td><c:out value="${arow.userName}" /></td>
							<td><c:out value="${arow.userLevelName}" /></td>
							<td><c:out value="${arow.userCredit}" /></td>
							<td><c:out value="${arow.dealerName}" /></td>
							<td><c:out value="${arow.enumStatus.name}" /></td>
							<td><c:if test="${not empty arow.operation.operationUrl }">
									<a href="${arow.operation.operationUrl }?yunOrderId=${arow.id}"><c:out
											value="${arow.operation.operationName}" /></a>
								</c:if> <c:if test="${empty arow.operation.operationUrl }">
									<c:out value="${arow.operation.operationName}" />
								</c:if></td>
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

<hr />

<jsp:include page="./fragments/footer.jsp" />




