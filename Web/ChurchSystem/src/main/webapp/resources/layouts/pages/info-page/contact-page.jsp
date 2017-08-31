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


    <style>
        .office {
            margin-top: 30px;
        }
        .office:first-child{
            margin-top: 0px;
        }
        .chatter-info{
            height: 80px;
            background: #616e82;
            padding: 10px;
            border-radius: 8px 8px 0 0;
        }
        .chatter-name {
            text-align: center;
            font-size: 25px;
            color: #fff;
            padding: 13px;
        }
        .chatbox{
            width: 100%;
            height: 520px;
            background-color: #eee;
            padding: 10px;
        }
        .chatlogs{
            padding: 10px;
            width: 100%;
            height: 500px;
            overflow: auto;
        }
        .chatlogs::-webkit-scrollbar{
            width: 8px;
        }
        .chatlogs::-webkit-scrollbar-thumb{
            border-radius: 5px;
            background: #e8e8e8;
        }
        .chat {
            display: flex;
            flex-flow: row wrap;
            align-items: flex-start;
        }
        .chat .user-photo{
            width: 50px;
            height: 50px;
            background: #ccc;
            border-radius: 50%;
            margin-top: 5px;
            overflow: hidden;
        }
        .chat .user-photo img {
            width: 100%;
        }
        .chat .chat-message{
            max-width: 60%;
            padding: 12px;
            margin: 5px 10px 0;
            border-radius: 10px;
            color: #fff;
            font-size: 18px;
        }
        .self .chat-message{
            background-color: #1adda4;
            margin-left: auto;
            margin-right: 0px;
        }
        .another .chat-message{
            background: #95c2fd;
        }
        .chat-form{
            height: 80px;
            background: #616e82;
            padding: 10px;
            display: flex;
            align-items: flex-start;
            border-radius: 0 0 8px 8px;
        }
        .chat-form textarea {
            background: #fbfbfb;
            width: 85%;
            height: 60px;
            border: 2px solid #eee;
            border-radius: 5px;
            resize: none;
            padding: 10px;
            font-size: 18px;
        }
        .chat-form textarea:focus {
            border: 2px solid #616e82;
            border-radius: 5px;
            background: #fff;
            outline-style: none;
        }
        .chat-form textarea::-webkit-scrollbar{
            width: 8px;
        }
        .chat-form textarea::-webkit-scrollbar-thumb{
            border-radius: 5px;
            background: #e8e8e8;
        }
        .chat-form button {
            width: 15%;
            margin-left: 5px;
            margin-right: 0px;
            height: 60px;
            border-radius: 5px;
            font-size: 20px;
            background: #f9eda4;
            border: none;
            color: #333;
        }
        .chat-form button:hover{
            background: #e8d776;
            transition: all 0.2s;
            box-shadow: 3px 3px 2px #333;
        }
        .contact-info{
            height: 60px;
            background: #616e82;
            padding: 10px;
            border-radius: 8px 8px 0 0;
        }
        .contact-name {
            text-align: center;
            font-size: 20px;
            color: #fff;
            padding: 9px;
        }
        .list-bottom{
            height: 30px;
            background: #616e82;
            border-radius: 0px 0px 8px 8px;
        }
        .text-info {
            background: #eee;
        }
    </style>
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
                <div class="list-bottom"></div>
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
                <div class="list-bottom"></div>
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
                <div class="list-bottom"></div>
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