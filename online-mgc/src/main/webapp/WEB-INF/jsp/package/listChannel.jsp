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
				<c:url var="actionUrl" value="channels.html" />
				<form:form action="${actionUrl}" modelAttribute="searchMgcPackageVo"
					method="post" class="form-inline" id="search-mgcpackage-form">
					<onlineapplication:selectField label="推广包" name="mgcPackage.id"
						names="${allMgcPackages}" itemValue="id" itemLabel="packageName"
						size="1" />
					<onlineapplication:selectField label="产品" name="mgcProduct"
						names="${productionTypes}" size="1" />
					从<form:input path="dateFrom" class="form-control" size="10"
						placeholder="yyyy-mm-dd" maxLength="10" minLength="10" />
					到<form:input path="dateTo" class="form-control" size="10"
						placeholder="yyyy-mm-dd" maxLength="10" minLength="10" />
					<button id="search" class="btn btn-primary" type="submit">Search</button>
				</form:form>
				<datatables:table id="mgcPackageTable" data="${selections}"
					cdn="true" row="mgcPackageDetail" theme="bootstrap3"
					cssClass="table table-striped" paginate="false" pageable="false"
					info="false" filterable="false" sortable="false"
					lengthChange="false">

					<datatables:column title="日期">
						<fmt:formatDate pattern="yyyy-MM-dd"
							value="${mgcPackageDetail.detailDate}" />
					</datatables:column>
					<datatables:column title="推广包" property="mgcPackage.packageName" />
					<datatables:column title="产品名" property="mgcPackage.productionName" />
					<datatables:column title="安装量" property="installations" />
					<datatables:column title="激活量" property="activations" />

				</datatables:table>
				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>日期</th>
							<th>推广包</th>
							<th>产品名</th>
							<th>安装量</th>
							<th>激活量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>

								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.detailDate}" /></td>
								<td><c:out value="${arow.mgcPackage.packageName}" /></td>
								<td><c:out value="${arow.mgcPackage.productionName}" /></td>
								<td><c:out value="${arow.installations}" /></td>
								<td><c:out value="${arow.activations}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

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
		});
	</script>
</body>

</html>
