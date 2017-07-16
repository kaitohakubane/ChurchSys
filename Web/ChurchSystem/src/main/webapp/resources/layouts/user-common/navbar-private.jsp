<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/11/2017
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<div class="col-md-12">
    <div class="nav-private">
        <ul class="ul-private">
            <li><a href="${pageContext.request.contextPath}/church/info?churchId=${param.churchId}">Giới thiệu</a></li>
            <li><a href="${pageContext.request.contextPath}/church?churchId=${param.churchId}">Tin tức</a></li>
            <li><a href="${pageContext.request.contextPath}/church/schedule?churchId=${param.churchId}">Sự kiện</a></li>
            <li class="dropdown list-category">
                <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    </i>Lớp giáo lý <i class="fa fa-caret-down" aria-hidden="true"></i>
                </a>
                <ul class="dropdown-menu mega-dropdown-menu abc">
                    <li><a href="${pageContext.request.contextPath}/church/class?churchId=${param.churchId}">Đang mở</a></li>
                    <li><a href="#">Đang diễn ra</a></li>
                    <li><a href="#">Đã hoàn thành</a></li>
                    <li><a href="#">Đăng kí mở lớp mới</a></li>
                </ul>
            </li>
            <li><a href="#">Live Stream</a></li>
            <li><a href="#">Hỏi - Đáp</a></li>
            <li><a href="#">Cầu nguyện</a></li>
            <li><a href="#">Liên hệ</a></li>
            <li><a href="#">Đóng góp</a></li>
            <li><a href="#">Phản hồi</a></li>
        </ul>
    </div>
</div>
<div class="col-md-12"><div class="border-top"></div></div>
</html>
