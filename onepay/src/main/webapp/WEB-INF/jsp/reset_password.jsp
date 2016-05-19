<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>找回密码</title>
<link href="css/signin.css" rel="stylesheet" />

<jsp:include page="./fragments/bodyHeader.jsp" />

<ul>
  <li> 通过认证手机号 </li>
  <li> 通过认证邮箱 </li>
  <li> <a href="reset_password_application.html">申请找回密码</a> </li>
  
</ul>


<jsp:include page="./fragments/footer.jsp" />