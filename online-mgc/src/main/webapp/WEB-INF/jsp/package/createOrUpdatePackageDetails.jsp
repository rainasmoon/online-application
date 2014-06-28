
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

				<h2>每日数据</h2>

				<form:form modelAttribute="mgcPackageDetail" method="post"
					class="form-horizontal" id="change-package-form"
					>
					<span class="help-inline"> <c:if test="${not empty message}">
							<div id="message" class="alert alert-success">${message}</div>
						</c:if> <spring:bind path="error">
							<c:if test="${status.error}">
								<div id="message" class="error">${status.errorMessage}</div>
							</c:if>
						</spring:bind>
					</span>					
					<onlineapplication:inputField label="日期" name="detailDate" />
					<onlineapplication:inputField label="安装量" name="installations" />
					<onlineapplication:inputField label="激活量" name="activations" />

					<div class="form-actions">

						<button class="btn btn-lg btn-primary " type="submit">提交</button>
						<c:if test="${mgcPackageDetail['new']}"><a  class="btn btn-lg btn-primary "  href="../listDetails.html">返回</a> </c:if>
						

					</div>
				</form:form>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<spring:url
		value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js"
		var="jQueryUiDatePicker" />
	<script src="${jQueryUiDatePicker}"></script>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#installations').focus();
			$('#detailDate').datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
		
		
	</script>
</body>

</html>
