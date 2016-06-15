<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />

<title>所有用户</title>
<link href="css/top10users.css" rel="stylesheet">

<jsp:include page="./fragments/manageBodyHeader.jsp" />

<div class="row">
	
	<div class="col-xs-12 col-sm-9">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Nick Name</th>
						<th>buy</th>
						<th>sale</th>
						<th>total</th>
						<th>isEmailConfirmed</th>
						<th>isPhoneConfirmed</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${results}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><c:out value="${arow.email}"/></td>
							<td><c:out value="${arow.phone}"/></td>
							<td><c:out value="${arow.nickName}"/></td>
							<td><c:out value="${arow.buyAmount}" /></td>
							<td><c:out value="${arow.sellAmount}" /></td>
							<td><c:out value="${arow.totalAmount}" /></td>
							<td><c:out value="${arow.isEmailConfirmed}" /></td>
							<td><c:out value="${arow.isPhoneConfirmed}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="./fragments/footer.jsp" />


