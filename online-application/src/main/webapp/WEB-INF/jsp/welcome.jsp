<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="mainbody">
<div class="leftmenu"><jsp:include page="fragments/leftMenu.jsp"/></div>
<div class="container">
    
    <h2><fmt:message key="welcome"/></h2>
    

    

</div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>

</html>
