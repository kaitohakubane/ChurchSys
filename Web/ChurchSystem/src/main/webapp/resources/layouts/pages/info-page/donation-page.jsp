<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/30/2017
  Time: 10:14 PM
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
    <title>Donation Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>
    <!-- CSS -->
    <link href="<c:url value="/resources/css/church.css"/>" rel="stylesheet">

    <style>
        .office {
            margin-top: 30px;
        }
        .office:first-child{
            margin-top: 0px;
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
    <div class="row rowcn">
        <div class="col-md-6">
            <h2 class="form-group col-md-4 col-md-offset-6" >Đóng góp</h2>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Người nhận:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <select class="form-control">
                                <option>Nhà thờ</option>
                                <option>Cha xứ</option>
                                <option>Ban giáo lý</option>
                                <option>Ban điều hành</option>
                                <option>Linh mục</option>
                                <option>Hội đoàn</option>
                            </select>
                            <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>


            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Nội dung:</label>
                    <div class="col-md-9">
                        <textarea class="form-control" rows="7"></textarea>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Số tiền:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="number" class="form-control" min="0" max="9999999999999999999999999999999">
                            <span class="input-group-addon"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-5 control-label">Hình thức thanh toán:</label>
                    <div class="col-md-7">
                        <div class="input-group">
                            <label class="radio-inline"><input type="radio" name="donate">Visa</label>
                            <label class="radio-inline"><input type="radio" name="donate">Chuyển khoản</label>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="col-md-7 col-md-offset-5">
                    <img src="<c:url value="/resources/img/visa.png"/>">
                    <img src="<c:url value="/resources/img/mastercard.png"/>" alt="Mastercard">
                    <img src="<c:url value="/resources/img/american-express.png"/>" alt="American Express">
                    <img src="<c:url value="/resources/img/paypal.png"/>" alt="Paypal">
                </div>
            </form>

            <h2 class="form-group col-md-9 col-md-offset-3" >Thông tin người đóng góp</h2>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Họ tên:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Email:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Địa chỉ:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group has-success">
                    <label class="col-md-3 control-label">Số điện thoại:</label>
                    <div class="col-md-9">
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        </div>
                    </div>
                </div>
            </form>

            <form class="form-horizontal">
                <div class="form-group">
                    <button type="button" class="btn btn-success col-md-3 col-md-offset-4">Đóng góp</button>
                    <button type="button" class="btn btn-default col-md-3 col-md-offset-1">Hủy</button>
                </div>
            </form>

        </div>
        <div class="col-md-6">
            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng giáo xứ</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0907 120 203</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                        <span>010203050506</span>
                    </div>
                </div>
            </div>

            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng giáo lý</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 908 1762</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                        <span>010203050506</span>
                    </div>
                </div>
            </div>

            <div class="office">
                <h2 class="form-group col-md-9 col-md-offset-3" >Văn phòng mục vụ</h2>
                <div class="clearfix"></div>
                <div class="col-md-offset-3" style="font-size: 20px">
                    <div>
                        <span class="col-md-2"><i class="fa fa-phone" aria-hidden="true"></i></span>
                        <span>0128 610 4818</span>
                    </div>
                    <div>
                        <span class="col-md-2"><i class="fa fa-credit-card" aria-hidden="true"></i></span>
                        <span>010203050506</span>
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

