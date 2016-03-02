<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<jsp:include page="./fragments/headTag.jsp" />

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
	<div class="thumbnail">
		<img alt="" src="pic/tv.jpg">

	</div>
	<p class="lead">家自用，8成新，日本原装，古董。</p>
	<p>
	<div class="alert alert-info" role="alert">???</div>
	</p>

</div>

<div class="row marketing">
	<form class="form-inline">
		<div class="form-group">
			<label class="sr-only" for="exampleInputAmount">Amount (in
				dollars)</label>
			<div class="input-group">
				<div class="input-group-addon">$</div>
				<input type="text" class="form-control" id="exampleInputAmount"
					placeholder="给个价">
				<div class="input-group-addon">.00</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">拍</button>
	</form>
</div>

<jsp:include page="./fragments/footer.jsp" />


