<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />

<title>所有反馈</title>
<link href="css/top10users.css" rel="stylesheet">

<jsp:include page="./fragments/manageBodyHeader.jsp" />

<div class="row">
	
	<div >
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>userId</th>
						<th>name</th>
						<th>content</th>
						<th>email</th>
						<th>phone</th>						
						<th>ip_address</th>
						<th>user_agent</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="arow" items="${results}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}"/></td>
							<td><c:out value="${arow.userId}"/></td>
							<td><c:out value="${arow.name}"/></td>
							<td><c:out value="${arow.content}"/></td>
							<td><c:out value="${arow.email}" /></td>
							<td><c:out value="${arow.phone}" /></td>			
							<td><c:out value="${arow.ip}" /></td>
							<td><c:out value="${arow.agent}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="./fragments/footer.jsp" />


