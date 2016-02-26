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

				<h2>下载SDK</h2>
				
				<table id="tableDatas" class="table table-stripped">
					<thead>
						<tr>
							<th>平台</th>
							<th>类型</th>
							<th>版本</th>
							<th>下载</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach var="arow" items="${selections}">
							<tr>
								<td><c:out value="${arow.platform}" /></td>								
								<td><c:out value="${arow.sdkType}" /></td>
								<td><c:out value="${arow.version}" /></td>
								<td><a href="download/1"><c:out value="${arow.downloadName }"></c:out></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

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
