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

    <title>Hướng dẫn cài đặt OBS</title>

    <c:import url="/resources/layouts/common/header.jsp"/>

</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#step1">Bước 1</a></li>
                    <li><a data-toggle="tab" href="#step2">Bước 2</a></li>
                    <li><a data-toggle="tab" href="#step3">Bước 3</a></li>
                    <li><a data-toggle="tab" href="#step4">Bước 4</a></li>
                    <li><a data-toggle="tab" href="#step5">Bước 5</a></li>
                    <li><a data-toggle="tab" href="#step6">Bước 6</a></li>
                    <li><a data-toggle="tab" href="#step7">Bước 7</a></li>
                    <li><a data-toggle="tab" href="#step8">Kết thúc</a></li>
                </ul>

                <div class="tab-content">
                    <div id="step1" class="tab-pane fade in active">
                        <div class="text-center"><img src="<c:url value="/resources/img/step1.PNG"/>"></div>
                    </div>
                    <div id="step2" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step2.PNG"/>"></div>
                    </div>
                    <div id="step3" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step3.PNG"/>"></div>
                    </div>
                    <div id="step4" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step4.PNG"/>"></div>
                    </div>
                    <div id="step5" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step5.PNG"/>"></div>
                    </div>
                    <div id="step6" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step6.PNG"/>"></div>
                    </div>
                    <div id="step7" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/step7.PNG"/>"></div>
                    </div>
                    <div id="step8" class="tab-pane fade">
                        <div class="text-center"><img src="<c:url value="/resources/img/last.PNG"/>"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>

</body>
</html>
