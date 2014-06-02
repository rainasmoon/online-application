<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<jsp:include page="fragments/headTag.jsp" />

<!--[if lte IE 8]><spring:url value="/webjars/excanvas/3/excanvas.js" var="excanvas"/>
    <script src="${excanvas}"></script><![endif]-->
<spring:url value="/webjars/flot/0.8.3/jquery.flot.js" var="flot" />
<script src="${flot}"></script>

<body>
	<jsp:include page="fragments/bodyHeader.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">
				<div class="page-header">
					<h1>
						<fmt:message key="welcome" />
					</h1>
				</div>
				<div class="banner">banner</div>
				<div class="row">
					<div class="col-md-4" style="height: 80px;">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">今日收入</h3>
							</div>
							<div class="panel-body">
								<div>
									$
									<c:out value="${ welcomeVo.todayIncome }" />
								</div>
								<div>
									推广量:
									<c:out value="${ welcomeVo.todayPromotedUsers }" />
									&nbsp;新增用户:
									<c:out value="${ welcomeVo.todayUsers }" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">昨日收入</h3>
							</div>
							<div class="panel-body">
								<div>
									$
									<c:out value="${ welcomeVo.yesterdayIncome }" />
								</div>
								<div>
									推广量:
									<c:out value="${ welcomeVo.yesterdayPromotedUsers }" />
									&nbsp;新增用户:
									<c:out value="${ welcomeVo.yesterdayUsers }" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">帐户余额</h3>
							</div>
							<div class="panel-body">
								<div>
									$
									<c:out value="${ welcomeVo.totalBanlance }" />
								</div>
								<div>我要提现</div>
							</div>
						</div>
					</div>
				</div>
				<br />
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">推广趋势</h3>
					</div>
					<div class="panel-body">
						<div id="promotetrend" class="flot-chart-css" style="height: 300px;"></div>
					</div>
				</div>
				
			</div>

		</div>
		<jsp:include page="fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
		$(function() {

			var d1 = [];
			for (var i = 0; i < 14; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}

			var d2 = [ [ 0, 3 ], [ 4, 8 ], [ 8, 5 ], [ 9, 13 ] ];

			// A null signifies separate line segments

			var d3 = [ [ 0, 12 ], [ 7, 12 ], null, [ 7, 2.5 ], [ 12, 2.5 ] ];

			$.plot("#promotetrend", [ d1, d2, d3 ]);

		});
	</script>
</body>

</html>
