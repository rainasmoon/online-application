
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
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
				<c:url var="actionUrl" value="reportPast.html" />
				<form:form action="${actionUrl}" modelAttribute="searchReportVo"
					method="post" class="form-horizontal" id="search-past-form">
					<onlineapplication:selectField label="应用" id="selectApplication"
						name="application.id" names="${allApplications}" itemValue="id"
						itemLabel="applicationName" size="1" />
					<button id="lastWeek" type="button">过去一周</button>
					<button id="lastMonth" type="button">过去一月</button>
					<form:input path="dateFrom" size="10" placeholder="yyyy-mm-dd"
						maxLength="10" minLength="10" />
					<form:input path="dateTo" size="10" placeholder="yyyy-mm-dd"
						maxLength="10" minLength="10" />
					<button id="search" type="submit">Search</button>
				</form:form>

				<h2>分日数据</h2>
				<datatables:table id="reports" data="${selections}" cdn="true"
					row="report" theme="bootstrap3" cssClass="table table-striped"
					paginate="false" pageable="false" info="false" filterable="false"
					sortable="false" lengthChange="false">

					<datatables:column title="日期" property="dateString" />
					<datatables:column title="新增用户" property="newUsers" default="-"/>
					<datatables:column title="活跃用户" property="activeUsers" default="-"/>
					<datatables:column title="激活收入" property="activationIncome" default="-"/>
					<datatables:column title="深度任务收入" property="taskIncome" default="-"/>
					<datatables:column title="推广收入" property="promoteIncome" default="-"/>

				</datatables:table>

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
