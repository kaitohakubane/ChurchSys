/**
 * Created by Mr Kiet on 06/30/17.
 */
//URL
var UPDATE_EVENT_URL = "/manager/event/Update";
var LOAD_CONDUCTOR = "/manager/event/load-conductor";
var LOAD_ROOM = "/manager/event/load-room";
var UPDATED_SINGLE_EVENT = "/manager/event/update-single-event";
var UPDATED_REPEAT_EVENT = "/manager/event/update-repeat-event";
var SCHEDULE_URL = "/manager/schedule";
var CHECK_IS_MANY_SLOT = "/manager/event/check-is-many-slot";

var SUCCESS_STATUS = "Cập nhật thành công!";
var FAILURE_STATUS = "Cập nhật thất bại";
var TYPE_DANGER = "danger";
var TYPE_SUCCESS = "success";
//Global variable
var event;
var currentEventIsMultiSlot;
var selectedDate;
$(document).ready(function () {
    Initial();
    $("#slotDate").datepicker();
    $("#slotDate").datepicker('option', 'dateFormat', 'yy-mm-dd');
    inputEditEventInformation();

})


$("#btnBack").on("click", function () {
    // window.location.href = contextPath + SCHEDULE_URL;
    onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
})

// $("#btnSave").on("click", function updateEvent(e) {
//     e.preventDefault();
//     console.log(currentEventIsMultiSlot);
//     if (currentEventIsMultiSlot == 1) {
//         $('#confirmModal').modal('show');
//     }
//     else if (currentEventIsMultiSlot == 0) {
//         updateSingleEvent();
//     }
// })

$("#oneSlot").on("click", function () {
    updateSingleEvent();
})
$("#manySlot").on("click", function () {
    updateRepeatEvent();
})

function inputEditEventInformation() {
    console.log(slotDate)
    $("#startTime").val(startTime);
    $("#endTime").val(endTime);
    $("#slotDate").val(slotDate);
    $("#manySlotCheck").hide();
    if (privacy == "false") {
        console.log('Click')
        if ($("#editEventIsChecked").prop('checked')) {
            console.log($("#editEventIsChecked").prop('checked'));
            $("#editEventIsChecked").click();

        }
    } else {
        console.log('CLick false')
        if (!$("#editEventIsChecked").prop('checked')) {
            $("#editEventIsChecked").click();
            console.log('Click')
        }
    }
    loadEventConductor($("#startTime").val(), $("#endTime").val(), slotDate);
    loadEventRoom($("#startTime").val(), $("#endTime").val(), slotDate);
    checkIsManySlot();
}

function loadEventConductor(startTime, endTime, slotDate) {

    var requestURL = contextPath + LOAD_CONDUCTOR;
    var requestMethod = "POST";
    var requestData = {
        "slotId": $("#txtTitle").data("id"),
        "startTime": startTime,
        "endTime": endTime,
        "slotDate": slotDate,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        dataType: 'json',
        success: function (res) {
            console.log("Ajax get conductor list run")
            conductorList = res;
            $("#assigned option").remove();
            $.each(conductorList, function (e, item) {

                $('#assigned').append($('<option>', {
                    value: item.userId,
                    text: item.userName,
                }));

            })
            $("#assigned").val(conductorList[conductorList.length - 1].userId)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function loadEventRoom(startTime, endTime, slotDate) {
    var requestURL = contextPath + LOAD_ROOM;
    var requestMethod = "POST";
    var requestData = {
        "slotId": $("#txtTitle").data("id"),
        "startTime": startTime,
        "endTime": endTime,
        "slotDate": slotDate,
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        // async: false,
        dataType: 'json',
        success: function (res) {
            console.log("Ajax get room list run")
            roomList = res;
            $("#room option").remove();
            $.each(roomList, function (e, item) {
                $('#room').append($('<option>', {
                    value: item.roomId,
                    text: item.roomName
                }))
            })
            $("#room").val(roomList[roomList.length - 1].roomId)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function Initial() {
    $("#hiding-form").hide();

    $("input:radio[name=repeat]").on('ifChanged', function () {
        var selectedValue = $(this).val();
        if (selectedValue == "showForm") {
            $("#hiding-form").show();
        }
        else if (selectedValue == "hideForm") {
            $("#hiding-form").hide();
        }
    });

    $('#option-select').on('change', function () {
        var selected = $('#option-select option:selected');
        if (selected.length > 0) {
            var result = '';
            selected.each(function () {
                result += $(this).val();
            });
            $('#option-result').html(result);
        }
    });

    $("#week-selected").hide();
    $("#month-selected").hide();

    $('#option-select').on('change', function () {
        var selected = $(this).val();
        if (selected == "days") {
            $("#week-selected").hide();
            $("#month-selected").hide();
        }
        else if (selected == "weeks") {
            $("#week-selected").show();
            $("#month-selected").hide();
        }
        else if (selected == "months") {
            $("#week-selected").hide();
            $("#month-selected").show();
        }
        else if (selected == "years") {
            $("#week-selected").hide();
            $("#month-selected").hide();
        }
    });

}

function checkIsManySlot() {
    var requestURL = contextPath + CHECK_IS_MANY_SLOT;
    var requestMethod = "POST";
    var requestData = {
        slotId: $("#txtTitle").data("id")
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            console.log("Checking slot with ID = " + $("#txtTitle").data("id") + " is one or many slot!");
            currentEventIsMultiSlot = res;
            if (currentEventIsMultiSlot == 1) {
                console.log("Current event is many slot");
            } else if (currentEventIsMultiSlot == 0) {
                console.log("Current event is one slot");
            } else {
                console.log("Error happen!");
            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}

function updateSingleEvent() {
    var requestURL = contextPath + UPDATED_SINGLE_EVENT;
    var requestMethod = "POST";
    var isPublic = $("#editEventIsChecked").prop('checked');
    console.log(isPublic);
    var privacy;
    if (isPublic) {
        privacy = 1
    }
    else {
        privacy = 0
    }
    console.log()

    var requestData = {
        slotId: $("#txtTitle").data("id"),
        slotHour: $("#startTime").children(":selected").attr("id") + ',' + $("#endTime").children(":selected").attr("id"),
        slotDate: $("#slotDate").val(),
        eventName: $("#txtTitle").val(),
        conductorId: $("#assigned").val(),
        roomId: $("#room").val(),
        privacy: privacy,
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        success: function () {
            $('#confirmModal').modal('hide');
            onClickShowPopup(SUCCESS_STATUS, TYPE_SUCCESS);

            // var slotId = $("#txtTitle").data("id");
            // var parameter = {
            //     slotId: slotId
            // }
            // post(contextPath + UPDATE_EVENT_URL, parameter);

        },
        error: function (jqXHR, textStatus, errorThrown) {
            onClickShowPopup(FAILURE_STATUS, TYPE_DANGER);
            console.error(textStatus);
        }
    })

}

function updateRepeatEvent() {
    var requestURL = contextPath + UPDATED_REPEAT_EVENT;
    var requestMethod = "POST";
    var isPublic = $("#editEventIsChecked").prop('checked');
    console.log(isPublic);
    var privacy;
    if (isPublic) {
        privacy = 1
    }
    else {
        privacy = 0
    }
    console.log()

    var requestData = {
        slotId: $("#txtTitle").data("id"),
        slotHour: $("#startTime").children(":selected").attr("id") + ',' + $("#endTime").children(":selected").attr("id"),
        eventName: $("#txtTitle").val(),
        conductorId: $("#assigned").val(),
        roomId: $("#room").val(),
        privacy: privacy,
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        success: function () {
            var slotId = $("#txtTitle").data("id");
            var parameter = {
                slotId: slotId
            }
            post(contextPath + UPDATE_EVENT_URL, parameter);
            alert("Update success!");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
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

$("#startTime").on("change", function () {
    $("#editForm").validate()
})

$("#endTime").on("change", function () {
    $("#editForm").validate()
})
$("#slotDate").validate();

var checkTime = function (startTime, endTime) {
    var sTime = new Date(startTime);
    var eTime = new Date(endTime);

    if (eTime < sTime) {
        return true
    }
}


jQuery.validator.addMethod("checkTime", function (value, element) {

    return checkTime($('#startTime').val(), $("#endTime").val());
}, "Thời gian bắt đầu phải sớm hơn thời gian kết thúc");


$("#slotDate").validate({
    rules: {
        // startTime: {
        //     checkTime: true
        // },
        // endTime: {
        //     checkTime: true
        // },
        slotDate: {isAfterCurrentDate: true}
    },
    messages: {
        // startTime: "Thời gian bắt đầu phải sớm hơn thời gian kết thúc",
        // endTime: "Thời gian kết thúc phải sau thời gian bắt đầu",
        slotDate: "Phải sau ngày hiện tại"
    }
})

$

var isAfterCurrentDate = function () {
    var curDate = new Date();
    console.log(curDate)
    selectedDate = new Date($("#slotDate").val());
    console.log(selectedDate)
    console.log(selectedDate > curDate)
    return selectedDate > curDate

};
jQuery.validator.addMethod("isAfterCurrentDate", function () {
    return isAfterCurrentDate();
});

