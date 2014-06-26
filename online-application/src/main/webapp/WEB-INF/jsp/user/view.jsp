<%@page session="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="onlineapplication" tagdir="/WEB-INF/tags"%>


<html lang="en">

<jsp:include page="../fragments/headTag.jsp" />

<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
				<jsp:include page="../fragments/leftMenu.jsp" /></div>
			<div class="col-xs-12 col-sm-9">

				<h2>
					基本信息/<a
						href="<spring:url value="/changePersonalInformation.html" htmlEscape="true" />">编辑资料信息</a>
				</h2>
				<table class="table table-striped" style="width: 600px;">
					<tr>
						<th>开发者性质</th>
						<td><b><c:out value="${user.contactType} " /></b></td>
					</tr>
					<tr>
						<th>联系人姓名</th>
						<td><b><c:out value="${user.contactName} " /></b></td>
					</tr>
					<tr>
						<th>QQ</th>
						<td><c:out value="${user.qq}" /></td>
					</tr>
					<tr>
						<th>手机号码</th>
						<td><c:out value="${user.mobile}" /></td>
					</tr>
					<tr>
						<th>身份证号码</th>
						<td><b><c:out value="${user.contactIdNumber} " /></b></td>
					</tr>
					<tr>
						<th>开户行</th>
						<td><b><c:out value="${user.bankName} " /></b></td>
					</tr>
					<tr>
						<th>开户行所在省</th>
						<td><b><c:out value="${user.province.dictionaryValue} " /></b></td>
					</tr>
					<tr>
						<th>开户行所在市</th>
						<td><b><c:out value="${user.city.dictionaryValue} " /></b></td>
					</tr>
					<tr>
						<th>具体支行</th>
						<td><b><c:out value="${user.branchName} " /></b></td>
					</tr>
					<tr>
						<th>银行卡号</th>
						<td><b><c:out value="${user.accountNumber} " /></b></td>
					</tr>
					<tr>
						<th>身份证扫描件正面</th>
						<td><b> <spring:url value="/idcard/${user.id}/front"
									htmlEscape="true" var="frontImage" /> <img src="${frontImage}" class="img-thumbnail"/>
						</b></td>
					</tr>
					<tr>
						<th>身份证扫描件反面</th>
						<td><b><spring:url value="/idcard/${user.id}/back"
									htmlEscape="true" var="backImage" /> <img src="${backImage}" class="img-thumbnail"/>
						</b></td>
					</tr>
				</table>



			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
</body>

</html>
