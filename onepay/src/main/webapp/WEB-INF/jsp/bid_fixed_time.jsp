<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>竞价</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<div class="jumbotron">
	<h1><c:out value="${productVo.productTitle}" /></h1>
	<p>竞拍人数：5。。。当前属于：acrazyguy...结束时间：2016-3-13 12：00：00</p>
	<div class="thumbnail">
		<img alt="" src="product_pic/${productVo.picPath }" width="300" height="300">

	</div>
	<p class="lead">家自用，8成新，日本原装，古董。</p>
	<p>
	<div id="productPrice" class="alert alert-info" role="alert"><c:out value="${productVo.price}" /></div>
	</p>

</div>

<div class="row marketing">
	<div class="col-lg-4">
		<a href="javascript:addMoney(1);" class="btn btn-primary btn-lg btn-block" role="button">+1</a>
	</div>

	<div class="col-lg-4">
		<a href="javascript:addMoney(10);" class="btn btn-primary btn-lg btn-block" role="button">+10</a>
	</div>
	<div class="col-lg-4">
		<a href="javascript:addMoney(100);" class="btn btn-primary btn-lg btn-block" role="button">+100</a>
	</div>
</div>
<script type="text/javascript">

function addMoney(amount){
	  $.post("bid",
	  {
	    money:amount	    
	  },
	  function(data,status){
	    $("#productPrice").text(data);
	  });
	}

</script>
<jsp:include page="./fragments/footer.jsp" />


