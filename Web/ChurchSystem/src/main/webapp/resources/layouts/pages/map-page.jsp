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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <link href="<c:url value="/resources/css/map.css"/>" rel="stylesheet">

</head>
<body>

<!-- navbar -->
<nav class="navbar navbar-default navbar-fixed-top mega-nav">
    <div class="container">
        <div class="collapse navbar-collapse" id="MainMenu">
            <ul class="nav navbar-nav menu-list">
                <li><a href="#" class="icon-top"><img alt="Church Icon" src="<c:url value="/resources/img/icon.png"/>" class="icon-img"></a></li>
            </ul>
            <div class="navbar-right">
                <ul class="nav-right">
                    <sec:authentication var="principal" property="principal" />
                    <%--<sec:authorize access="isAuthenticated()">--%>
                        ${principal.username}
                    <%--</sec:authorize>--%>
                    <%--<li><a class="button">${user.role}</a></li>--%>
                    <li><a id="registerBtn" class="button">Đăng ký</a></li>
                    <li><a href="${pageContext.request.contextPath}/index" class="button">Đăng nhập</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- end navbar -->

<!-- popup -->
<div id="stream" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Stream</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/ddFvjfvPnqk" frameborder="0" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->

<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>

<input id="pac-input" class="controls" type="text" placeholder="Search Box">
<div id="map" class="col-md-12"></div>
<div id="geocontainer" class="geolocation"><div id="geolocationBtn" class="icon"></div></div>


<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxrUsPf9t6b1RbI04YsBQnC-FqJmMATZk&libraries=places"
/>"></script>

<script>
    var image = "<c:url value="/resources/img/icons8-Church-48.png"/>"
</script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
</body>


</html>
