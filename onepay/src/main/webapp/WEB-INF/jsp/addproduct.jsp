<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>添加个东西</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form:form modelAttribute="product" method="post"
	class="form-horizontal" id="add-product-form"
	enctype="multipart/form-data">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="alert alert-success" role="alert">${message}</div>
		</c:if> <spring:bind path="*">
			<c:if test="${status.error}">
				<div id="error" class="alert alert-danger" role="alert">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>
	<fieldset>
		<onepayapp:inputField label="商品名称" name="ProductName"
			autofocus="true" required="true" />

		<div class="control-group">
			<label for="inputPicFile"  class="control-label">图片</label> <input type="file"
				id="inputPicFile" name="inputPicFile" accept="image/*" />
			<p class="help-block">上传图片有助于客户更好的了解产品.</p>
		</div>
		<hr />
		<label class="radio-inline"> <input type="radio"
			name="saleModel" id="saleModel1" value="three_times" checked/> 一元拍
		</label> <label class="radio-inline"> <input type="radio"
			name="saleModel" id="saleModel2" value="three_days" /> 3天拍
		</label> <label class="radio-inline"> <input type="radio"
			name="saleModel" id="saleModel3" value="guess_price" /> 猜假拍
		</label>		
		<div>
			<onepayapp:inputField label="底价" name="price" type="number" value="1"/>
		</div>
		<hr />
		<div >
			<label for=inputAging>新旧程度</label> <label class="radio-inline">
				<input type="radio" name="aging" value="1" />1
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="2" />2
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="3" />3
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="4" />4
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="5" />5
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="6" />6
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="7" />7
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="8" />8
			</label>
			<label class="radio-inline">
				<input type="radio" name="aging" value="9" />9
			</label><label class="radio-inline">
				<input type="radio" name="aging" value="10" />10
			</label>
		</div>
		<div>
			<label for="inputDescription">描述</label>
			<textarea id="description" name="description" class="form-control"
				rows="3"></textarea>
		</div>
		<div>
			<label for="inputTags">标签</label>
			<div id="tags_session" class="checkbox"></div>
			<input type="text" class="form-control" id="inputNewTag"
				placeholder="新标签">
			<button type="button" class="btn btn-default" onclick="addNewTag()">添加</button>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> 同意一元网的条款
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</fieldset>
</form:form>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="js/addproduct.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


