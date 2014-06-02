
<%@ page language="java" pageEncoding="UTF-8"%> 

<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>

<div class="container">

    <h2 class="form-signin-heading">
        登录
    </h2>
    <form:form modelAttribute="loginVo" method="post" class="form-signin" id="login-form">
        <onlineapplication:inputField label="邮箱" name="email"/>
        <onlineapplication:passwordField label="密码" name="password"/>
        <onlineapplication:inputField label="验证码" name="checkCode"/>
        <img id="jcaptchaImg" src="<spring:url value="/jcaptcha.jpg" htmlEscape="true" />" />
        <a href="javascript:refreshJcaptchaImg()">看不清？</a>
        <div class="form-actions">
			
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>

        </div>
    </form:form>
    
    <div><a href="<spring:url value="/register.html" htmlEscape="true" />"> 注册</a></div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
<script type="text/javascript">
	function refreshJcaptchaImg() {
		d = new Date();
		$("#jcaptchaImg").attr("src", "./jcaptcha.jpg?"+d.getTime());
	}
</script>
</body>

</html>
