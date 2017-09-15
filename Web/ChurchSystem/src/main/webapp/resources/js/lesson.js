/**
 * Created by Trung on 9/5/2017.
 */
// $('ul.list-lesson-name > li').click(function (e) {
//     e.preventDefault();
//     $('ul.list-lesson-name > li').removeClass('active-lesson');
//     $(this).addClass('active-lesson');
// });
var ADD_LESSON = "/manager/lesson-management/add";
var LESSON_MANAGEMENT = "/manager/lesson-management";
var LESSON_CONTENT = "/church/lessoncontent";
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

$(".lessonId").on("click", function () {
    //var lessonId = $(this).data("id");
    var title = $(this).data("title");
    var content = $(this).data("content");
    console.log(lessonId);
    console.log(title);
    console.log(content);
    $("#contentTitle").html(title)
    $("#contentDesciption").html(content)
})



$("#btnOk").on('click', function () {
    insertLesson();
})
function insertLesson() {
    var requestURL = contextPath + ADD_LESSON;
    var requestMethod = "POST";
    var requestData = {
        "title": $("#title").val(),
        "description": $("#description").val(),
        "subId": $('#eventType').children(":selected").attr("id"),
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            alert("Add success!");
            window.location.href = contextPath + LESSON_MANAGEMENT;

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}