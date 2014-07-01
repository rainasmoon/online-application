<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">
				<c:url var="actionUrl" value="packages.html" />

				<h2>全部Package</h2>
				
				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>日期</th>
							<th>推广包</th>
							<th>产品名</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.createdDate}" /></td>
								<td><c:out value="${arow.packageName}" /></td>
								<td><c:out value="${arow.productionName}" /></td>
								<td><a href="packages/${arow.id}/listDetails.html">查看明细</a>
									<a href="packages/${arow.id}/edit.html">修改</a> <a
									href="packages/${arow.id}/delete.html">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a
					href='<spring:url value="/packages/new" htmlEscape="true"/>'>Add
					Package</a>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<spring:url
		value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js"
		var="jQueryUiDatePicker" />
	<script src="${jQueryUiDatePicker}"></script>
	<script type="text/javascript">
		$(function() {

		});
	</script>
</body>

</html>
