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
				<h2>今日数据</h2>
				<form:form modelAttribute="searchReportVo" method="post"
					class="form-inline" id="search-report-today-form">
					<onlineapplication:selectField label="" name="application.id"
						id="selectApplication" names="${allApplications}" itemValue="id"
						itemLabel="applicationName" size="1" />

					<table id="tableDatas" class="table table-stripped">
						<thead>
							<tr>
								<th>日期</th>
								<th>新增用户</th>
								<th>活跃用户</th>
								<th>激活数</th>
								<th>激活收入</th>
								<th>深度任务收入</th>
								<th>推广收入</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="arow" items="${selections}">
								<tr>
									<td><c:out value="${arow.dateString}" /></td>
									<td><c:out value="${arow.newUsers}" /></td>
									<td><c:out value="${arow.activeUsers}" /></td>
									<td><c:out value="${arow.activation}" /></td>
									<td><c:out value="${arow.activationIncome}" /></td>
									<td><c:out value="${arow.taskIncome}" /></td>
									<td><c:out value="${arow.promoteIncome}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				-表示该数据该项为隔日统计，当日数据请于明日查看
				</form:form>
			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		$("#selectApplication").change(function() {
			$("#search-report-today-form").submit();
		});
	</script>
</body>

</html>
