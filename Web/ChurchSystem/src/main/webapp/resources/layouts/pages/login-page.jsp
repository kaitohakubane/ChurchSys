<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 5/29/2017
  Time: 11:13 PM
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

    <title>Login Page</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/lib/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- CSS -->
    <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">
</head>
<body  class="bg-login">
<div class="container">
    <div class="row pt-200">
        <div class="col-md-4 col-md-offset-4">

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form action="login" method="POST">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" id="managerId" placeholder="Username" name="accountId" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" id="password" placeholder="Password" name="password" type="password" value="Abcd1234">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                </label>
                            </div>
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Login"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
