/**
 * Created by Mr Kiet on 06/30/17.
 */
//URL
var UPDATE_EVENT_URL = "/manager/event/Update";
var LOAD_CONDUCTOR = "/manager/event/load-conductor";
var LOAD_ROOM = "/manager/event/load-room";
var UPDATED_EVENT = "/manager/event/Updated";
var SCHEDULE_URL = "/manager/schedule";
//Global variable
var event;
$(document).ready(function () {
    Initial();
    $("#slotDate").datepicker();
    $("#slotDate").datepicker('option', 'dateFormat', 'yy-mm-dd');
    inputEditEventInformation();
})


$("#startTime").on('change', function () {
        console.log("startTime change")
        if ($("#startTime").val() >= $("#endTime").val()) {

        } else {
            console.log("run")
            loadEventConductor($("#startTime").val(), $("#endTime").val());
            loadEventRoom($("#startTime").val(), $("#endTime").val());
        }
    }
)

$("#endTime").on('change', function () {
        console.log("endTime change")
        if ($("#endTime").val() <= $("#startTime").val()) {

        } else {
            console.log("run")

            loadEventConductor($("#startTime").val(), $("#endTime").val());
            loadEventRoom($("#startTime").val(), $("#endTime").val());
        }
    }
)

$("#slotDate").on('change', function (){
    console.log("Date is changed!")
    var currentDate = new Date(year,month,day)
    if($("#slotDate").val()<currentDate.getDate()){
        console.log("lỗi");
    }else{
        console.log("Not lỗi");
        loadEventConductor($("#startTime").val(), $("#endTime").val());
        loadEventRoom($("#startTime").val(), $("#endTime").val());
    }
})


$("#btnSave").on("click", function updateEvent(e) {
    e.preventDefault();
    var requestURL = contextPath + UPDATED_EVENT;
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
            var slotId=$("#txtTitle").data("id");
            var parameter = {
                slotId: slotId
            }
            post(contextPath + UPDATE_EVENT_URL, parameter);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
})


function inputEditEventInformation() {
    console.log(slotDate)
    $("#startTime").val(startTime);
    $("#endTime").val(endTime);
    $("#slotDate").val(slotDate);
    if (privacy == "false") {
        console.log('CLick')
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
    loadEventConductor($("#startTime").val(), $("#endTime").val());
    loadEventRoom($("#startTime").val(), $("#endTime").val());
}

function loadEventConductor(startTime, endTime) {

    var requestURL = contextPath + LOAD_CONDUCTOR;
    var requestMethod = "POST";
    var requestData = {
        "slotId": $("#txtTitle").data("id"),
        "startTime": startTime,
        "endTime": endTime
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

function loadEventRoom(startTime, endTime) {
    var requestURL = contextPath + LOAD_ROOM;
    var requestMethod = "POST";
    var requestData = {
        "slotId": $("#txtTitle").data("id"),
        "startTime": startTime,
        "endTime": endTime
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

