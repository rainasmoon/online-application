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

				<h2>用户管理</h2>

				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>账号</th>
							<th>角色</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><c:out value="${arow.userName}" /></td>
								<td><c:out value="${arow.userRole}" /></td>
								<td><a href="users/${arow.id}/edit">修改</a> <a
									href="users/${arow.id}/delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href='<spring:url value="/users/new" htmlEscape="true"/>'>Add
					User</a>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		$(function() {

		});
	</script>
</body>

</html>
