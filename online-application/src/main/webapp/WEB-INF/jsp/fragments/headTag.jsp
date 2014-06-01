<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>on-line application</title>


    <spring:url value="/webjars/bootstrap/3.0.3/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    
    <!-- jquery-ui.css file is not that big so we can afford to load it -->
    <spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>

    <spring:url value="/resources/css/main.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/2.0.3/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

	<!-- jquery-ui.js file is really big so we only load what we need instead of loading everything -->
    <spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js" var="jQueryUiCore"/>
    <script src="${jQueryUiCore}"></script>

	<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js" var="jQueryUiDatePicker"/>
    <script src="${jQueryUiDatePicker}"></script>
    
    <spring:url value="/webjars/bootstrap/3.0.3/js/bootstrap.min.js" var="bootstrap"/>
    <script src="${bootstrap}"></script>
    
</head>


