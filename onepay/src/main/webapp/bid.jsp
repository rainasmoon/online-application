<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="favicon.ico">

<title>Narrow Jumbotron Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/main.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<jsp:include page="./fragments/bodyHeader.jsp" />
	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="#">About</a></li>
					<li role="presentation"><a href="#">Contact</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">Project name</h3>
		</div>

		<div class="jumbotron">
			<h1>二手书一本</h1>
			<p>竞拍人数：5。。。当前属于：acrazyguy</p>
			<div class="thumbnail">
				<img alt="" src="pic/tv.jpg">

			</div>
			<p class="lead">家自用，8成新，日本原装，古董。</p>
			<p>
			<div class="alert alert-info" role="alert">100</div>
			</p>

		</div>

		<div class="row marketing">
			<div class="col-lg-4">
				<a href="#" class="btn btn-primary btn-lg btn-block" role="button">+1</a>
			</div>

			<div class="col-lg-4">
				<a href="#" class="btn btn-primary btn-lg btn-block" role="button">+10</a>
			</div>
			<div class="col-lg-4">
				<a href="#" class="btn btn-primary btn-lg btn-block" role="button">+100</a>
			</div>
		</div>

				<jsp:include page="./fragments/footer.jsp" />

	</div>
	<!-- /.container -->
</body>
</html>
