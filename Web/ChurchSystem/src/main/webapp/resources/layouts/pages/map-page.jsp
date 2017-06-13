<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 6/12/2017
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
</head>
<body>
<label class="col-md-3">
    <input id="hideForm" type="radio" class="flat" value="1" checked name="repeat"> No repeat
</label>
<label class="col-md-3">
    <input id="showForm" type="radio" class="flat" value="2" name="repeat"> Repeat
</label>
<c:import url="/resources/layouts/common/footer.jsp"/>
<script>
    $("input:radio[name=repeat]").change(function(){
        alert($(this).val());
    })

</script>
</body>
</html>
