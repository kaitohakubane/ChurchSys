<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 9/5/2017
  Time: 10:36 AM
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
    <title>Lesson Page</title>
    <c:import url="/resources/layouts/user-common/header.jsp"/>

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
        <div class="col-md-4">
            <div class="list-heading-lesson">
                <p>Danh sách bài học</p>
            </div>
            <div class="lesson-list">
                <ul class="nav nav-list">
                    <li class="subject-name"><label class="tree-toggle nav-header"><i class="fa fa-th-list" aria-hidden="true"></i> Giáo lý dự tòng</label>
                        <ul class="nav nav-list tree">
                            <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i> Link</a></li>
                            <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i> Link</a></li>
                        </ul>
                    </li>
                    <li class="subject-name"><label class="tree-toggle nav-header"><i class="fa fa-th-list" aria-hidden="true"></i> Giáo lý dự trưởng</label>
                        <ul class="nav nav-list tree">
                            <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i> Link</a></li>
                            <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i> Link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="list-bottom">
            </div>
        </div>

        <div class="col-md-8">
            <div class="lesson">
                <div class="lesson-name">
                    <p>Bài 1 - Bài học về đạo lý</p>
                </div>
                <div class="lesson-content">
                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maiores ipsum deleniti, saepe voluptatum possimus eos veniam. Expedita quam placeat officia, quis obcaecati voluptatem error odit ipsa provident dignissimos voluptas harum facere molestiae eaque in animi magni quaerat fuga rerum nisi at repudiandae. Corporis ratione quasi quod, quam rerum, molestiae voluptatem porro explicabo mollitia ad totam sapiente? Cum vero veritatis non maiores enim, dolor fugit ipsam omnis reprehenderit alias eos, deleniti corporis aut architecto velit optio facilis eius quidem! Officiis sequi nulla est laudantium consequatur consequuntur quibusdam nihil, vitae, aut culpa! Perferendis libero autem necessitatibus ullam veritatis nihil quod error saepe tempore, similique, voluptas quasi quae reiciendis, unde eaque officia accusantium dolore dolorum minima veniam laboriosam ipsum enim maxime! Tempore necessitatibus corporis voluptatem, facere facilis vitae minima magni qui, quibusdam porro nostrum voluptates illum atque assumenda commodi vel quaerat similique amet! Culpa, eius, ut. Eligendi aliquid, similique numquam tenetur libero accusantium nihil iste aperiam repudiandae perferendis ipsa explicabo earum animi facilis eos non obcaecati illum maxime nemo consequatur aliquam odit fuga eum minus. Exercitationem minima debitis obcaecati id commodi quam quaerat aliquid atque quod voluptas enim, ex amet pariatur laudantium dolorum numquam eligendi eum dolores ea sit magnam deleniti repudiandae libero. Deserunt voluptate sequi animi, suscipit ipsa dignissimos repellat doloremque praesentium! Sunt veritatis suscipit quisquam dolores vel illum dignissimos pariatur nostrum soluta, quae cumque iste non a ea quidem rerum nemo expedita dolor dolorem voluptate. Eveniet quisquam maxime assumenda, facilis cumque, nobis quidem veniam ipsam ad, dolorum autem nisi inventore voluptas nulla harum, ut placeat aspernatur ipsum voluptatem velit! Odio expedita recusandae iure dicta, suscipit obcaecati nemo, voluptas consequatur cupiditate reiciendis aperiam id, ex unde deserunt rerum dignissimos quasi tempore labore libero earum voluptatum iste quas sunt! Sed, doloribus quas ut nulla nihil vero odit repellat quibusdam harum minus ea hic consequuntur error est, facilis dolore, commodi sint repudiandae asperiores quae deleniti minima distinctio! Qui ab itaque, exercitationem tempore. Eligendi adipisci deserunt, ducimus modi repellendus voluptatibus quam praesentium voluptatum inventore maxime voluptates, molestias, quibusdam voluptate veniam aspernatur harum qui odit natus, alias accusantium quasi. Aliquid quos eligendi voluptate possimus facere. Itaque.</span>
                </div>
                <div class="list-bottom">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end page content -->
<c:import url="/resources/layouts/user-common/user-footer.jsp"/>

<c:import url="/resources/layouts/user-common/footer.jsp"/>

<script src="<c:url value="/resources/js/church.js"/>"></script>

<script src="<c:url value="/resources/js/lesson.js"/>"></script>
</body>
</html>
