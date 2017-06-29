<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 6/12/2017
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/css/map.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/user-menu.jsp"/>
        <div class="right_col" role="main">
            <div class="page-title">
                <div class="title_left">
                    <h3>Map</h3>
                </div>
            </div>
            <div class="size">
                <input id="pac-input" class="controls" type="text" placeholder="Search Box">
                <div id="map" style="height: 590px; width: 1080px;"></div>
            </div>
        </div>
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxrUsPf9t6b1RbI04YsBQnC-FqJmMATZk&libraries=places"
/>"></script>
<c:import url="/resources/layouts/common/footer.jsp"/>
<script>
    var image = "<c:url value="/resources/img/icons8-Church-48.png"/>"
</script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
</body>


</html>
