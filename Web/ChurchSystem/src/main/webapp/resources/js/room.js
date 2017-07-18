/**
 * Created by Mr Kiet on 07/15/17.
 */
var listOfSub = [];
var ADD_NEW_ROOM = "/manager/room-management/add-new-room";
var ROOM_MANAGEMENT = "/manager/room-management";
$(document).ready(function () {
    $("#subject").dropdown({
        allowAdditions: true,
        onChange: function () {
            var abc = $('#subject').dropdown('get value');
            console.log(abc);
            listOfSub = [];
            var list = abc[abc.length - 1];
            if (list == null) {
                return;
            }
            list.forEach(function (e) {
                console.log(e)
                $("#subject option").each(function () {
                    if ($(this).val() == e) {
                        if (!listOfSub.includes($(this).attr("id"))) {
                            listOfSub.push($(this).attr("id"));
                        }
                    }
                })
            })
        }
    })
    generalInitial();
})

function generalInitial() {
    subjectDropdownEvent($('#category'));
    $('#category').change(function () {

            var categoryValue = $(this).val();

            $('#subject option').each(function () {

                var item = $(this);
                if (!(item.data("category") == categoryValue)) {
                    $('.menu div').each(function () {

                        if (($(this).data('value') == item.val()))
                            $(this).hide()
                    })
                } else {
                    $('.menu div').each(function () {
                        if ($(this).data('value') == item.val())
                            $(this).show()
                    })
                }
            })
        }
    )
}

function subjectDropdownEvent(category) {

    var categoryValue = category.val();
    $('#subject option').each(function () {
        var item = $(this);
        if (!(item.data("category") == categoryValue)) {
            $('.menu div').each(function () {
                if (($(this).data('value') == item.val()))
                    $(this).hide()
            })
        } else {
            $('.menu div').each(function () {
                if ($(this).data('value') == item.val())
                    $(this).show()
            })
        }
    })
}

$("#btnOk").on('click', function (e) {
    console.log($("#roomName").val());
    console.log(listOfSub);
    addNewRoom();
})
function addNewRoom() {
    var requestURL = contextPath + ADD_NEW_ROOM;
    var requestMethod = "POST";
    var requestData = {
        roomName: $("#roomName").val(),
        selectedSubjectList: listOfSub
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        processData: false,
        dataType: 'json',
        success: function (e) {
            alert("Add success!");
            window.location.href = contextPath + ROOM_MANAGEMENT;

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}