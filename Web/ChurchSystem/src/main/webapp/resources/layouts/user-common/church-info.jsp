<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/9/2017
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<div class="col-md-12">
    <div class="church-info">
        <div class="row">
                <div class="col-md-12">
                    <div class="church-info-cover">
                        <p id="churchName" style="text-align: center; color: #fff; font-weight: bold;
                         font-size: 234%; padding-top: 20px;" >${churchObj.churchName}</p>
                    </div>
                </div>
        </div>
    </div>
</div>
</html>
