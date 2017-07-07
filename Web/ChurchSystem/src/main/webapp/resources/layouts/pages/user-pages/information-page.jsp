<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 9:45 PM
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
                    <a href="#" class="col-md-12 btn btn-default">Tin tức</a>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/church/schedule?churchId=${churchId}" class="col-md-12 btn btn-default">Sự kiện</a>
                </div>
                <div class="col-md-4">
                    <a href="#" class="col-md-12 btn btn-default">Đăng ký lớp học</a>
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
            <div class="col-md-8">
                <div class="block1">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="img-mb">
                                        <a href="#" class="set-size-img"><img
                                                src="<c:url value="/resources/img/main-news.jpg"/>"></a>
                                    </div>
                                    <a href="#" class="main-title"><strong>Đức Phanxicô: “Những lời sáo rỗng không giúp
                                        gì cho người nghèo”</strong></a>
                                    <p class="main-detail">Người ta không thể thảnh thơi và thờ ơ hoặc thậm chí chẳng
                                        thèm bận tâm đến sự nghèo đói ...</p>
                                </div>
                                <div class="col-md-4">
                                    <div class="img-mb">
                                        <a href="#" class="set-size-img"><img
                                                src="<c:url value="/resources/img/1.jpg"/>"></a>
                                    </div>
                                    <a href="#"><strong>Sách nhiễu tôn giáo toàn cầu gia tăng</strong></a>
                                </div>
                                <div class="col-md-4">
                                    <div class="img-mb">
                                        <a href="#" class="set-size-img"><img
                                                src="<c:url value="/resources/img/2.jpg"/>"></a>
                                    </div>
                                    <a href="#"><strong>Kitô hữu bị sách nhiễu nhiều hơn</strong></a>
                                </div>
                                <div class="col-md-4">
                                    <div class="img-mb">
                                        <a href="#" class="set-size-img"><img
                                                src="<c:url value="/resources/img/3.png"/>"></a>
                                    </div>
                                    <a href="#"><strong>Thần khí Đức Kitô và các Nhiệm tích của Hội Thánh</strong></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <h2 class="topic-title"><a href="#" class="title-color">Tin mới</a></h2>
                            <div class="news">
                                <ul>
                                    <li><a href="#">Đức Phanxicô: “Những lời sáo rỗng không giúp gì cho người nghèo”</a>
                                    </li>
                                    <li><a href="#">Sách nhiễu tôn giáo toàn cầu gia tăng</a></li>
                                    <li><a href="#">Kitô hữu bị sách nhiễu nhiều hơn</a></li>
                                    <li><a href="#">Thần khí Đức Kitô và các Nhiệm tích của Hội Thánh</a></li>
                                    <li><a href="#">Suy niệm Tin Mừng 16/06/2017: Thủy chung (Mt 5,27-32)</a></li>
                                    <li><a href="#">Giới trẻ thừa sai Chúa Cứu Thế Việt Nam: Đức Thánh Cha Phanxicô với
                                        Giới trẻ</a></li>
                                    <li><a href="#">Bí quyết sự lãnh đạo của Đức Phanxicô là gì?</a></li>
                                    <li><a href="#">Chính quyền trì hoãn bầu chọn giám mục kế nhiệm</a></li>
                                    <li><a href="#">Anh em Nhà Chúa Cứu Thế</a></li>
                                    <li><a href="#">Liên đới với những anh em bị tổn thương</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="mt">
                        <div class="col-md-12">
                            <img src="<c:url value="/resources/img/bot-img.png"/>" class="set-size-img">
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="block2">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="topic-title"><a href="#" class="title-color">Đức Phanxico</a></h2>
                            <div class="b2-content">
                                <div class="row">
                                    <div class="col-md-7">
                                        <div class="col-md 12">
                                            <a href="#" class="title-mtb"><strong>Bí quyết sự lãnh đạo của Đức Phanxicô
                                                là gì?</strong></a>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <img src="<c:url value="/resources/img/b2-1.png"/>"
                                                     class="set-size-img">
                                            </div>
                                            <div class="col-md-6">
                                                <p>Bí quyết sự lãnh đạo của Đức Phanxicô là gì? Một ca sĩ nổi tiếng, một
                                                    nhà vô địch cờ vua, và một người mẫu hàng ...</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="b2-right-col">
                                                <div class="col-md-6">
                                                    <img src="<c:url value="/resources/img/b2-r1.png"/>" alt=""
                                                         class="set-size-img">
                                                </div>
                                                <div class="col-md-6">
                                                    <a href="#"><strong>Chúng ta đang được thấy Đức Phanxicô thể chế hóa
                                                        tầm nhìn của ngài</strong></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Đức Phanxicô với giới trẻ: “Hãy sẻ chia cuộc sống
                                                    của các con”</strong></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Đức Phanxicô, cũng giống như Trump, không muốn lên
                                                    án Nga về vấn đề Syria.</strong></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="block2">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="topic-title"><a href="#" class="title-color">Tin giáo hội</a></h2>
                            <div class="b2-content">
                                <div class="row">
                                    <div class="col-md-7">
                                        <div class="col-md 12">
                                            <a href="#" class="title-mtb"><strong>Đức Phanxicô: “Những lời sáo rỗng
                                                không giúp gì cho người nghèo”</strong></a>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <img src="<c:url value="/resources/img/b2-2.jpg"/>"
                                                     class="set-size-img">
                                            </div>
                                            <div class="col-md-6">
                                                <p>Người ta không thể thảnh thơi và thờ ơ hoặc thậm chí chẳng thèm bận
                                                    tâm đến sự nghèo đói đang ngày càng gia tăng ...</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="b2-right-col">
                                                <div class="col-md-6">
                                                    <img src="<c:url value="/resources/img/b2-r2.jpg"/>" alt=""
                                                         class="set-size-img">
                                                </div>
                                                <div class="col-md-6">
                                                    <a href="#"><strong>Đức Thánh Cha Phanxicô làm mới cơ quan phò sinh
                                                        hàng đầu của Vatican</strong></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>ĐTC Phanxicô: "Không một Kitô hữu nào có thể xem
                                                    thường việc phục vụ người nghèo"</strong></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>BẢN TUYÊN BỐ Về những bất ổn xảy ra gần đây trên địa
                                                    bàn giáo xứ.</strong></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="block2">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="topic-title"><a href="#" class="title-color">Xã hội</a></h2>
                            <div class="b2-content">
                                <div class="row">
                                    <div class="col-md-7">
                                        <div class="col-md 12">
                                            <a href="#" class="title-mtb"><strong>Sách nhiễu tôn giáo toàn cầu gia
                                                tăng</strong></a>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <img src="<c:url value="/resources/img/1.jpg"/>" class="set-size-img">
                                            </div>
                                            <div class="col-md-6">
                                                <p>Theo báo cáo hàng năm mới nhất của Trung tâm nghiên cứu Pew về những
                                                    sách nhiễu tôn giáo toàn cầu, những sách nhiễu của ...</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="b2-right-col">
                                                <div class="col-md-6">
                                                    <img src="<c:url value="/resources/img/b2-r3.jpg"/>" alt=""
                                                         class="set-size-img">
                                                </div>
                                                <div class="col-md-6">
                                                    <a href="#"><strong>Chính quyền trì hoãn bầu chọn giám mục kế
                                                        nhiệm</strong></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Liên đới với những anh em bị tổn thương</strong></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Các ngôi Thánh đường bị phá hủy, các Kitô hữu bị cầm
                                                    tù tại tỉnh Hà Nam của Trung Quốc</strong></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="block2">
                    <div class="row">
                        <div class="col-md-12">
                            <h2 class="topic-title"><a href="#" class="title-color">Học hỏi</a></h2>
                            <div class="b2-content">
                                <div class="row">
                                    <div class="col-md-7">
                                        <div class="col-md 12">
                                            <a href="#" class="title-mtb"><strong>Tước hiệu “Chiên Thiên Chúa” trong Tin
                                                mừng Gioan</strong></a>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <img src="<c:url value="/resources/img/4.jpg"/>" class="set-size-img">
                                            </div>
                                            <div class="col-md-6">
                                                <p>Thành ngữ “Chiên Thiên Chúa” là một diễn ngữ khá đặc biệt trong cách
                                                    dùng của tác giả Gioan. Đây là một tước hiệu Kitô ...</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="b2-right-col">
                                                <div class="col-md-6">
                                                    <img src="<c:url value="/resources/img/2.jpg"/>" alt=""
                                                         class="set-size-img">
                                                </div>
                                                <div class="col-md-6">
                                                    <a href="#"><strong>Kitô hữu bị sách nhiễu nhiều hơn</strong></a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Thần khí Đức Kitô và các Nhiệm tích của Hội Thánh
                                                    (tiếp theo)</strong></a>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="divice"></div>
                                                <a href="#"><strong>Thần khí Đức Kitô trong Hội Thánh Tông Đồ (tiếp
                                                    theo)</strong></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Chia sẻ lời chúa</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/t9qNS6aHMw8" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Bài giảng - Thánh lễ</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/WYOocqjRM_Y" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Chia sẻ lời chúa</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/t9qNS6aHMw8" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Bài giảng - Thánh lễ</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/WYOocqjRM_Y" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Chia sẻ lời chúa</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/t9qNS6aHMw8" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="block-right">
                    <h2 class="topic-title"><a href="#" class="title-color">Bài giảng - Thánh lễ</a></h2>
                    <div class="videoWrapper">
                        <iframe width="480" height="360" src="https://www.youtube.com/embed/WYOocqjRM_Y" frameborder="0"
                                allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>
<script src="<c:url value="/resources/js/church.js"/>"></script>
</body>
</html>
