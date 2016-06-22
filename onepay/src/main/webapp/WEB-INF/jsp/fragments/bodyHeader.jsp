<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>

<body>

	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
						
				</button>
				<a class="navbar-brand" href="welcome.html">一元网</a>
				<div class="visible-xs" style="align:middle;">
        	<a class="navbar-brand active" href="addproduct.html">上传货品</a>
   		</div>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="listproducts.html">“东西”汇</a></li>
<!-- 					<li><a href="top10users.html">Top 10 users</a></li> -->
					<c:if test="${not empty userId}">
<!-- 					<li><a href="myfavorites.html">我的收藏</a></li> -->
					<li><a href="mysales.html">我的出售</a></li>
					<li><a href="myorders.html">我的定单</a></li>
					</c:if>
					<li><a href="market.html">猿币兑换市场</a></li>
					<li><a href="addproduct.html">上传货品</a></li>
					<li><a href="help.html">帮助</a></li>
					<c:if test="${empty userId}">
						<li><a href="login.html">登录/注册</a></li>
					</c:if>
					<c:if test="${not empty userId}">
						<li><a href="viewme.html"><span class="glyphicon glyphicon-user" aria-hidden="true"></span><c:out value="${userShowName}" /></a></li>
						<li><a href="logout.html">退出</a></li>
					</c:if>
				</ul>
			</div>			
		</div>	
	</nav>
	
	<div class="container">
	
		