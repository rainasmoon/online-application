<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />

<title>英雄榜</title>
<link href="css/top10users.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="row">
	<div class="col-sm-3 col-md-2 sidebar">top 10</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">VIP</h1>

		<div class="row placeholders">

			<c:forEach var="arow" items="${vip4users}">
				<div class="col-xs-6 col-sm-3 placeholder">
					<img src="<c:out value="${arow.picPath}"/>" class="img-responsive"
						alt="Generic placeholder thumbnail">
					<h4><c:out value="${arow.adTitle}"/></h4>
					<span class="text-muted"><c:out value="${arow.urlName}"/></span>
				</div>
			</c:forEach>
		</div>

		<h2 class="sub-header">英雄榜</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>User Name</th>
						<th>buy</th>
						<th>sale</th>
						<th>total</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${top10users}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><c:out value="${arow.nickName}"/></td>
							<td><c:out value="${arow.buyAmount}" /></td>
							<td><c:out value="${arow.sellAmount}" /></td>
							<td><c:out value="${arow.totalAmount}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="./fragments/footer.jsp" />


