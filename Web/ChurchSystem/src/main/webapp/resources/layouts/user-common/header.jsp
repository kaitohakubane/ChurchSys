<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Bootstrap -->
<link href="<c:url value="/resources/lib/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
<!-- Font Awesome -->
<link href="<c:url value="/resources/lib/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">

<c:if test="${setting.theme == 0}">
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">
</c:if>
<c:if test="${setting.theme == 1}">
    <link href="<c:url value="/resources/css/church1.css"/>" rel="stylesheet">
</c:if>


<link href="<c:url value="/resources/lib/src/js/animate.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/edit-event-page.css"/>" rel="stylesheet">


<script>
    var contextPath = "${pageContext.request.contextPath}";
</script>