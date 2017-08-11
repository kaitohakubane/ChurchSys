<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 7/30/2017
  Time: 10:26 PM
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
    <title>Pray Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>


    <style>
        /*+++++++++++++++++*/
        .inline-group .invalid {
            display: none !important;
        }

        .ecf-body {
            max-width: 600px;
            margin: 0 auto;
            padding: 40px;
            box-sizing: content-box;
            -moz-box-sizing: content-box;
        }

        /**/
        /* radios and checkboxes */
        /**/
        .ecf-form .checkbox {
            margin-bottom: 4px;
            padding-left: 27px;
            font-size: 15px;
            line-height: 27px;
            color: #404040;
            cursor: pointer;
        }
        .ecf-form .checkbox:last-child {
            margin-bottom: 0;
        }
        .ecf-form .checkbox input {
            position: absolute;
            left: -9999px;
        }
        .ecf-form .checkbox i {
            position: absolute;
            top: 5px;
            left: 0;
            display: block;
            width: 13px;
            height: 13px;
            outline: none;
            border-width: 2px;
            border-style: solid;
            background: #fff;
        }
        .ecf-form .checkbox input + i:after {
            position: absolute;
            opacity: 0;
            -ms-transition: opacity 0.1s;
            -moz-transition: opacity 0.1s;
            -webkit-transition: opacity 0.1s;
        }
        .ecf-form .checkbox input + i:after {
            content: '\f00c';
            top: -1px;
            left: -1px;
            width: 15px;
            height: 15px;
            font: normal 12px/16px FontAwesome;
            text-align: center;
        }
        .ecf-form .checkbox input:checked + i:after {
            opacity: 1;
        }
        .ecf-form .inline-group {
            margin: 0 -30px -4px 0;
        }
        .ecf-form .inline-group:after {
            content: '';
            display: table;
            clear: both;
        }
        .ecf-form .inline-group .checkbox {
            margin-right: 30px;
        }
        .ecf-form .inline-group .checkbox:last-child {
            margin-bottom: 4px;
        }
        /**/
        /* normal state */
        /**/
        .ecf-form .input input,
        .ecf-form .select select,
        .ecf-form .textarea textarea,
        .ecf-form .checkbox i,
        .ecf-form .icon-prepend {
            border-color: #e5e5e5;
            -ms-transition: border-color 0.3s;
            -moz-transition: border-color 0.3s;
            -webkit-transition: border-color 0.3s;
        }
        .ecf-form .ecfbutton {
            background-color: #2da5da;
            opacity: 1;
            -ms-transition: opacity 0.2s;
            -moz-transition: opacity 0.2s;
            -webkit-transition: opacity 0.2s;
        }
        .ecf-form .icon-prepend {
            color: #ccc !important;
            background-image: none !important;
        }

        /**/
        /* bootstrap compatibility */
        /**/
        .ecf-form *,
        .ecf-form *:after,
        .ecf-form *:before {
            margin: 0;
            padding: 0;
            box-sizing: content-box;
            -moz-box-sizing: content-box;
        }
        .ecf-form .label {
            border-radius: 0;
            font-size: 100% !important;
            text-align: left;
            white-space: normal;
            color: inherit;
        }
        .ecf-form .checkbox {
            font-weight: 400;
        }
        .ecf-form .checkbox + .checkbox {
            margin-top: 0;
        }

        /**/
        /* defaults */
        /**/
        .ecf-form {
            margin: 0;
            outline: none;
            box-shadow: 0 0 20px rgba(0,0,0,.3);
            font: 13px/1.55 'Open Sans', Helvetica, Arial, sans-serif !important;
            color: #666 !important;
        }
        .ecf-form header {
            display: block;
            padding: 20px 30px;
            border-bottom: 1px solid rgba(0,0,0,.1);
            background: rgba(248,248,248,.9);
            font-size: 25px;
            font-weight: 300;
            color: #232323;
            float: none !important;
            width: auto !important;
        }
        .ecf-form fieldset {
            display: block;
            padding: 25px 23px 5px;
            border: none;
            background: rgba(255,255,255,.9);
        }
        .ecf-form fieldset + fieldset {
            border-top: 1px solid rgba(0,0,0,.1);
        }
        .ecf-form section {
            margin-bottom: 20px;
        }
        .ecf-form footer {
            display: block;
            padding: 15px 30px 25px;
            border-top: 1px solid rgba(0,0,0,.1);
            background: rgba(248,248,248,.9);
            width: auto !important;
        }
        .ecf-form footer:after {
            content: '';
            display: table;
            clear: both;
        }
        .ecf-form a {
            color: #2da5da;
        }
        .ecf-form .label {
            display: block;
            margin-bottom: 6px;
            line-height: 19px !important;
            font-weight: 400 !important;
            background-color: transparent !important;
        }
        .ecf-form .input,
        .ecf-form .select,
        .ecf-form .textarea,
        .ecf-form .checkbox,
        .ecf-form .ecfbutton {
            position: relative;
            display: block;
        }
        .ecf-form .input input,
        .ecf-form .textarea textarea {
            display: block;
            box-sizing: border-box;
            -moz-box-sizing: border-box;
            width: 100%;
            height: 39px;
            padding: 8px 10px;
            outline: none;
            border-width: 2px;
            border-style: solid;
            border-radius: 0;
            background: #fff;
            font: 15px/19px 'Open Sans', Helvetica, Arial, sans-serif;
            color: #404040;
            appearance: normal;
            -moz-appearance: none;
            -webkit-appearance: none;
        }


        /**/
        /* buttons */
        /**/
        .ecf-form .ecfbutton {
            float: right;
            height: 39px;
            overflow: hidden;
            margin: 10px 0 0 20px;
            padding: 0 25px;
            outline: none;
            border: 0;
            font: 300 15px/39px 'Open Sans', Helvetica, Arial, sans-serif !important;
            text-decoration: none;
            color: #fff;
            cursor: pointer;
            background-image: none !important;
        }
        .ecf-form .checkbox input + i:after {
            color: #2da5da;
        }
        .ecf-form .checkbox input:checked + i {
            border-color: #2da5da;
        }
        .ecf-form .input input:focus,
        .ecf-form .textarea textarea:focus,
        .ecf-form .checkbox input:focus + i {
            border-color: #2da5da;
        }
        .ecf-form .input:hover input,
        .ecf-form .textarea:hover textarea,
        .ecf-form .checkbox:hover i {
            border-color: #8dc9e5;
        }

        /* Form Header Image @since 1.0.8.1*/

        .ecf-head-img-con {
            display: inline-block;
            max-width: 210px;
            margin: 0px 15px 0px 0px;
        }


        .ecf-head-img-con img {
            vertical-align: middle;
            margin: 0px !important;
            box-shadow:none !important;
            max-width: 100%  !important;
            height: auto !important;
        }


        #form-img-wrapper{
            width:100%;
            margin:0 auto;
            overflow:hidden;
            vertical-align:middle;
        }


        /**/
        /* icons */
        /**/
        .ecf-form .icon-prepend {
            position: absolute;
            top: 5px;
            width: 29px;
            height: 29px;
            font-size: 15px;
            line-height: 29px;
            text-align: center;
        }
        .ecf-form .icon-prepend {
            left: 5px;
            padding-right: 3px;
            border-right-width: 1px;
            border-right-style: solid;
        }
        .ecf-form .input .icon-prepend + input,
        .ecf-form .textarea .icon-prepend + textarea {
            padding-left: 46px;
        }
        .ecf-form .input .icon-prepend + .icon-append + input,
        .ecf-form .textarea .icon-prepend + .icon-append + textarea {
            padding-left: 46px;
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
        <div class="col-md-12">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Xin khấn</a></li>
                <li><a data-toggle="tab" href="#menu1">Tạ ơn</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <div id="ecf-form-qcvpeg" class="ecf-body" style=" ">

                        <form method="post" enctype="multipart/form-data" action="http://mhcgdcct.com/xin-khan-duc-me/#"
                              id="form-qcvpeg" class="ecf-form form-qcvpeg" novalidate="novalidate">
                            <header style=" padding: 0px !important;">
                                <div style="text-align:center;margin-left: auto;margin-right: auto;display: block !important; max-width:30%;"
                                     class="ecf-head-img-con"><img class="ecf-header-qcvpeg" src="<c:url value="/resources/img/xinkhan.jpg"/>"
                                                                   style="display: inline;"></div>
                                <span class="ecf-header-title"
                                      style="text-align:center;margin-left: auto;margin-right: auto;display: block;">Khấn Đức Mẹ Hằng Cứu Giúp</span>
                            </header>
                            <fieldset>
                                <section><label class="label">Tên người khấn</label><label class="input"><i
                                        class="icon-prepend fa fa-user"></i><input data-type="name"
                                                                                   data-label="Tên người khấn"
                                                                                   id="name" type="text" name="name0"
                                                                                   class="tooltipstered"></label>
                                </section>
                                <section><label class="label">Email</label><label class="input"><i
                                        class="icon-prepend fa fa-envelope-o"></i><input data-type="email"
                                                                                         data-label="Email" id="email"
                                                                                         type="text" name="email1"
                                                                                         class="tooltipstered"></label>
                                </section>
                                <section><label class="label">Ý khấn:</label><label class="checkbox">
                                    <div class="inline-group"><label class="checkbox"><input
                                            value="1. Xin thêm lòng tin, cậy, mến Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>1. Xin thêm lòng tin, cậy,
                                        mến Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="2. Xin chừa bỏ tội lỗi, tính hư nết xấu. " data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>2. Xin chừa bỏ tội lỗi, tính hư nết xấu.
                                    </label><label class="checkbox"><input
                                            value="3. Xin ơn biết ăn năn trở về cùng Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>3. Xin ơn biết ăn năn trở
                                        về cùng Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="4. Xin ơn bình an trong tâm hồn và trong cuộc sống."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>4. Xin ơn bình an trong
                                        tâm hồn và trong cuộc sống.</label><label class="checkbox"><input
                                            value="5. Xin cho gia đình được hòa thuận, thương yêu nhau."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>5. Xin cho gia đình được
                                        hòa thuận, thương yêu nhau.</label><label class="checkbox"><input
                                            value="6. Xin cho người thân đi xa được trở về." data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>6. Xin cho người thân đi xa được trở
                                        về.</label><label class="checkbox"><input
                                            value="7. Xin ơn hướng dẫn, cứu giúp trong cơn gian nan, khốn khó"
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>7. Xin ơn hướng dẫn, cứu
                                        giúp trong cơn gian nan, khốn khó</label><label class="checkbox"><input
                                            value="8. Xin ơn được biết và vâng theo thánh ý Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>8. Xin ơn được biết và
                                        vâng theo thánh ý Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="9. Xin ơn biết tha thứ, biết hòa giải, biết chu toàn trách nhiệm."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>9. Xin ơn biết tha thứ,
                                        biết hòa giải, biết chu toàn trách nhiệm.</label><label class="checkbox"><input
                                            value="10. Xin ơn bền đỗ, ơn thánh hóa trong ơn nghĩa Chúa."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>10. Xin ơn bền đỗ, ơn
                                        thánh hóa trong ơn nghĩa Chúa.</label><label class="checkbox"><input
                                            value="11. Xin đi đường bình an." data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>11. Xin đi đường bình an.</label><label
                                            class="checkbox"><input
                                            value="12. Xin có công ăn việc làm và thuận lợi trong việc làm ăn."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>12. Xin có công ăn việc
                                        làm và thuận lợi trong việc làm ăn.</label><label class="checkbox"><input
                                            value="13. Xin trả được nợ." data-type="checkboxes" data-label="Ý khấn:"
                                            type="checkbox" name="checkboxesc14" class="tooltipstered"><i></i>13. Xin
                                        trả được nợ.</label><label class="checkbox"><input value="14. Xin đòi được nợ."
                                                                                           data-type="checkboxes"
                                                                                           data-label="Ý khấn:"
                                                                                           type="checkbox"
                                                                                           name="checkboxesc14"
                                                                                           class="tooltipstered"><i></i>14.
                                        Xin đòi được nợ.</label><label class="checkbox"><input
                                            value="15. Xin cho con cái biết vâng lời, chăm ngoan học giỏi và thi cử đỗ đạt."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>15. Xin cho con cái biết
                                        vâng lời, chăm ngoan học giỏi.</label><label class="checkbox"><input
                                            value="16. Xin ơn dâng mình cho Chúa trong đời sống tu trì."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>16. Xin ơn dâng mình cho
                                        Chúa trong đời sống tu trì.</label><label class="checkbox"><input
                                            value="17. Xin ơn chữa lành bệnh tật." data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>17. Xin ơn chữa lành bệnh tật.</label><label
                                            class="checkbox"><input value="18. Xin ơn chết lành." data-type="checkboxes"
                                                                    data-label="Ý khấn:" type="checkbox"
                                                                    name="checkboxesc14" class="tooltipstered"><i></i>18.
                                        Xin ơn chết lành.</label><label class="checkbox"><input
                                            value="19. Xin cầu cho các linh hồn." data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>19. Xin cầu cho các linh hồn.</label><label
                                            class="checkbox"><input
                                            value="20. Xin cho các linh mục, tu sĩ sống thánh thiện."
                                            data-type="checkboxes" data-label="Ý khấn:" type="checkbox"
                                            name="checkboxesc14" class="tooltipstered"><i></i>20. Xin cho các linh mục,
                                        tu sĩ sống thánh thiện.</label><label class="checkbox"><input
                                            value="21. Xin được có con" data-type="checkboxes" data-label="Ý khấn:"
                                            type="checkbox" name="checkboxesc14" class="tooltipstered"><i></i>21. Xin
                                        được có con</label><label class="checkbox"><input
                                            value="22. Xin cho việc sinh nở được bằng an" data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>22. Xin cho việc sinh nở được bằng
                                        an</label><label class="checkbox"><input
                                            value="23. Xin ơn như ý hoặc các ý nguyện khác." data-type="checkboxes"
                                            data-label="Ý khấn:" type="checkbox" name="checkboxesc14"
                                            class="tooltipstered"><i></i>23. Xin ơn như ý hoặc các ý nguyện
                                        khác.</label></div>
                                </label></section>
                                <section><label class="label">Xin những ơn khác:</label><label class="textarea"><i
                                        class="icon-prepend fa fa-comment"></i><textarea data-type="message"
                                                                                         data-label="Xin những ơn khác:"
                                                                                         id="message" name="message3"
                                                                                         rows="5"
                                                                                         class="tooltipstered"></textarea></label>
                                </section>
                            </fieldset>
                            <footer>
                                <button data-style="slide-down" id="cf-submittedqcvpeg" class="ecfbutton ladda-button"
                                        type="submit" name="cf-submittedqcvpeg"><span
                                        class="ladda-label">Gửi đi</span><span class="ladda-spinner"></span></button>
                            </footer>
                        </form>

                    </div>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <div id="ecf-form-fhuabk" class="ecf-body" style=" ">

                        <form method="post" enctype="multipart/form-data" action="http://mhcgdcct.com/xin-khan-duc-me/#"
                              id="form-fhuabk" class="ecf-form form-fhuabk" novalidate="novalidate">
                            <header style=" padding: 0px !important;">
                                <div style="text-align:center;margin-left: auto;margin-right: auto;display: block !important; max-width:30%;"
                                     class="ecf-head-img-con"><img class="ecf-header-qcvpeg" src="<c:url value="/resources/img/xinkhan.jpg"/>"
                                                                   style="display: inline;"></div>
                                <span class="ecf-header-title"
                                      style="text-align:center;margin-left: auto;margin-right: auto;display: block;">Tạ Ơn Đức Mẹ</span>
                            </header>
                            <fieldset>
                                <section><label class="label">Tên</label><label class="input"><i
                                        class="icon-prepend fa fa-user"></i><input data-type="name" data-label="Tên"
                                                                                   id="name0" type="text" name="name0"
                                                                                   class="tooltipstered"></label>
                                </section>
                                <section><label class="label">Email</label><label class="input"><i
                                        class="icon-prepend fa fa-envelope-o"></i><input data-type="email"
                                                                                         data-label="Email" id="email1"
                                                                                         type="text" name="email1"
                                                                                         class="tooltipstered"></label>
                                </section>
                                <section><label class="label">Những ý xin tạ ơn</label><label class="checkbox">
                                    <div class="inline-group"><label class="checkbox"><input
                                            value="1. Tạ ơn vì đã có lòng tin, cậy, mến Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>1. Tạ ơn vì đã có lòng
                                        tin, cậy, mến Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="2. Tạ ơn vì đã chừa bỏ tội lỗi, tính hư nết xấu. "
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>2. Tạ ơn vì đã chừa bỏ tội
                                        lỗi, tính hư nết xấu. </label><label class="checkbox"><input
                                            value="3. Tạ ơn vì đã biết ăn năn trở về cùng Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>3. Tạ ơn vì đã biết ăn năn
                                        trở về cùng Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="4. Tạ ơn vì đã bình an trong tâm hồn và trong cuộc sống."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>4. Tạ ơn vì đã bình an
                                        trong tâm hồn và trong cuộc sống.</label><label class="checkbox"><input
                                            value="5. Tạ ơn vì gia đình đã được hòa thuận, thương yêu nhau."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>5. Tạ ơn vì gia đình đã
                                        được hòa thuận, thương yêu nhau.</label><label class="checkbox"><input
                                            value="6. Tạ ơn vì người thân đi xa đã trở về" data-type="checkboxes"
                                            data-label="Những ý xin tạ ơn" type="checkbox" name="checkboxesc11"
                                            class="tooltipstered"><i></i>6. Tạ ơn vì người thân đi xa đã trở
                                        về</label><label class="checkbox"><input
                                            value="7. Tạ ơn vì đã được hướng dẫn, cứu giúp trong cơn gian nan, khốn khó"
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>7. Tạ ơn vì đã được hướng
                                        dẫn, cứu giúp trong cơn gian nan, khốn khó</label><label class="checkbox"><input
                                            value="8. Tạ ơn vì đã được biết và vâng theo thánh ý Chúa và Đức Mẹ."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>8. Tạ ơn vì đã được biết
                                        và vâng theo thánh ý Chúa và Đức Mẹ.</label><label class="checkbox"><input
                                            value="9. Tạ ơn vì đã biết tha thứ, biết hòa giải, biết chu toàn trách nhiệm."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>9. Tạ ơn vì đã biết tha
                                        thứ, biết hòa giải, biết chu toàn trách nhiệm.</label><label
                                            class="checkbox"><input
                                            value="10. Tạ ơn vì đã được bền đỗ, ơn thánh hóa trong ơn nghĩa Chúa."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>10. Tạ ơn vì đã được bền
                                        đỗ, ơn thánh hóa trong ơn nghĩa Chúa.</label><label class="checkbox"><input
                                            value="11. Tạ ơn vì đã đi đường bình an." data-type="checkboxes"
                                            data-label="Những ý xin tạ ơn" type="checkbox" name="checkboxesc11"
                                            class="tooltipstered"><i></i>11. Tạ ơn vì đã đi đường bình an.</label><label
                                            class="checkbox"><input
                                            value="12. Tạ ơn vì đã có công ăn việc làm và thuận lợi trong việc làm ăn."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>12. Tạ ơn vì đã có công ăn
                                        việc làm và thuận lợi trong việc làm ăn.</label><label class="checkbox"><input
                                            value="13. Tạ ơn vì đã trả được nợ." data-type="checkboxes"
                                            data-label="Những ý xin tạ ơn" type="checkbox" name="checkboxesc11"
                                            class="tooltipstered"><i></i>13. Tạ ơn vì đã trả được nợ.</label><label
                                            class="checkbox"><input value="14. Tạ ơn vì đã đòi được nợ."
                                                                    data-type="checkboxes"
                                                                    data-label="Những ý xin tạ ơn" type="checkbox"
                                                                    name="checkboxesc11" class="tooltipstered"><i></i>14.
                                        Tạ ơn vì đã đòi được nợ.</label><label class="checkbox"><input
                                            value="15. Tạ ơn vì con cái đã biết vâng lời, chăm ngoan học giỏi và thi cử đỗ đạt."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>15. Tạ ơn vì con cái đã
                                        biết vâng lời, chăm ngoan học giỏi và thi cử đỗ đạt.</label><label
                                            class="checkbox"><input
                                            value="16. Tạ ơn vì đã được dâng mình cho Chúa trong đời sống tu trì."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>16. Tạ ơn vì đã được dâng
                                        mình cho Chúa trong đời sống tu trì.</label><label class="checkbox"><input
                                            value="17. Tạ ơn vì đã được chữa lành bệnh tật." data-type="checkboxes"
                                            data-label="Những ý xin tạ ơn" type="checkbox" name="checkboxesc11"
                                            class="tooltipstered"><i></i>17. Tạ ơn vì đã được chữa lành bệnh
                                        tật.</label><label class="checkbox"><input value="18. Tạ ơn vì đã chết lành."
                                                                                   data-type="checkboxes"
                                                                                   data-label="Những ý xin tạ ơn"
                                                                                   type="checkbox" name="checkboxesc11"
                                                                                   class="tooltipstered"><i></i>18. Tạ
                                        ơn vì đã chết lành.</label><label class="checkbox"><input
                                            value="19. Tạ ơn vì đã cho các linh mục, tu sĩ sống thánh thiện."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>19. Tạ ơn vì đã cho các
                                        linh mục, tu sĩ sống thánh thiện.</label><label class="checkbox"><input
                                            value="20. Tạ ơn vì đã được có con" data-type="checkboxes"
                                            data-label="Những ý xin tạ ơn" type="checkbox" name="checkboxesc11"
                                            class="tooltipstered"><i></i>20. Tạ ơn vì đã được có con</label><label
                                            class="checkbox"><input value="21. Tạ ơn vì đã sinh nở được bằng an"
                                                                    data-type="checkboxes"
                                                                    data-label="Những ý xin tạ ơn" type="checkbox"
                                                                    name="checkboxesc11" class="tooltipstered"><i></i>21.
                                        Tạ ơn vì đã sinh nở được bằng an</label><label class="checkbox"><input
                                            value="22. Tạ ơn vì đã được như ý hoặc các ý nguyện khác."
                                            data-type="checkboxes" data-label="Những ý xin tạ ơn" type="checkbox"
                                            name="checkboxesc11" class="tooltipstered"><i></i>22. Tạ ơn vì đã được như ý
                                        hoặc các ý nguyện khác.</label></div>
                                </label></section>
                                <section><label class="label">Xin tạ ơn</label><label class="textarea"><i
                                        class="icon-prepend fa fa-comment"></i><textarea data-type="message"
                                                                                         data-label="Xin tạ ơn"
                                                                                         id="message3" name="message3"
                                                                                         rows="5"
                                                                                         class="tooltipstered"></textarea></label>
                                </section>
                            </fieldset>
                            <footer>
                                <button data-style="slide-down" id="cf-submittedfhuabk" class="ecfbutton ladda-button"
                                        type="submit" name="cf-submittedfhuabk"><span
                                        class="ladda-label">Gửi đi</span><span class="ladda-spinner"></span></button>
                            </footer>
                        </form>


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