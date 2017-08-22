var CHECK_ADVANCE_URL = "/manager/event/advanceCheck";
var ADVANCE_CREATE_EVENT_URL = "/manager/event/advance-create";
var dayArray;
var isLoop = 0;
var monthDes = 1;
$(document).ready(function () {
    $("#advance-startDate").datepicker();
    $("#advance-startDate").datepicker('option', 'dateFormat', 'yy-mm-dd');
    $("#advance-startDate").val(slotDate);
    subjectDropdownEvent($('#category'));
    $('#category').change(function () {
        var firstVal = null;
        var categoryValue = $(this).val();
        $('#eventType option').each(function () {
            var item = $(this);
            if (!(item.data("category") == categoryValue)) {
                item.hide();
            } else {
                if (firstVal == null) {
                    firstVal = item.val();
                }
                item.show();
            }
        })
        $('#eventType').val(firstVal);
    })
    $("#hiding-form").hide();

    $("input:radio[name=repeat]").on('ifChanged', function () {
        var selectedValue = $(this).val();
        if (selectedValue == "showForm") {
            $("#hiding-form").show();
            isLoop = 1;
        }
        else if (selectedValue == "hideForm") {
            $("#hiding-form").hide();
            isLoop = 0;
        }
    });

    $('#option-select').on('change', function () {
        var selected = $('#option-select option:selected');
        if (selected.length > 0) {
            var result = '';
            selected.each(function () {
                result += $(this).data('id');
            });
            $('#option-result').html(result);
        }
        var selectedNum = $(this).val();
        if (selectedNum == "1") {
            $("#week-selected").hide();
            $("#month-selected").hide();
        }
        else if (selectedNum == "2") {
            $("#week-selected").show();
            $("#month-selected").hide();
        }
        else if (selectedNum == "3") {
            $("#week-selected").hide();
            $("#month-selected").show();
        }
        else if (selectedNum == "4") {
            $("#week-selected").hide();
            $("#month-selected").hide();
        }
    });

    $("#week-selected").hide();
    $("#month-selected").hide();

    generalInitial()

})


function subjectDropdownEvent(category) {
    var firstVal = null;
    var categoryValue = category.val();
    $('#eventType option').each(function () {
        var item = $(this);
        if (!(item.data("category") == categoryValue)) {
            item.hide();
        } else {
            if (firstVal == null) {
                firstVal = item.val();
            }
            item.show();
        }
    })
    $('#eventType').val(firstVal);
}

function generalInitial() {
    $("input:radio[name=month]").on('ifChanged', function () {
        var selectedValue = $(this).val();
        if (selectedValue == "1") {
            monthDes = 1;
        }
        else if (selectedValue == "2") {
            monthDes = 2;
        }
    });

    $('.day-checkbox').on('ifChecked', function (event) {
        dayArray.push(event.target.id)
        dayArray.sort(function (a, b) {
            return a - b;
        })
        console.log(dayArray)
    });

    $('.day-checkbox').on('ifUnchecked', function (event) {
        var index = dayArray.indexOf(event.target.id);
        if (index > -1) {
            dayArray.splice(index, 1);
        }
    });

    $("#btnSave").on("click", function () {
        var loopType = $("#option-select").val();
        var kind = $("#kind").val();
        var repeatTime = $("#numOfRepeat").val();
        var eventSub = $('#eventType').children(":selected").attr("id");
        var isPublic = $("#createEventPopupIsPublic").prop('checked');
        var policy = 0;
        if (isPublic) {
            policy = 1;
        }
        console.log(policy);
        if (isLoop == 1) {
            if (loopType == '1') {
                checkAdvance(policy, eventSub, repeatTime, loopType, kind, null)
                console.log("Day type")
            } else if (loopType == '2') {
                checkAdvance(policy, eventSub, repeatTime, loopType, kind, dayArray.toString())
                console.log("Week type")
            } else if (loopType == '3') {
                checkAdvance(policy, eventSub, repeatTime, loopType, kind, monthDes);
                console.log("Month type")
            } else if (loopType == '4') {
                checkAdvance(policy, eventSub, repeatTime, loopType, kind, null)
                console.log("Year type")
            }
        }

    })


    $("#btnBack").on("click", function () {
        document.location.href = contextPath + "/manager/schedule";
    })
}

function checkAdvance(isPublic, eventSub, numberOfSlot, type, kind, typeString) {
    var requestURL = contextPath + CHECK_ADVANCE_URL;
    var requestMethod = "POST";
    var requestData = {
        slotDate: $("#advance-startDate").val(),
        subId: eventSub,
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val(),
        numOfSlot: numberOfSlot,
        type: type,
        kind: kind,
        typeString: typeString
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (res) {
            var result = res;
            console.log(result);
            if (result == 1) {
                $("#createClass").modal("hide");
                $("#calendarPopup").fadeOut();
                advanceCreate(typeString);
            } else {
                $("#confirmModal").modal("show");
                $("#process").unbind("click")
                $("#process").bind("click", function () {
                    $("#confirmModal").modal("hide");
                    $("#createClass").modal("hide");
                    advanceCreate(typeString);
                })

                $("#calendarPopup").fadeOut();
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error happen')
            console.error(textStatus);
        }
    });
}


function advanceCreate(typeString) {
    var isPublic = $("#createEventPopupIsPublic").prop('checked');
    console.log(isPublic);
    var privacy;
    if (isPublic) {
        privacy = 1
    }
    else {
        privacy = 0
    }
    var requestURL = contextPath + ADVANCE_CREATE_EVENT_URL;
    var requestMethod = "POST";
    var requestData = {
        eventName: $("#eventName").val(),
        slotDate: $("#advance-startDate").val(),
        subId: $('#eventType').children(":selected").attr("id"),
        slotHour: $("#startTime").children(":selected").attr("id") + ',' + $("#endTime").children(":selected").attr("id"),
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val(),
        numOfSlot: $("#numOfRepeat").val(),
        type: $("#option-select").val(),
        kind: $("#kind").val(),
        typeString: typeString,
        privacy: privacy,
    }
    console.log(requestData);
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        contentType: 'application/json',
        processData: false,
        dataType: 'json',

        success: function (res) {
            var result = res;
            console.log(result);
            window.location.href=contextPath+"/manager/schedule";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('Error happen')
            console.error(textStatus);
        }
    });
}