<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/19/2017
  Time: 8:55 PM
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
    <title>Edit Event</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
    <!-- iCheck -->
    <link href="<c:url value="/resources/lib/vendors/iCheck/skins/flat/green.css"/>" rel="stylesheet">
    <!-- Switchery -->
    <link href="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Edit Event Page</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-6 col-xs-12 col-md-offset-3">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Event Detail</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <form class="form-horizontal form-label-left input_mask">

                                    <div class="form-group">
                                        <div class="col-md-11">
                                            <input type="text" class="form-control" placeholder="Event title">
                                        </div>
                                    </div>

                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group has-feedback">
                                        <input type="date" class="form-control has-feedback-left"">
                                        <span class="fa fa-calendar form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-1 col-sm-1 col-xs-12">
                                        <h4>to</h4>
                                    </div>

                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group has-feedback">
                                        <input type="date" class="form-control">
                                        <span class="fa fa-calendar form-control-feedback right"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Subject:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select class="form-control">
                                                <option>Choose option</option>
                                                <option>Option one</option>
                                                <option>Option two</option>
                                                <option>Option three</option>
                                                <option>Option four</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label class="col-md-3">
                                            <input value="hideForm" type="radio" class="flat" checked name="repeat"> No
                                            repeat
                                        </label>
                                        <label class="col-md-3">
                                            <input value="showForm" type="radio" class="flat" name="repeat"> Repeat
                                        </label>
                                    </div>

                                    <!-- Hide Repeat Oncheck -->
                                    <div id="hiding-form">
                                        <div class="clearfix"></div>
                                        <div class="ln_solid"></div>

                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Repeats:</label>
                                            <div class="col-md-9 col-sm-9 col-xs-12">
                                                <select class="form-control">
                                                    <option>Choose option</option>
                                                    <option>Daily</option>
                                                    <option>Weekly</option>
                                                    <option>Monthly</option>
                                                    <option>Yearly</option>
                                                    <option>Every Mon,Wed,Fri</option>
                                                    <option>Every Tue,Thu,Sat</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Repeat
                                                every:</label>
                                            <div class="col-md-2 col-sm-2 col-xs-12">
                                                <select class="form-control">
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                    <option>7</option>
                                                    <option>8</option>
                                                    <option>9</option>
                                                    <option>10</option>
                                                    <option>11</option>
                                                    <option>12</option>
                                                    <option>13</option>
                                                    <option>14</option>
                                                    <option>15</option>
                                                    <option>16</option>
                                                    <option>17</option>
                                                    <option>18</option>
                                                    <option>19</option>
                                                    <option>20</option>
                                                    <option>21</option>
                                                    <option>22</option>
                                                    <option>23</option>
                                                    <option>24</option>
                                                    <option>25</option>
                                                    <option>26</option>
                                                    <option>27</option>
                                                    <option>28</option>
                                                    <option>29</option>
                                                    <option>30</option>
                                                </select>
                                            </div>
                                            <label class="control-label col-md-4 col-sm-4 col-xs-12">Day-Week-Month-Year</label>
                                        </div>

                                        <div class="col-md-12 form-group">
                                            <label class="control-label col-md-2 col-sm-2 col-xs-12">On:</label>
                                            <label class="control-label">
                                                <input type="checkbox" class="flat"> Mon
                                            </label>
                                            <label>
                                                <input type="checkbox" class="flat"> Tue
                                            </label>
                                            <label>
                                                <input type="checkbox" class="flat"> Wed
                                                <label>
                                                    <input type="checkbox" class="flat"> Thus
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> Fri
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> Sat
                                                </label>
                                                <label>
                                                    <input type="checkbox" class="flat"> Sun
                                                </label>
                                        </div>
                                        <div class="clearfix"></div>

                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-sm-2 col-xs-12">Star:</label>
                                            <div class="col-md-9 col-sm-9 col-xs-12">
                                                <input type="date" class="form-control" disabled="readonly">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-2 col-sm-2 col-xs-12">End:</label>
                                            <label class="control-label col-md-2">
                                                <input type="radio" class="flat" checked name="end"> Never
                                            </label>

                                            <label class="control-label col-md-2">
                                                <input type="radio" class="flat" name="end"> After
                                                <label class="control-label">
                                                    <input type="text" class="form-control col-md-offset-7"> times
                                                </label>
                                            </label>

                                        </div>

                                        <div class="ln_solid"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <!-- End Hide Repeat Oncheck -->

                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Assigned:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select class="form-control">
                                                <option>Choose option</option>
                                                <option>Option one</option>
                                                <option>Option two</option>
                                                <option>Option three</option>
                                                <option>Option four</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Room:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select class="form-control">
                                                <option>Choose option</option>
                                                <option>Option one</option>
                                                <option>Option two</option>
                                                <option>Option three</option>
                                                <option>Option four</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Status:</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <select class="form-control">
                                                <option>Choose option</option>
                                                <option>Option one</option>
                                                <option>Option two</option>
                                                <option>Option three</option>
                                                <option>Option four</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-12 form-group">
                                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Public</label>
                                        <label class="control-label">
                                            <input type="checkbox" class="js-switch" checked/>
                                        </label>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="ln_solid"></div>
                                    <div class="form-group">
                                        <div class="col-md-8 col-sm-8 col-xs-12 col-md-offset-4">
                                            <button type="button" class="btn btn-default btn-lg">Back</button>
                                            <button type="submit" class="btn btn-success btn-lg">Save</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>

<c:import url="/resources/layouts/common/footer.jsp"/>

<!-- iCheck -->
<script src="<c:url value="/resources/lib/vendors/iCheck/icheck.min.js"/>"></script>
<!-- Switchery -->
<script src="<c:url value="/resources/lib/vendors/switchery/dist/switchery.min.js"/>"></script>

<script>
    $("#hiding-form").hide();

    $("input:radio[name=repeat]").on('ifChanged', function () {
        var selectedValue = $(this).val();
        console.log(selectedValue);
        if (selectedValue == "showForm") {
            $("#hiding-form").show();
        }
        else if (selectedValue == "hideForm") {
            $("#hiding-form").hide();
        }
    });
</script>

</body>
</html>
