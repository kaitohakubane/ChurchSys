<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 5/31/2017
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Bootstrap -->
<link href="<c:url value="/resources/lib/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
<!-- Font Awesome -->
<link href="<c:url value="/resources/lib/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
<!-- NProgress -->
<link href="<c:url value="/resources/lib/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="<c:url value="/resources/lib/build/css/custom.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/lib/src/js/animate.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/edit-event-page.css"/>" rel="stylesheet">

<script language="javascript">
    var contextPath = "${pageContext.request.contextPath}"
    var churchId = "${sessionScope.churchId}"
</script>
