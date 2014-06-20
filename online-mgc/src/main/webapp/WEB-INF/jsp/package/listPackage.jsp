
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>


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
				<datatables:table id="mgcPackageTable" data="${selections}"
					cdn="true" row="mgcPackage" theme="bootstrap3"
					cssClass="table table-striped" paginate="false" pageable="false"
					info="false" filterable="false" sortable="false"
					lengthChange="false">

					<datatables:column title="日期">
						<fmt:formatDate pattern="yyyy-MM-dd"
							value="${mgcPackage.createdDate}" />
					</datatables:column>
					<datatables:column title="推广包" property="packageName" />
					<datatables:column title="产品名" property="productionName" />
					<datatables:column title="操作">
						<a href="packages/${mgcPackage.id}/listDetails.html">查看明细</a>
						<a href="packages/${mgcPackage.id}/edit.html">修改</a>
						<a href="packages/${mgcPackage.id}/delete.html">删除</a>
					</datatables:column>

				</datatables:table>

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
