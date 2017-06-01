<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 6/1/2017
  Time: 3:42 PM
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
    <title>Registration Page</title>

    <!-- Datatables -->
    <link href="<c:url value="/resources/lib/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">

</head>
<body class="nav-md">
<!-- page content -->
<div class="right_col" role="main">
    <div class="page-title">
        <div class="title_left">
            <h3>Users
                <small>Some examples to get you started</small>
            </h3>
        </div>
    </div>
    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>Registration</h2>
                    <div class="pull-right">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createEvent">
                            Create Event
                        </button>
                        <button type="button" class="btn btn-primary">Reject</button>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <table id="datatable" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>1</th>
                            <th>2</th>
                            <th>3</th>
                            <th>4</th>
                            <th>5</th>
                            <th>6</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                            <td>6</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                            <td>6</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                            <td>6</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
<!-- popup -->
<div id="createEvent" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create New Event</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Form Event</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br/>
                            <form class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Subject</label>
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
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Date</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <div>
                                            <input type='date' class="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Slot</label>
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
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Number of slot</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" placeholder="Please input number">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Room</label>
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
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Manager</label>
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
                                <!-- <div class="form-group">
                                  <label class="control-label col-md-3 col-sm-3 col-xs-12">Exam Date</label>
                                  <div class="col-md-9 col-sm-9 col-xs-12">
                                        <div class='input-group date' id='date2'>
                                          <input type='text' class="form-control" />
                                          <span class="input-group-addon">
                                              <span class="glyphicon glyphicon-calendar"></span>
                                          </span>
                                      </div>
                                  </div>
                                </div> -->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Exam Date</label>
                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <div>
                                            <input type='date' class="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Type</label>
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
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Create</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            </div>
        </div>
        <!-- /Modal content-->
    </div>
</div>
<!-- /popup -->

<!-- Datatables -->
<script src="<c:url value="/resources/lib/vendors/datatables.net/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/lib/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/registration.js"/>"></script>

</body>
</html>
