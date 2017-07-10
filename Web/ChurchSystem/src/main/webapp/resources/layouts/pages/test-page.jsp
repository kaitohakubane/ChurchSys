<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 5/31/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <%--Content    --%>
        <div class="right_col" role="main">
            <textarea id="notifications-area" cols="1200" rows="10" readonly="readonly"></textarea>
        </div>
        <%--Content end--%>
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>
<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/js/test.js"/>"></script>

</body>
</html>
