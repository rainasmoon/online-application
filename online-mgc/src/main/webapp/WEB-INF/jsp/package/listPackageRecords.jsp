
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
				
				<h2>数据统计</h2>
				<datatables:table id="mgcPackageTable" data="${selections}"
					cdn="true" row="mgcPackageDetail" theme="bootstrap3"
					cssClass="table table-striped" paginate="false" pageable="false"
					info="false" filterable="false" sortable="false"
					lengthChange="false">

					<datatables:column title="日期">
						<fmt:formatDate pattern="yyyy-MM-dd"
							value="${mgcPackageDetail.detailDate}" />
					</datatables:column>
					<datatables:column title="安装量" property="installations" />
					<datatables:column title="激活量" property="activations" />
					<datatables:column title="操作">
						<a href="listDetails/${mgcPackageDetail.id }/edit">修改</a>
						<a href="listDetails/${mgcPackageDetail.id }/delete">删除</a>
					</datatables:column>

				</datatables:table>

				<br /> <a href='<spring:url value="/packages/${mgcPackageId}/listDetails/new" htmlEscape="true"/>'>Add
					PackageDetails</a>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	
</body>

</html>
