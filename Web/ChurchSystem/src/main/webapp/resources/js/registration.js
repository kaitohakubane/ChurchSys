var SCHEDULE_URL = "/admin/schedule";
var ADD_CHURCH_URL = "/admin/new-church";
var ACCEPT_EVENT_REGISTRATION_URL = "/manager/registration-management/event-accept";
var REJECT_EVENT_REGISTRATION_URL = "/manager/registration-management/event-reject";
var ACCEPT_CLASS_REGISTRATION_URL = "/manager/registration-management/class-accept";
var REJECT_CLASS_REGISTRATION_URL = "/manager/registration-management/class-reject";
var SUCCESS_STATUS = "Cập nhật thành công!";
var FAILURE_STATUS = "Cập nhật thất bại!";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";


$(document).ready(function () {
    $('#event_datatable').DataTable(
    );
    $('#class_datatable').DataTable(
    );
})

function popupInitial() {
    $("#room").prop("disabled", true);
    $("#manager").prop("disabled", true);
    $("#manager").disabled = true;
    $("#slot").on('change', function () {
        $("#room").prop("disabled", false);
        $("#manager").prop("disabled", false);
    })
    $("#confirm-btn").on("click", function () {
        window.location.href = contextPath + SCHEDULE_URL;
    })

    $("#addChurch").on("click", function () {
        window.location.href = contextPath + ADD_CHURCH_URL;
    })
}

$(".event-approve").on("click", function () {
    var regisId = $(this).data("id");
    acceptEventRegistration(regisId);
})
$(".event-reject").on("click", function () {
    var regisId = $(this).data("id");
    rejectEventRegistration(regisId);
})

$(".class-approve").on("click", function () {
    var regisId = $(this).data("id");
    acceptClassRegistration(regisId);
})
$(".class-reject").on("click", function () {
    var regisId = $(this).data("id");
    rejectClassRegistration(regisId);
})

function acceptEventRegistration(regisId) {
    var requestURL = contextPath + ACCEPT_EVENT_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "regisId": regisId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function rejectEventRegistration(regisId) {
    var requestURL = contextPath + REJECT_EVENT_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "regisId": regisId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function acceptClassRegistration(regisId) {
    var requestURL = contextPath + ACCEPT_CLASS_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "regisId": regisId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}

function rejectClassRegistration(regisId) {
    var requestURL = contextPath + REJECT_CLASS_REGISTRATION_URL;
    var requestMethod = "POST";
    var requestData = {
        "regisId": regisId
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })
}