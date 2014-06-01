
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

    <h2>
        注册用户
    </h2>
    <form:form modelAttribute="user" method="post" class="form-horizontal" id="add-user-form">
        <onlineapplication:inputField label="邮箱" name="email"/>
        <onlineapplication:inputField label="密码" name="password"/>
        <onlineapplication:inputField label="确认密码" name="confirmPassword"/>
        <onlineapplication:inputField label="ＱＱ" name="qq"/>
        <onlineapplication:inputField label="手机" name="mobile"/>
        <div class="form-actions">

            <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>

        </div>
    </form:form>
    

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
