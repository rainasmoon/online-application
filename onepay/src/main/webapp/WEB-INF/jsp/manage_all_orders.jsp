<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>所有定单</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/manageBodyHeader.jsp" />

<div class="row row-offcanvas row-offcanvas-right">

	<div class="col-xs-12 col-sm-9">

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>卖家</th>
						<th>买家</th>
						<th>产品</th>
						<th>价钱(猿币)</th>
						<th>状态</th>
						<th>操作</th>
						<th>senderStars</th>
						<th>receiverStars</th>
						
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${orders}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}" /></td>
							<td><c:out value="${arow.salerName}" /></td>
							<td><c:out value="${arow.buyerName}" /></td>
							<td><c:out value="${arow.productName}" /></td>
							<td><c:out value="${arow.price}" /></td>
							<td><c:out value="${arow.enumStatus.name}" /></td>
							<td><c:out value="${arow.operation.operationName}" /></td>
							<td><c:out value="${arow.senderStars}" /></td>
							<td><c:out value="${arow.receiverStars}" /></td>
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




