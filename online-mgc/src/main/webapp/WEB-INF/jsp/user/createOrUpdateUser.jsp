
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

				<h2>编辑资料信息</h2>

				<form:form modelAttribute="user" method="post"
					class="form-horizontal" id="change-user-form"
					enctype="multipart/form-data">
					<span class="help-inline"> <c:if test="${not empty message}">
							<div id="message" class="success">${message}</div>
						</c:if> <spring:bind path="*">
							<c:if test="${status.error}">
								<div id="message" class="error">${status.errorMessage}</div>
							</c:if>
						</spring:bind>
					</span>
					<onlineapplication:radioButtonsField label="开发者性质"
						name="contactType" names="${contactTypes}" />
					<onlineapplication:inputField label="联系人姓名" name="contactName" />
					<onlineapplication:inputField label="QQ" name="qq" />
					<onlineapplication:inputField label="手机号码" name="mobile" />
					<onlineapplication:inputField label="身份证号码" name="contactIdNumber" />
					<onlineapplication:inputField label="开户行" name="bankName" />
					<div class="alert alert-info">注意：点乐目前不支持邮政银行，请选择其它银行</div>
					<onlineapplication:selectField id="selectProvince" label="开户行所在省"
						name="province.id" names="${provinceTypes}" itemValue="id"
						itemLabel="dictionaryValue" size="1" />
					<onlineapplication:selectField id="selectCity" label="开户行所在市"
						name="city.id" names="${cityTypes}" itemValue="id"
						itemLabel="dictionaryValue" size="1" />
					<onlineapplication:inputField label="具体支行" name="branchName" />
					<onlineapplication:inputField label="银行卡号" name="accountNumber" />

					<label>身份证扫描件正面</label>
					<input id="fileIdCardFront" type="file" name="fileIdCardFront" />
					<label>身份证扫描件反面</label>
					<input id="fileIdCardBack" type="file" name="fileIdCardBack" />

					<div class="form-actions">

						<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>

					</div>
				</form:form>


			</div>
		</div>
		<jsp:include page="../fragments/footer.jsp" />
	</div>
	<script type="text/javascript">
 
		$(function() {
			$('input, textarea').placeholder();
			$('#contactTypes').focus();
			var cityTypes=new Array();
			<c:forEach items="${cityTypes}" var="cityType">
				var c = {id:'${cityType.id}', dictionaryKey:'${cityType.dictionaryKey}', dictionaryValue:'${cityType.dictionaryValue}'};
				//console.log("id" + c.id + "dictionaryKey:" + c.dictionaryKey +"value:" +c.dictionaryValue);
				cityTypes.push(c);
			</c:forEach>
			var selectedProvinceValue = $("#selectProvince :selected").val();													                 	
			filterDocumentTypes(selectedProvinceValue, cityTypes);
			$("#selectProvince").change(function() {
					var selectedProvinceValue = $("#selectProvince :selected").val();													                 	
					filterDocumentTypes(selectedProvinceValue, cityTypes);			
			});
		});
		
		function filterDocumentTypes(selectedProvinceValue, cityTypes) {
			$('select[id=selectCity]').html('');

			$.each(cityTypes, function (index, cityType) {
				//console.log("select:" +selectedProvinceValue+ "cityType:" + cityType.dictionaryKey);	
				if (selectedProvinceValue == cityType.dictionaryKey) {
					//console.log("select:" +selectedProvinceValue+ "cityType" + cityType.dictionaryValue);
					$('select[id=selectCity]').append($('<option>').text(cityType.dictionaryValue).attr('value', cityType.id));
				}
			});
		}
	</script>
</body>

</html>
