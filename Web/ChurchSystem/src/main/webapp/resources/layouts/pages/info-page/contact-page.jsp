<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/30/2017
  Time: 10:24 PM
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
    <title>Contact Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>

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

            <div class="chatter-info">
                <div class="chatter-name">
                    <span>Liên hệ với Cha xứ</span>
                </div>
            </div>

            <div class="chatbox">

                <div class="chatlogs">
                    <div class="chat self">
                        <p class="chat-message">Hello...</p>
                    </div>

                    <div class="chat another">
                        <div class="user-photo"><img src="images/img.jpg"></div>
                        <p class="chat-message">Hello...</p>
                    </div>

                </div>

            </div>

            <div class="chat-form">
                <textarea name="" id=""></textarea>
                <button><i class="fa fa-paper-plane" aria-hidden="true"><div>Gửi</div></i></button>
            </div>

        </div>

        <div class="col-md-4 col-md-offset-1">
            <div class="office">
                <div class="contact-info">
                    <div class="contact-name">
                        <span>Văn phòng giáo xứ</span>
                    </div>
                </div>
                <div class="text-info" style="font-size: 20px;line-height: 40px;padding-left: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0907 120 203</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>vanphonggiaoxu@gmail.com</span>
                    </div>
                </div>
                <div class="list-bottom-contact"></div>
            </div>

            <div class="office">
                <div class="contact-info">
                    <div class="contact-name">
                        <span>Văn phòng giáo lý</span>
                    </div>
                </div>

                <div class="text-info" style="font-size: 20px;line-height: 40px;padding-left: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 908 1762</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>vanphonggiaoly@gmail.com</span>
                    </div>
                </div>
                <div class="list-bottom-contact"></div>
            </div>

            <div class="office">
                <div class="contact-info">
                    <div class="contact-name">
                        <span>Văn phòng mục vụ</span>
                    </div>
                </div>
                <div class="text-info" style="font-size: 20px;line-height: 40px;padding-left: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 610 4818</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        <span>vanphongmucvu@gmail.com</span>
                    </div>
                </div>
                <div class="list-bottom-contact"></div>
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