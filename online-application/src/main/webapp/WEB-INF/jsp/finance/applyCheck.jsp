<%@page session="false"%>
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

				<h2>申请汇款</h2>
				<form:form modelAttribute="check" method="post"
					class="form-horizontal" id="add-application-form">
					<table class="table table-striped" style="width: 600px;">
						<tr>
							<td colspan="2"><span class="help-inline">&nbsp; <c:if
										test="${not empty message}">
										<div id="message" class="success">${message}</div>
									</c:if> <spring:bind path="error">
										<c:if test="${status.error}">
											<div id="message" class="error">${status.errorMessage}</div>
										</c:if>
									</spring:bind>
							</span></td>
						</tr>
						<tr>
							<th>姓名</th>
							<td><b><c:out value="${check.contactName} " /></b></td>
						</tr>
						<tr>
							<th>身份证号</th>
							<td><b><c:out value="${check.contactIdNumber} " /></b></td>
						</tr>
						<tr>
							<th>开户行</th>
							<td><b><c:out value="${check.bankName} " /></b></td>
						</tr>
						<tr>
							<th>开户行地址</th>
							<td><b><c:out value="${check.bankAddress} " /></b></td>
						</tr>
						<tr>
							<th>银行卡号</th>
							<td><b><c:out value="${check.accountNumber} " /></b></td>
						</tr>
						<tr>
							<th>未提现余额</th>
							<td><b><c:out value="${check.remainder} " /></b></td>
						</tr>
						<tr>
							<td colspan="2"><b><onlineapplication:inputField
										label="提现" name="applyAmount" />元</b>
								请仔细核对以上信息，最少提现为100元，最多提现为${check.remainder}元。</td>
						</tr>

					</table>
					<div class="row">
						<div class="col-md-6">
							<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
						</div>
						<div class="col-md-6">
							<a class="btn btn-lg btn-primary btn-block"
								href="<spring:url value="/changePersonalInformation.html" htmlEscape="true" />">
								修改个人信息</a>
						</div>
					</div>
				</form:form>
				<br/>
				<div class="well">
					<h3>结算说明</h3>
					<p>1.账户余额满100元即可申请取款。</p>
					<p>2.每周三12点前申请取款，每周五进行汇款，如遇节假日顺延。</p>
					<p>3.确认取款提交成功后3个工作日内将相应款项汇入登记帐户。</p>
					<p>4.如果收款方为个人账户，汇款时将代扣0.5%的汇款手续费和5.5%的营业税。如果收款方为
						对公账户，需要在汇款之前开具相应金额的发票，免扣税及手续费。</p>
					<p>5.开发者应承担的税款(5.5%)和汇款手续费(0.5%)全部由联盟工场平台承担。 申请汇款</p>
				</div>
			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript"> 
		$(function() {
			$('input, textarea').placeholder();
			$('#applyAmount').focus();
		});
	</script>
</body>

</html>
