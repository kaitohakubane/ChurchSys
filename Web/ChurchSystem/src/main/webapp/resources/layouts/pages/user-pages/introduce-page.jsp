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

    <!-- CSS -->
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">

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
            <p align="justify">
                Nhà thờ giáo xứ chính tòa Đà Nẵng hiện nay được xây dựng trong khoảng thời gian tháng 02 năm 1923 đến
                tháng 9 năm 1924. Ngày 14 tháng 9 năm 1924, Đức Giám mục Grangeon (Mẫn), giám mục địa phận Qui Nhơn và
                Đức Giám mục Allys (địa phận Huế) làm phép nhà thờ. Tước hiệu nhà thờ: Thánh Tâm Chúa Giêsu.
            </p>
            <p align="justify">
                Ngày 18 tháng 01 năm 1963, giáo phận được thiết lập; Đức Cha Phêrô Maria, Giám mục Qui Nhơn được bổ
                nhiệm làm giám mục tiên khởi giáo phận Đà Nẵng và ngày 01 tháng 5 năm 1963, ngài chính thức về nhận giáo
                phận và nhà thờ được vinh dự là nhà thờ Chính Tòa giáo phận Đà Nẵng.
            </p>
            <p align="justify">
                Nhà thờ giáo xứ Chính tòa Đà Nẵng mang phong cách kiến trúc Gothic với những đường nét cao vút, những
                vòm cửa quả trám. Bên trong nhà thờ có các tranh ảnh và thánh tượng minh họa theo sự kiện trong Kinh
                Thánh theo mô-típ các nhà thờ phương Tây. Trên nóc nhà thờ, ở vị trí cột thu lôi có tượng một con gà màu
                xám làm bằng hợp kim dùng làm vật xác định hướng gió. Vì vậy mà nhà thờ giáo xứ Chính tòa Đà Nẵng còn có
                tên là nhà thờ Con Gà.
            </p>
            <p align="justify">
                Hang đá Đức Mẹ mô phỏng hang đá Lộ Đức (bên Pháp) được xây dựng năm và khánh thành ngày 11 tháng 02 năm
                1940, thời linh mục Santuaire (Cố Bính).
            </p>
            <p align="justify">
                Không biết ai là người đầu tiên được rửa tội tại Đà Nẵng hoặc là người Công giáo Việt Nam đầu tiên đến
                sống tại mảnh đất Đà Nẵng này. Chỉ biết được là linh mục Baudet, Marquette và Fuciti đã được sai đến phụ
                trách giáo dân tại cửa Hàn đến ngày 03 tháng 02 năm 1665, theo lệnh chúa Hiền các ngài phải rời khỏi
                Việt Nam.
            </p>
            <p align="justify">
                Theo bản phúc trình của Cha Rival gửi về Hội Truyền giáo Paris (MEP), năm 1700, dịp lễ Lá, nhà thờ Cửa
                Hàn bị quân Chúa Nguyễn lục soát và năm 1741 giáo đoàn Cửa Hàn còn 80 giáo dân.
            </p>
            <p align="justify">
                Và bản phúc trình của Cha Halbout gửi cho MEP: đến tháng 7 năm 1775, giáo đoàn Cửa Hàn bị quân Tây Sơn
                tiêu diệt hoàn toàn. Và từ 1775-1885 giáo đoàn Cửa Hàn không có tên trong lịch sử Giáo hội Việt Nam.
            </p>
            <p align="justify">
                Sau khi phong trào Văn Thân tan rã năm 1885, nhiều giáo dân từ các nơi về sinh sống tại Cửa Hàn. Những
                giáo này được Cha Maillard, cha sở giáo xứ Phú Thượng chăm sóc và là giáo họ trực thuộc giáo xứ Phú
                Thượng.
            </p>
            <p align="justify">
                Sử sách không để lại giáo xứ chính thức được thành lập ngày tháng nào, chỉ biết được rằng linh mục
                Laurent (Cố Chính) đã phục vụ giáo xứ từ 1887-1904, và từ đó đến nay luôn có các linh mục coi sóc giáo
                xứ.
            </p>
            <p align="justify">
                Nhà thờ giáo xứ hiện nay được xây dựng trong khoảng thời gian tháng 02 năm 1923 đến tháng 9 năm 1924.
                Ngày 14 tháng 9 năm 1924, Đức Giám mục Grangeon (Mẫn), giám mục địa phận Qui Nhơn và Đức Giám mục Allys
                (địa phận Huế) làm phép nhà thờ. Tước hiệu nhà thờ: Thánh Tâm Chúa Giêsu.
            </p>
            <p align="justify">
                Ngày 18 tháng 01 năm 1963, giáo phận được thiết lập; Đức Cha Phêrô Maria, Giám mục Qui Nhơn được bổ
                nhiệm làm giám mục tiên khởi giáo phận Đà Nẵng và ngày 01 tháng 5 năm 1963, ngài chính thức nhận về nhận
                giáo phận và nhà thờ Đà Nẵng được vinh dự là nhà thờ Chính Tòa giáo phận Đà Nẵng.
            </p>
            <p align="justify">
                Hang đá Đức Mẹ mô phỏng hang đá Lộ Đức (bên Pháp) được xây dựng năm và khánh thành ngày 11 tháng 02 năm
                1940, thời linh mục Santuaire (Cố Bính).
            </p>
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

