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

<c:import url="/resources/layouts/user-common/user-header.jsp"/>



<!-- navbar left -->
<div id="wrapper">
    <div id="sidebar-wrapper">
        <ul id="sidebar_menu" class="sidebar-nav">
            <li class="sidebar-brand"><a id="menu-toggle" href="#">Nhà thờ Online<span id="main_icon" class="glyphicon glyphicon-align-justify"></span></a></li>
        </ul>
        <ul class="sidebar-nav" id="sidebar">

        </ul>
    </div>
</div>

<input id="pac-input" class="controls" type="text" placeholder="Search Box">
<div id="map" class="col-md-12"></div>
<div id="geocontainer" class="geolocation">
    <div id="geolocationBtn" class="icon"></div>
</div>
<!-- popup -->
<div id="stream" class="modal fade" role="dialog" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Stream</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="videoWrapper">
                        <iframe id="youtubeVideo" width="480" height="360" src="https://www.youtube.com/embed/ddFvjfvPnqk" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" id="closeBtn" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxrUsPf9t6b1RbI04YsBQnC-FqJmMATZk&libraries=places"
/>"></script>

<script>
    var icon = "<c:url value="/resources/img/icons8-Church-48.png"/>"
    <%--var streaming_icon = "<c:url value="/resources/img/streamming-icon.png"/>"--%>
    var streaming_icon = "<c:url value="/resources/img/choosing-icon.png"/>"
</script>
<script src="<c:url value="/resources/js/map.js"/>"></script>
</body>


</html>
