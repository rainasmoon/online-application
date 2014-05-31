
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
<jsp:include page="../fragments/bodyHeader.jsp"/>
<div class="mainbody">
<div class="leftmenu"><jsp:include page="../fragments/leftMenu.jsp"/></div>
<div class="container">

    <h2>
        创建应用
    </h2>
    <form:form modelAttribute="application" method="post" class="form-horizontal" id="add-application-form">
        <onlineapplication:inputField label="应用名称" name="applicationName"/>
        <onlineapplication:inputField label="应用平台" name="applicationPlatform"/>
        <onlineapplication:inputField label="应用包名" name="applicationPackageName"/>

        <div class="form-actions">

            <button type="submit">创建应用</button>

        </div>
    </form:form>
    

    

</div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
