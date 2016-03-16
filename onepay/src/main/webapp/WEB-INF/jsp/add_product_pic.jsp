<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<jsp:include page="./fragments/headTag.jsp" />
<title>添加图片</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form action="saveProductPic.html" method="post" class="form-horizontal" id="add-product-pic-form"
	enctype="multipart/form-data">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if>
	</span>
	<fieldset>
		<input type="hidden" name="productId" value="${productId }" />

		<div class="form-group">
			<label for="inputPicFile">图片</label> <input type="file"
				id="inputPicFile" name="inputPicFile">
			<p class="help-block">上传图片有助于客户更好的了解产品.</p>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</fieldset>
</form>

<jsp:include page="./fragments/footer.jsp" />


