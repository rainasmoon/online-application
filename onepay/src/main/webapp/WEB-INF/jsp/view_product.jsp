<%@page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onepayapp" tagdir="/WEB-INF/tags"%>

<jsp:include page="./fragments/headTag.jsp" />
<title>用户信息</title>

<jsp:include page="./fragments/bodyHeader.jsp" />

<h2 class="sub-header">商品详情</h2>
<div class="table-responsive">
	<table class="table table-striped">
		<tbody>
			<tr>
				<td>产品名</td>
				<td><c:out value="${product.name}" /></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><div id="listPics">
						<c:forEach var="arow" items="${productPics}">
							<img src="product_pic/${arow.picPath }" width="80" height="80"
								class="img-thumbnail">
						</c:forEach>
					</div>
					<div id="uploadPic">
						| <a href="add_product_pic.html?productId=${product.id }">upload </a>
					</div></td>
			</tr>
			<tr>
				<td>拍卖类型</td>
				<td><c:out value="${product.saleModel}" /></td>
			</tr>
			<tr>
				<td>新旧程度</td>
				<td><c:out value="${product.aging}" /></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><div id="modifyDescription">
						<c:out value="${product.description}" />
						| <a href="javascript:modifyDescription('${product.id}')">编辑</a>
					</div></td>
			</tr>
			
			<tr>
				<td>标签</td>
				<td><div id="listTags">
						<c:forEach var="arow" items="${productTags}">
							<label class="label label-info"><c:out
									value="${arow.name}" /></label>
						</c:forEach>
					</div>
					<div id="addTag">
						| <a href="javascript:addTag('${product.id}')">add </a>
					</div></td>
			</tr>

		</tbody>
	</table>
</div>

<script src="js/view_product.js" type="text/javascript"></script>

<jsp:include page="./fragments/footer.jsp" />


