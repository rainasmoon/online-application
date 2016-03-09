<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>添加个东西</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<form:form modelAttribute="product" method="post" class="form-horizontal"
	id="add-product-form" enctype="multipart/form-data">
	<span class="help-inline"> <c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>
		</c:if> <spring:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="error">${status.errorMessage}</div>
			</c:if>
		</spring:bind>
	</span>
	<fieldset>		
		<onlineapplication:inputField label="商品名称" name="ProductName" autofocus="true"/>

		<div class="form-group">
			<label for="inputPicFile">图片</label> <input type="file"
				id="inputPicFile">
			<p class="help-block">上传图片有助于客户更好的了解产品.</p>
		</div>
		<hr />
		<onlineapplication:radioButtonsField label="拍卖类型"
							name="saleType" names="${saleTypes}" />
		
		<hr />
		<div class="form-group">
			<label for=inputAging>新旧程度</label>
			<div aria-label="Toolbar with button groups" role="toolbar"
				class="btn-toolbar">
				<div aria-label="First group" role="group" class="btn-group">
					<button class="btn btn-default" type="button">1</button>
					<button class="btn btn-default" type="button">2</button>
					<button class="btn btn-default" type="button">3</button>
					<button class="btn btn-default" type="button">4</button>
					<button class="btn btn-default" type="button">5</button>
					<button class="btn btn-default" type="button">6</button>
					<button class="btn btn-default" type="button">7</button>
					<button class="btn btn-default" type="button">8</button>
					<button class="btn btn-default" type="button">9</button>
					<button class="btn btn-default" type="button">10</button>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="inputDescription">描述</label>
			<textarea class="form-control" rows="3"></textarea>
		</div>
		<div class="form-group">
			<label for="inputTags">标签</label> <span class="label label-info">电器</span>
			<span class="label label-info">全新</span> <span
				class="label label-info">未拆封</span> <input type="text"
				class="form-control" id="inputNewTag" placeholder="新标签">
			<button type="submit" class="btn btn-default">添加</button>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> 同意一元网的条款
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</fieldset>
</form:form>

<jsp:include page="./fragments/footer.jsp" />

