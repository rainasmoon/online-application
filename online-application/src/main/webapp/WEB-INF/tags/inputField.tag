<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true"
	description="Name of corresponding property in bean object"%>
<%@ attribute name="label" required="true" rtexprvalue="true"
	description="Label appears in red color if input is considered as invalid after submission"%>
<%@ attribute name="required" required="false" rtexprvalue="true"%>
<%@ attribute name="autofocus" required="false" rtexprvalue="true"%>
<%@ attribute name="placeholder" required="false" rtexprvalue="true"%>
<%@ attribute name="type" required="false" rtexprvalue="true"%>

<spring:bind path="${name}">
	<c:set var="cssGroup"
		value="control-group ${status.error ? 'has-error' : '' }" />
	<div class="${cssGroup}">
		<label class="control-label">${label}</label>
		<form:input path="${name}" class="form-control"
			placeholder="${ placeholder }"
			required="${required ? 'required' : '' }"
			autofocus="${autofocus ? 'autofocus' : '' }" type="${type }"/>
		<span class="control-label">${status.errorMessage}</span>
	</div>
</spring:bind>