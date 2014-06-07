
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
						<th>开发者性质</th>
						<td><b><c:out value="${check.contactName} " /></b></td>
					</tr>

				</table>
				<div class="form-actions">

						<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
						<button class="btn btn-lg btn-primary btn-block" type="button">修改个人信息</button>

					</div>
				</form:form>
				<div>
				结算说明
				1.账户余额满100元即可申请取款。
2.每周三12点前申请取款，每周五进行汇款，如遇节假日顺延。
3.确认取款提交成功后3个工作日内将相应款项汇入登记帐户。
4.如果收款方为个人账户，汇款时将代扣0.5%的汇款手续费和5.5%的营业税。如果收款方为
对公账户，需要在汇款之前开具相应金额的发票，免扣税及手续费。
5.开发者应承担的税款(5.5%)和汇款手续费(0.5%)全部由联盟工场平台承担。
申请汇款
				</div>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#oldPassword').focus();
		});
	</script>
</body>

</html>
