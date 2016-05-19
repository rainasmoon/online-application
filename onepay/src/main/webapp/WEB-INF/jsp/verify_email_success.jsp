<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="./fragments/headTag.jsp" />
<title>验证邮箱</title>

<jsp:include page="./fragments/bodyHeader.jsp" />


<span class="help-inline"> <c:if test="${not empty message}">
		<div id="message" class="alert alert-success" role="alert">${message}</div>
	</c:if>
</span>
<div class="well">
	<p>验证邮箱</p>
</div>
<a href="viewme.html" class="btn btn-primary btn-lg " role="button">返回</a>

<jsp:include page="./fragments/footer.jsp" />






