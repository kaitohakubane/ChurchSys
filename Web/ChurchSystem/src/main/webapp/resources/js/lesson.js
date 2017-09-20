/**
 * Created by Trung on 9/5/2017.
 */
$('.tree-toggle').click(function () {
    $(this).parent().children('ul.tree').toggle(200);
});
$(function(){
    $('.tree-toggle').parent().children('ul.tree').toggle(200);
});

var ADD_LESSON = "/manager/lesson-management/add";
var LESSON_MANAGEMENT = "/manager/lesson-management";
var LESSON_CONTENT = "/church/lessoncontent";
$(document).ready(function () {
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