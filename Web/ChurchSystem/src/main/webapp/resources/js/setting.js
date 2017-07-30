var UPDATE_CHURCH_URL = "/admin/setting/update-church";
var SUCCESS_STATUS = "Cập nhật thành công!";
var FAILURE_STATUS = "Cập nhật thất bại!";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";
$(document).ready(function () {

})


$("#btnSave").on("click", function () {
    updateChurch();
})

function updateChurch() {
    var requestURL = contextPath + UPDATE_CHURCH_URL;
    var requestMethod = "POST";


    var requestData = {
        'churchName': $("#churchName").val(),
        'tel': $("#churchTel").val(),
        'address': $("#churchAddress").val(),
        'mail': $("#churchEmail").val(),
        'description': $("#churchDescription").val(),
    }

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
