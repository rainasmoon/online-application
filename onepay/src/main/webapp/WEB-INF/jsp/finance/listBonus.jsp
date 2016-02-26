<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">

				<h2>奖励统计</h2>
				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>授奖日期</th>
							<th>授奖内容</th>
							<th>授奖原因</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>								
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.createdDate}" /></td>
								<td><c:out value="${arow.amount}" /></td>
								<td><c:out value="${arow.reason}" /></td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		
	</script>
</body>

</html>
