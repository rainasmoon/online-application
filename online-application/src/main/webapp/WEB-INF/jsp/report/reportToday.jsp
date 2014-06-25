<%@page session="false" %>
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
			<form:form modelAttribute="searchReportVo" method="post"
					class="form-horizontal" id="search-report-today-form">
				<onlineapplication:selectField label=""
						name="application.id" id="selectApplication" names="${allApplications}" itemValue="id" itemLabel="applicationName" size="1" />
				<h2>今日数据</h2>
				<datatables:table id="reports" data="${selections}" cdn="true"
					row="report" theme="bootstrap3" cssClass="table table-striped"
					paginate="false" pageable="false" info="false" filterable="false" sortable="false"
					lengthChange="false">
					<datatables:column title="日期" property="dateString" />
					<datatables:column title="新增用户" property="newUsers" default="-"/>
					<datatables:column title="活跃用户" property="activeUsers" default="-"/>
					<datatables:column title="激活数" property="activation" default="-"/>
					<datatables:column title="激活收入" property="activationIncome" default="-"/>
					<datatables:column title="深度任务收入" property="taskIncome" default="-"/>
					<datatables:column title="推广收入" property="promoteIncome" default="-"/>
								
				</datatables:table>

				-表示该数据该项为隔日统计，当日数据请于明日查看
				</form:form>
			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 		$("#selectApplication").change(
 			function(){
 				$("#search-report-today-form").submit();
 			}
 		);
	</script>
</body>

</html>
