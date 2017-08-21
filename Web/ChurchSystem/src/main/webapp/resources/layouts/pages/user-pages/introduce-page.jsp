<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/17/2017
  Time: 12:21 AM
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
    <title>Giới thiệu</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>

    <link href="<c:url value="/resources/lib/lightsliderDist/css/lightslider.min.css"/>" rel="stylesheet">

</head>
<body>
<c:import url="/resources/layouts/user-common/user-header.jsp"/>
<!-- church-info -->
<div class="container">
    <div class="row">
        <c:import url="/resources/layouts/user-common/church-info.jsp"/>
        <c:import url="/resources/layouts/user-common/navbar-private.jsp"/>
    </div>
</div>
<!-- end church info -->
<!-- page content -->
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="col-md-12">
                <div class="row">
                    <div class="slider-church">
                        <ul id="lightSlider">
                            <li data-thumb="<c:url value="/resources/img/chanhtoa1.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa1.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa2.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa2.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa3.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa3.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa4.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa4.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa5.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa5.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa6.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa6.jpg"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa7.JPG"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa7.JPG"/>"/>
                                </div>
                            </li>
                            <li data-thumb="<c:url value="/resources/img/chanhtoa8.jpg"/>">
                                <div class="set-size-img"><img src="<c:url value="/resources/img/chanhtoa8.jpg"/>"/>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <div class="title-home-page">
                        <h2 class="text-center"><b>${churchInformationEntity.getChurchName()}</b></h2>
                    </div>
                </div>
                <div class="col-md-12" style="line-height: 39px;">
                    <div class="col-md-3">
                        <div class="row">
                            <p><b>Địa chỉ:</b></p>
                            <p><b>Giáo phận:</b></p>
                            <p><b>Giáo hạt:</b></p>
                            <p><b>Bổn mạng:</b></p>
                            <p><b>Chánh xứ:</b></p>
                            <p><b>Số điện thoại:</b></p>
                            <p><b>Website:</b></p>
                            <p><b>Giờ mở cửa:</b></p>
                            <p><b>Giờ đóng cửa:</b></p>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="row">
                            <p>${churchInformationEntity.getAddress()}</p>
                            <p>Đà Nẵng</p>
                            <p>Đà Nẵng</p>
                            <p>Thánh Tâm Chúa Giêsu</p>
                            <p>${churchInformationEntity.getCertificate()} - ${churchInformationEntity.getUserName()}</p>
                            <p>${churchInformationEntity.getTel()}</p>
                            <p>${churchInformationEntity.getMail()}</p>
                            <p>${churchInformationEntity.getStartTime()}</p>
                            <p>${churchInformationEntity.getEndTime()}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="col-md-12">
            <h3>Thông tin chi tiết</h3>
            <p>${churchInformationEntity.getDescription()}</p>
        </div>
    </div>
</div>
<!-- end page content -->


<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/js/church.js"/>"></script>

<script src="<c:url value="/resources/lib/lightsliderDist/js/lightslider.min.js"/>"></script>

<script>
    $('#lightSlider').lightSlider({
        gallery: true,
        item: 1,
        loop: true,
        slideMargin: 0,
        thumbItem: 3
    });
</script>
<script>
    var churchInformationEntity = "<c:out value="${churchInformationEntity}"></c:out>"

</script>
</body>
</html>

