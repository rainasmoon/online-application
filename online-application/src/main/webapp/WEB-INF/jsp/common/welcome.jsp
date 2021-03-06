<%@page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<!--[if lte IE 8]><spring:url value="/webjars/excanvas/3/excanvas.js" var="excanvas"/>
    <script src="${excanvas}"></script><![endif]-->
<spring:url value="/webjars/flot/0.8.3/jquery.flot.js" var="flot" />
<script src="${flot}"></script>

<spring:url value="/webjars/flot/0.8.3/jquery.flot.time.js" var="flotTime" />
<script src="${flotTime}"></script>

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
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
						<p class="text-right">
							<button id="lastWeek" class="btn btn-primary">最近一周</button>
							<button id="lastMonth" class="btn btn-primary">最近一月</button>
						</p>
						<div id="promotetrend" class="flot-chart-css"
							style="height: 300px;"></div>
					</div>
				</div>

			</div>

		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
	
		function rmbFormatter(v, axis) {
			return "¥" + v.toFixed(axis.tickDecimals);
		}
		
		function showChart(date) {
			var promotedUsersTrend = ${ welcomeVo.promotedUsersTrendArrayString };
			var promotedIncomeTrend = ${ welcomeVo.promotedIncomeTrendArrayString };
			
			$.plot("#promotetrend", [ {data: promotedUsersTrend, label:"推广量" },  {data:promotedIncomeTrend, label:"推广收入", yaxis: 2}], {
				xaxes: [ { 
					mode: "time",
					minTickSize: [1, "day"],
					min: date.getTime(),
					max: (new Date()).getTime(),
					timeformat: "%m-%d"				
				 } ],
				yaxes: [ { min: 0 }, {
					alignTicksWithAxis: 1,
					position: 1,
					tickFormatter: rmbFormatter
				} ],
				legend: { position: "ne" },				
				series: {
					lines: {
						show: true
					},
					points: {
						show: true
					}
				},
				grid: {
					hoverable: true,
					clickable: true
				}
			});
			
				
			$("<div id='tooltip'></div>").css({
				position: "absolute",
				display: "none",
				border: "1px solid #fdd",
				padding: "2px",
				"background-color": "#fee",
				opacity: 0.80
			}).appendTo("body");
	
			$("#promotetrend").bind("plothover", function (event, pos, item) {

					if (item) {
						var x = item.datapoint[0].toFixed(2),
							y = item.datapoint[1].toFixed(2);
	
						$("#tooltip").html(item.series.label + " : " + y)
							.css({top: item.pageY+5, left: item.pageX+5})
							.fadeIn(200);
					} else {
						$("#tooltip").hide();
					}
				
			});
		}
	
		$(function() {
						
			$("#lastWeek").click(function() {
				var currentTime = new Date();
				var month = currentTime.getMonth();
				var last_week_day = currentTime.getDate() - 7;
				var year = currentTime.getFullYear();
				var lastWeek = new Date(year, month, last_week_day);
				showChart(lastWeek);
			});
			$("#lastMonth").click(function() {
				var currentTime = new Date();
				var last_month = currentTime.getMonth() -1;
				var pre_day = currentTime.getDate() + 1;
				var year = currentTime.getFullYear();
				var lastMonth = new Date(year, last_month, pre_day);
				showChart(lastMonth);
			});
			
			$("#lastMonth").click();
			

		});
	</script>
</body>

</html>
