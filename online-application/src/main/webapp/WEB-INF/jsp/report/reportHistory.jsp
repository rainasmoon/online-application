
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
				<datatables:table id="reports" data="${selections}" cdn="true"
					row="report" theme="bootstrap2" cssClass="table table-striped"
					paginate="false" pageable="false" info="false" filterable="false" sortable="false"
					lengthChange="false">

					<datatables:column title="日期" property="dateString" />
					<datatables:column title="新增用户" property="newUsers" />
					<datatables:column title="活跃用户" property="activeUsers" />					
					<datatables:column title="激活收入" property="actvationIncome" />
					<datatables:column title="深度任务收入" property="taskIncome" />
					<datatables:column title="推广收入" property="promoteIncome" />
								
				</datatables:table>

				-表示该数据该项为隔日统计，当日数据请于明日查看
			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#oldPassword').focus();
		});
	</script>
</body>

</html>
