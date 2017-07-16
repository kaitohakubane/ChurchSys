<%--
  Created by IntelliJ IDEA.
  User: hungmcse61561-admin
  Date: 5/31/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
    <c:import url="/resources/layouts/common/header.jsp"/>
    <link href="<c:url value="/resources/lib/sematicDist/semantic.min.css"/>" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <c:import url="/resources/layouts/common/menu.jsp"/>
        <%--Content    --%>
        <div class="right_col" role="main">
            <button data-toggle="modal" data-target="#roomPopup"></button>
        </div>
        <%--Content end--%>
        <c:import url="/resources/layouts/common/page-footer.jsp"/>
    </div>
</div>
<!-- popup -->
<div id="userPopup" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Form 1</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content form-horizontal form-label-left">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Username:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Account ID:<span
                                        class="required">*</span></label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span
                                        class="required">*</span></label>
                                <div class="col-md-9 col-sm-6 col-xs-12">
                                    <input required="required" class="form-control col-md-7 col-xs-12" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Phone:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Cert:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Subject:</label>
                                <div class="col-md-9 col-sm-3 col-xs-12">
                                    <select class="form-control">
                                        <option>Choose option</option>
                                        <option>Option one</option>
                                        <option>Option two</option>
                                        <option>Option three</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-9 col-sm-3 col-xs-12 col-md-offset-3">
                                    <select multiple="" class="ui fluid dropdown" id="test2">
                                        <option value="">Skills</option>
                                        <option value="angular">Angular</option>
                                        <option value="css">CSS</option>
                                        <option value="design">Graphic Design</option>
                                        <option value="ember">Ember</option>
                                        <option value="html">HTML</option>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">OK</button>
            </div>
        </div>
        <!-- /Modal content -->
    </div>
</div>
<!-- /popup -->

<!-- popup -->
<div id="roomPopup" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content -->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Form 2</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="x_panel">
                        <div class="x_content form-horizontal form-label-left">
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Room:</label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <input type="text" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Subject:</label>
                                <div class="col-md-9 col-sm-3 col-xs-12">
                                    <select class="form-control">
                                        <option>Choose option</option>
                                        <option>Option one</option>
                                        <option>Option two</option>
                                        <option>Option three</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-9 col-sm-3 col-xs-12 col-md-offset-3">
                                    <select multiple="" class="ui fluid dropdown" id="roomDropdown">
                                        <option value="">Skills</option>
                                        <option value="angular">Angular</option>
                                        <option value="css">CSS</option>
                                        <option value="design">Graphic Design</option>
                                        <option value="ember">Ember</option>
                                        <option value="html">HTML</option>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">OK</button>
            </div>
        </div>
        <!-- /Modal content -->
    </div>
</div>
<!-- /popup -->


<c:import url="/resources/layouts/common/footer.jsp"/>
<script src="<c:url value="/resources/js/test.js"/>"></script>
<script src="<c:url value="/resources/lib/sematicDist/semantic.min.js"/>"></script>

</body>
</html>
