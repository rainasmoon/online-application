<%@page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>on-line application</title>

<spring:eval expression="@applicationProps['application.version']"
	var="applicationVersion" />

<spring:url value="/resources-{applicationVersion}" var="resourceUrl">
	<spring:param name="applicationVersion" value="${applicationVersion}" />
</spring:url>

<spring:url value="/webjars/bootstrap/3.1.1/css/bootstrap.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

<!-- jquery-ui.css file is not that big so we can afford to load it -->
<spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css"
	var="jQueryUiCss" />
<link href="${jQueryUiCss}" rel="stylesheet"></link>

<link href="${resourceUrl}/css/main.css" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<spring:url value="/webjars/jquery/2.0.3/jquery.js" var="jQuery" />
<script src="${jQuery}"></script>

<spring:url
	value="/webjars/jquery-placeholder/2.0.7/jquery.placeholder.js"
	var="jQueryPlaceholder" />
<script src="${jQueryPlaceholder}"></script>

<!-- jquery-ui.js file is really big so we only load what we need instead of loading everything -->
<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js"
	var="jQueryUiCore" />
<script src="${jQueryUiCore}"></script>

<spring:url value="/webjars/bootstrap/3.1.1/js/bootstrap.js"
	var="bootstrap" />
<script src="${bootstrap}"></script>


</head>


