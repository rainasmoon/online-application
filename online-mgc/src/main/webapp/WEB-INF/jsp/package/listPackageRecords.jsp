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

				<h2>数据统计</h2>

				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>日期</th>
							<th>安装量</th>
							<th>激活量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.detailDate}" /></td>
								<td><c:out value="${arow.installations}" /></td>
								<td><c:out value="${arow.activations}" /></td>
								<td><a href="listDetails/${arow.id }/edit">修改</a> <a
									href="listDetails/${arow.id }/delete">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a
					href='<spring:url value="/packages/${mgcPackageId}/listDetails/new" htmlEscape="true"/>'>Add
					PackageDetails</a>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>

</body>

</html>
