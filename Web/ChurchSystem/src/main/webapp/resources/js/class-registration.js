/**
 * Created by hungmcse61561-admin on 7/7/2017.
 */
var PREDEFINED_CLASS_REGISTRATION = "/user/registration/PredefinedClass";


//notify
var REGISTER_SUCCESS_STATUS = "Đăng ký thành công!";
var REGISTER_FAILURE_STATUS = "Đăng ký thất bại";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";


$(document).ready(function () {
    $(".dayOfWeek").each(function () {
        console.log($(this).val())
        var listOfDay = $(this).val().split(",");
        console.log(listOfDay)
        var result = "";
        for (var i = 0; i < listOfDay.length; i++) {
            result = result + "T" + listOfDay[i] + " - ";

        }
        console.log(result);
        result = result.substring(0, result.length - 3);
        console.log(result);
        $(this).val(result)
    })

    $(".class-registration").on("click", function () {
        var eventId = $(this).data("id");
        registerForClass(eventId);
        $(this).html("Đã đăng ký!");
        $(this).attr('disabled', true);
    })

})

function registerForClass(eventId) {
    var requestURL = contextPath + PREDEFINED_CLASS_REGISTRATION;
    var requestMethod = "POST";
    var requestData = {
        "eventId": eventId
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        dataType: 'json',
        success: function (res) {
            console.log("Đăng ký thành công!");
            // alert("Đăng ký thành công!")
            onClickShowPopup(REGISTER_SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Đăng ký thất bại!");
            onClickShowPopup(REGISTER_FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    });
}