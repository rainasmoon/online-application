<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>Signin Template for Bootstrap</title>
<link href="css/signin.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<form class="form-signin">
	<h2 class="form-signin-heading">Please sign in</h2>
	<label for="inputEmail" class="sr-only">手机号|邮箱</label> <input
		type="email" id="inputEmail" class="form-control" placeholder="手机号|邮箱"
		required autofocus> <label for="inputPassword" class="sr-only">Password</label>
	<input type="password" id="inputPassword" class="form-control"
		placeholder="Password" required>
	<div class="checkbox">
		<label> <input type="checkbox" value="remember-me">
			Remember me
		</label>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">登录|注册</button>
</form>

<jsp:include page="./fragments/footer.jsp" />

