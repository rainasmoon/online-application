<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>市场 - 查看交易</title>
<link href="css/listproduct.css" rel="stylesheet">

<jsp:include page="./fragments/bodyHeader.jsp" />

<h1>查看</h1>
请收到对方款项后，再给对方解冻码。
解冻码为：<c:out value="${freezeCode }"></c:out>
<button class="btn btn-primary" type="button" onclick="goBack()">返回</button>
<script src="js/market.js" type="text/javascript"></script>
<jsp:include page="./fragments/footer.jsp" />




