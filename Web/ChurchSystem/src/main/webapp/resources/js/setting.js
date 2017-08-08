var UPDATE_CHURCH_URL = "/admin/setting/update-church";
var SUCCESS_STATUS = "Cập nhật thành công!";
var FAILURE_STATUS = "Cập nhật thất bại!";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";
$(document).ready(function () {
    generalInitial()
})


function generalInitial(){
    var theme = $("#theme");
    var image = $("#theme-picture");
    if (theme.data('color') == 0) {
        theme.css('background-color', "#7ab33e")
        theme.css('border-color', "#7ab33e")
        image.attr("src", contextPath + "/resources/img/theme-0.PNG");
        $("#green-theme").iCheck('check');
    } else if (theme.data('color') == 1) {
        theme.css('background-color', "#400f67")
        image.attr("src", contextPath + "/resources/img/theme-1.PNG");
        theme.css('border-color', "#400f67")
        $("#purple-theme").iCheck('check');
    } else if (theme.data('color') == 2) {
        theme.css('background-color', "#ff1744")
        theme.css('border-color', "#ff1744")
        $("#pink-theme").iCheck('check');
    }


    $("input[name=theme-color]").on("ifChanged", function () {
        var checked = $('input[name=theme-color]:checked');
        if (checked.val() == 0) {
            image.attr("src", contextPath + "/resources/img/theme-0.PNG");
        } else if (checked.val() == 1) {
            image.attr("src", contextPath + "/resources/img/theme-1.PNG");
        }
    })


    $("#processBtn").on("click", function () {
        var color = $('input[name=theme-color]:checked').val()
        var theme = $("#theme");
        if (color == 0) {
            theme.css('background-color', "#7ab33e")
            theme.css('border-color', "#7ab33e")
            theme.data('color', '0')
        } else if (color == 1) {
            theme.css('background-color', "#400f67")
            theme.css('border-color', "#400f67")
            theme.data('color', '1')
        } else if (color == 2) {
            theme.css('background-color', "#ff1744")
            theme.css('border-color', "#ff1744")
            theme.data('color', '2');
        }
        $("#theme-modal").modal('hide');
    })
}

$("#btnSave").on("click", function () {
    updateChurch();
})

function updateChurch() {
    var isClick = $("#isSync").prop('checked');
    console.log(isClick);
    var isSync;
    if (isClick) {
        isSync = 1
    }
    else {
        isSync = 0
    }

    var requestURL = contextPath + UPDATE_CHURCH_URL;
    var requestMethod = "POST";

    var requestData = {
        'churchName': $("#churchName").val(),
        'tel': $("#churchTel").val(),
        'address': $("#churchAddress").val(),
        'mail': $("#churchEmail").val(),
        'description': $("#churchDescription").val(),
        'isSync': isSync,
        'theme': $("#theme").data('color')
    }
    console.log(requestData);
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })

}

function onClickShowPopup(mes, type) {

    $.notify({
        // options
        message: mes
    }, {
        // settings
        element: 'body',
        position: null,
        type: type,
        allow_dismiss: false,
        newest_on_top: false,
        showProgressbar: false,
        placement: {
            from: "bottom",
            align: "center"
        },
        offset: 50,
        spacing: 10,
        z_index: 1031,
        delay: 1000,
        mouse_over: null,
        animate: {
            enter: 'animated fadeInDown',
            exit: 'animated fadeOutUp'
        },
        template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
        '<img data-notify="icon" class="img-circle pull-left">' +
        '<span data-notify="title">{1}</span>' +
        '<span data-notify="message">{2}</span>' +
        '</div>'
    });
}
