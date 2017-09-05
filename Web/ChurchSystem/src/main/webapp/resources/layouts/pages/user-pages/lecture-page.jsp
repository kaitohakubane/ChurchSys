<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/5/2017
  Time: 10:41 AM
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
    <title>Lecture Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>


    <style>
        .list-heading{
            height: 50px;
            background: #616e82;
            border-radius: 8px 8px 0 0;
            color: #fff;
            text-align: center;
            font-size: 22px;
            padding: 9px;
        }
        .list-bottom{
            height: 40px;
            background: #616e82;
            border-radius: 0px 0px 8px 8px;
        }
        .lecture-list {
            background: #eee;
            height: 500px;
            overflow: auto;
        }
        .lecture-list::-webkit-scrollbar{
            width: 8px;
        }
        .lecture-list::-webkit-scrollbar-thumb{
            border-radius: 5px;
            background: #e8e8e8;
        }
        .lecture-list ul {
            padding: 0px;
        }
        .lecture-list ul li {
            list-style: none;
            padding: 10px 15px;
        }
        .lecture-list li:hover {
            background: #ccc;
        }
        .active-lecture {
            background: #ccc;
        }
        .lecture-list ul li .name {
            font-size: 20px;
            color: #333;
        }
        .lecture-name{
            height: 50px;
            background: #616e82;
            border-radius: 8px 8px 0 0;
            color: #fff;
            text-align: center;
            font-size: 22px;
            padding: 9px;
        }
        .videoWrapper-lecture {
            position: relative;
            padding-bottom: 62%;
            padding-top: 35px;
            height: 0;
        }
        .videoWrapper-lecture iframe {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
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
        <div class="col-md-4">
            <div class="list-heading">
                <p>Danh sách bài học</p>
            </div>
            <div class="lecture-list">
                <ul class="list-lecture-name">
                    <li>
                        <a href="#">
                            <div class="name">
                                <span>Bài 1 - Bài giảng về đạo lý</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="name">
                                <span>Bài 2 - Bài giảng về thiên chúa</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="list-bottom">
            </div>
        </div>

        <div class="col-md-8">
            <div class="lecture">
                <div class="lecture-name">
                    <p>Bài 1 - Bài giảng về đạo lý</p>
                </div>
                <div class="lecture-content">
                    <div class="videoWrapper-lecture">
                        <iframe id="youtubeVideo" width="480" height="360" src="https://www.youtube.com/embed/t9qNS6aHMw8"
                                frameborder="0" allowfullscreen></iframe>
                    </div>
                </div>
                <div class="list-bottom">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/js/church.js"/>"></script>

<script src="<c:url value="/resources/js/lecture.js"/>"></script>
</body>
</html>
