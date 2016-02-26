<%@page session="false" %>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<jsp:include page="../fragments/headTag.jsp"/>

<body>
	<div class="container">

		<h2>Something happened...</h2>

		<p>${exception.message}</p>

		<!-- Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>
	  	-->



	</div>
</body>

</html>
