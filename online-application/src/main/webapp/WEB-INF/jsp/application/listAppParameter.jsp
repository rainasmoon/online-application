
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container" >
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">


				<h2>自定义参数</h2>

				<datatables:table id="appParameters" data="${selections}" cdn="true"
					row="appParameter" theme="bootstrap2" cssClass="table table-striped"
					paginate="false" pageable="false" info="false" filterable="false" sortable="false"
					lengthChange="false">

					<datatables:column title="DIANJOY_APP_ID" property="application.dianjoyAppId" />
					<datatables:column title="创建时间">
						<fmt:formatDate pattern="yyyy-MM-dd"
							value="${appParameter.createdDate}" />
					</datatables:column>
					<datatables:column title="应用名称" property="application.applicationName" />
					<datatables:column title="应用平台" property="application.applicationPlatform" />
					<datatables:column title="参数名" property="paramName" />
					<datatables:column title="参数值" property="paramValue" />
					<datatables:column title="操作">
						<a href="parameters/${appParameter.id}/delete">删除</a>
					</datatables:column>
				</datatables:table>
				
				<div class="alert alert-warning">测试用DIANJOY_APP_ID:TEST_DIANJOY_APP_ID可以测试流程,但不计费</div>
				

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
