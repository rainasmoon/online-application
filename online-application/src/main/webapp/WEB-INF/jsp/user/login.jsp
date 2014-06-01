
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
        <onlineapplication:inputField label="密码" name="password"/>
        <onlineapplication:inputField label="验证码" name="checkCode"/>
        <div class="form-actions">
			
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>

        </div>
    </form:form>
    
    <div><a href="<spring:url value="/register.html" htmlEscape="true" />"> 注册</a></div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
