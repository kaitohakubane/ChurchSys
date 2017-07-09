<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<!-- navbar -->
<nav class="navbar navbar-default navbar-fixed-top mega-nav">
    <div class="container">
        <div class="collapse navbar-collapse" id="MainMenu">
            <ul class="nav navbar-nav menu-list">
                <li><a href="${pageContext.request.contextPath}/" class="icon-top"><img alt="Church Icon" src="<c:url value="/resources/img/icon.png"/>" class="icon-img"></a></li>
                <li><a href="#">Trang chủ</a></li>
                <li><a href="#">Lịch công giáo</a></li>
                <li><a href="#">Hỏi đáp</a></li>
                <li><a href="#">Thánh lễ</a></li>
                <li><a href="#">Đăng kí lớp học</a></li>
                <li class="dropdown list-category">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-navicon"></i> Thư viện <i class="fa fa-caret-down" aria-hidden="true"></i>
                    </a>
                    <ul class="dropdown-menu mega-dropdown-menu">
                        <li><a href="#">Kinh thánh</a></li>
                        <li><a href="#">Sách kinh</a></li>
                        <li><a href="#">Câu chuyện các thánh</a></li>
                        <li><a href="#">Thánh ca</a></li>
                        <li><a href="#">Phim &#38; Audio</a></li>
                        <li><a href="#">Kiểm tra kinh thánh</a></li>
                        <li><a href="#">Khác</a></li>
                    </ul>
                </li>
            </ul>
            <div class="pull-right">
                <ul class="nav-right">

                    <sec:authentication var="principal" property="principal"/>
                    <c:choose>

                        <c:when test="${principal ne 'anonymousUser'}">
                            <li class="profile">
                                <div>
                                    <strong>${principal.username}</strong>
                                </div>
                            </li>
                            <li><a href="#" class="button">Đăng xuất</a></li>

                        </c:when>
                        <c:when test="${principal eq 'anonymousUser'}">
                            <li><a id="registerBtn" class="button">Đăng ký</a></li>
                            <li><a href="${pageContext.request.contextPath}/index" class="button">Đăng nhập</a></li>
                        </c:when>
                    </c:choose>


                </ul>
            </div>
        </div>
    </div>
</nav>
<!-- end navbar -->
</html>
