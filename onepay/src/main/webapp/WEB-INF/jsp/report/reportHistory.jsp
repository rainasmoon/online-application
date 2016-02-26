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
				<h2>分日数据</h2>
				<c:url var="actionUrl" value="reportPast.html" />
				<form:form action="${actionUrl}" modelAttribute="searchReportVo"
					method="post" class="form-inline" id="search-past-form">
					<onlineapplication:selectField label="应用" id="selectApplication"
						name="application.id" names="${allApplications}" itemValue="id"
						itemLabel="applicationName" size="1" />
					<button id="lastWeek" class="btn btn-primary" type="button">过去一周</button>
					<button id="lastMonth" class="btn btn-primary" type="button">过去一月</button>
					从<form:input path="dateFrom" class="form-control" size="10"
						placeholder="yyyy-mm-dd" maxLength="10" minLength="10" />
					到
					<form:input path="dateTo" class="form-control" size="10"
						placeholder="yyyy-mm-dd" maxLength="10" minLength="10" />
					<button id="search" class="btn btn-primary" type="submit">Search</button>
				</form:form>
				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>日期</th>
							<th>新增用户</th>
							<th>活跃用户</th>
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
								<td><c:out value="${arow.activationIncome}" /></td>
								<td><c:out value="${arow.taskIncome}" /></td>
								<td><c:out value="${arow.promoteIncome}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				-表示该数据该项为隔日统计，当日数据请于明日查看

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
			$('input, textarea').placeholder();
			$('#dateFrom').datepicker({
				dateFormat : 'yy-mm-dd'
			});
			$('#dateTo').datepicker({
				dateFormat : 'yy-mm-dd'
			});
			$("#lastWeek").click(function() {
				var currentTime = new Date();
				var month = currentTime.getMonth() + 1;
				var day = currentTime.getDate();
				var last_week_day = currentTime.getDate() - 7;
				var year = currentTime.getFullYear();
				var lastWeek = year + "-" + month + "-" + last_week_day;
				var today = year + "-" + month + "-" + day;
				$('#dateFrom').val(lastWeek);
				$("#dateTo").val(today);
			});
			$("#lastMonth").click(function() {
				var currentTime = new Date();
				var month = currentTime.getMonth() + 1;
				var last_month = currentTime.getMonth();
				var day = currentTime.getDate();
				var year = currentTime.getFullYear();
				var lastMonth = year + "-" + last_month + "-" + day;
				var today = year + "-" + month + "-" + day;
				$('#dateFrom').val(lastMonth);
				$("#dateTo").val(today);
			});
		});
	</script>
</body>

</html>
