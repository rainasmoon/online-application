
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

				<h2>用户管理</h2>
				<datatables:table id="userTable" data="${selections}" cdn="true"
					row="auser" theme="bootstrap3" cssClass="table table-striped"
					paginate="false" pageable="false" info="false" filterable="false"
					sortable="false" lengthChange="false">

					<datatables:column title="账号" property="userName" />
					<datatables:column title="角色" property="userRole" />
					<datatables:column title="操作">
						<a href="users/${auser.id}/edit">修改</a>
						<a href="users/${auser.id}/delete">删除</a>
					</datatables:column>

				</datatables:table>

				<br /> <a href='<spring:url value="/users/new" htmlEscape="true"/>'>Add
					User</a>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			
		});
	</script>
</body>

</html>
