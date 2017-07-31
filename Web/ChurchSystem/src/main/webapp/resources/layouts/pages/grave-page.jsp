<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/16/2017
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Mộ phần</title>

    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/lib/gridDist/gridstack.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/grave.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#step1">Bố trí phòng</a></li>
                    <li><a data-toggle="tab" href="#step2">Sơ đồ mộ</a></li>

                </ul>

                <div class="tab-content">
                    <div id="step1" class="tab-pane fade in active">
                        <div>
                            <a class="btn btn-default" id="load-grid" href="#">Load Grid</a>
                            <a class="btn btn-default" id="add-cabinet" href="#">Add Cabinet</a>
                        </div>
                        <div class="grid-stack room">

                        </div>
                    </div>
                    <div id="step2" class="tab-pane fade">
                        <div class="grid-stack cabinet">

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/lib/src/js/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/lodash.min.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.js"/>"></script>
<script src="<c:url value="/resources/lib/gridDist/gridstack.jQueryUI.js"/>"></script>
<script src="<c:url value="/resources/js/grave.js"/>"></script>
</body>
</html>
