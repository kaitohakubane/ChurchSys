/**
 * Created by hungmcse61561-admin on 8/5/2017.
 */
var ADD_CHURCH_URL = "/admin/new-church";
var ASSIGN_MANAGER_URL = "/admin/assign-manager";

//notify
var SUCCESS_STATUS = "Thành công!";
var FAILURE_STATUS = "Thất bại";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";
$(document).ready(function(){
    $("#addChurch").on("click", function () {
        window.location.href = contextPath + ADD_CHURCH_URL;
    })

    $(".assign-manager").on('click',function () {
        $("#btnOk").data("id",$(this).data("id"))
    })
})


$("#btnOk").on("click", function () {
    var churchId = $(this).data("id");
    console.log(churchId);
    assignManager(churchId);
})



function assignManager(churchId) {
    var requestURL = contextPath + ASSIGN_MANAGER_URL;
    var requestMethod = "POST";
    var requestData = {
        "churchId": churchId,
        "userName" : $("#userName").val(),
        "accountId" : $("#accountId").val(),
        "email" : $("#email").val(),
        "phone" : $("#phone").val(),
        "cert" : $("#cert").val(),
    }
console.lo
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            console.log("Đăng ký thành công!");
            // alert("Đăng ký thành công!")
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Đăng ký thất bại!");
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    });
}