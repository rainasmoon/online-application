<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<jsp:include page="./fragments/headTag.jsp" />
<link href="css/bid.css" rel="stylesheet">
<title>Narrow Jumbotron Template for Bootstrap</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

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


