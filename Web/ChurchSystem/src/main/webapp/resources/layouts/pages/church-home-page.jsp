<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 6/19/2017
  Time: 10:54 AM
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
    <title>Church Home Page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
</head>
<body>
    <h1>Welcome to ${churchObj.churchName}</h1>
</body>
</html>
