<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">


				<h2>全部应用</h2>

				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>DIANJOY_APP_ID</th>
							<th>创建时间</th>
							<th>应用名称</th>
							<th>应用平台</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><c:out value="${arow.dianjoyAppId}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.createdDate}" /></td>
								<td><c:out value="${arow.applicationName}" /></td>
								<td><c:out value="${arow.applicationPlatform}" /></td>
								<td><c:out value="${arow.status}" /></td>
								<td><a href="applications/${arow.id}/delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="alert alert-warning">测试用DIANJOY_APP_ID:TEST_DIANJOY_APP_ID可以测试流程,但不计费</div>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
