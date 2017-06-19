<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Information Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>

    <!-- FullCalendar -->
    <link href="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.css"/>" rel="stylesheet">

    <!-- CSS -->
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<c:import url="/resources/layouts/user-common/vertical-navbar.jsp"/>
<!-- church-info -->
<div class="container">
    <div class="row">
        <div class="church-info col-md-12">

        </div>
        <div class="small-nav col-md-12">
            <div class="row">
                <div class="col-md-4">
                    <a href="church.html" class="col-md-12 btn btn-default">Tin tức</a>
                </div>
                <div class="col-md-4">
                    <a href="event.html" class="col-md-12 btn btn-default">Sự kiện</a>
                </div>
                <div class="col-md-4">
                    <form>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="glyphicon glyphicon-search"></i>
                                        </button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="border-top"></div>
        </div>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="page-content">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id='calendar'></div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->

<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<!-- FullCalendar -->
<script src="<c:url value="/resources/lib/vendors/moment/min/moment.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/fullcalendar/dist/fullcalendar.min.js"/>"></script>

<script src="<c:url value="/resources/js/church.js"/>"></script>
</body>
</html>
