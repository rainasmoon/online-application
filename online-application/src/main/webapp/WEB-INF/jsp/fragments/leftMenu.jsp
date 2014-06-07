<%@ page language="java" pageEncoding="UTF-8"%> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div  class="list-group" >

            <a class="list-group-item active" href="#">
               　应用管理</a>
               <a class="list-group-item" href="<spring:url value="/applications/new.html" htmlEscape="true" />">
               　创建应用</a>
               <a class="list-group-item" href="<spring:url value="/applications.html" htmlEscape="true" />">
               　全部应用</a>
               <a class="list-group-item" href="<spring:url value="/applications/parameters.html" htmlEscape="true" />">
               　自定义参数</a>
               <a class="list-group-item active" href="#">
               　数据报表</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　实时统计</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　分日统计</a>
               <a class="list-group-item active" href="#">
               　财务管理</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　申请汇款</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　汇款详单</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　奖励统计</a>
               <a class="list-group-item" href="<spring:url value="/" htmlEscape="true" />">
               　个人收入速查</a>

</div>
	
