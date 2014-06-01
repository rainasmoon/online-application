
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>

	<div class="container">

		<h2>基本信息</h2>
		<table class="table table-striped" style="width: 600px;">
			<tr>
				<th>邮箱</th>
				<td><b><c:out value="${user.email} " /></b></td>
			</tr>
			<tr>
				<th>qq</th>
				<td><c:out value="${user.qq}" /></td>
			</tr>
			<tr>
				<th>mobile</th>
				<td><c:out value="${user.mobile}" /></td>
			</tr>
		</table>



	</div>
	<jsp:include page="../fragments/footer.jsp" />
</body>

</html>
