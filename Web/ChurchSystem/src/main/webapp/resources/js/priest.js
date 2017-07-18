/**
 * Created by Mr Kiet on 07/15/17.
 */

var listOfSub = [];
var ADD_NEW_PRIEST = "/manager/priest-management/add-new-priest";
var PRIEST_MANAGEMENT = "/manager/priest-management";

$(document).ready(function () {
    $("#subject").dropdown({
        allowAdditions: true,
        onChange: function () {
            var abc = $('#subject').dropdown('get value');

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
    console.log($("#userName").val());
    console.log($("#accountId").val());
    console.log($("#email").val());
    console.log($("#phone").val());
    console.log($("#cert").val());
    console.log(listOfSub);
    addNewPriest();

})

function addNewPriest() {
    var requestURL = contextPath + ADD_NEW_PRIEST;
    var requestMethod = "POST";
    var requestData = {
        userName: $("#userName").val(),
        accountId: $("#accountId").val(),
        email: $("#email").val(),
        phone: $("#phone").val(),
        cert: $("#cert").val(),
        selectedSubjectList: listOfSub
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: JSON.stringify(requestData),
        async: false,
        contentType: 'application/json',
        // processData: false,
        // dataType: 'json',
        success: function () {
            alert("Add success!");
            window.location.href = contextPath + PRIEST_MANAGEMENT;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}