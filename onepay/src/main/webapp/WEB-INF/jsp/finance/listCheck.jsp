<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">

				<h2>汇款详单</h2>

				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>申请时间</th>
							<th>申请金额</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${arow.createdDate}" /></td>
								<td><c:out value="${arow.applyAmount}" /></td>
								<td><c:out value="${arow.status}" /></td>
								<td><a href="">*</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		
	</script>
</body>

</html>
