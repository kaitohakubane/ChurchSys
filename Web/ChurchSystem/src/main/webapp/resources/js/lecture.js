/**
 * Created by Trung on 9/5/2017.
 */
// $('ul.list-lecture-name > li').click(function (e) {
//     e.preventDefault();
//     $('ul.list-lecture-name > li').removeClass('active-lecture');
//     $(this).addClass('active-lecture');
// });
var ADD_LECTURE = "/manager/lecture-management/add";
var LECTURE_MANAGEMENT = "/manager/lecture-management";

$(".lectureId").on("click", function () {
    //var lessonId = $(this).data("id");
    var link = $(this).data("link");
    var title = $(this).data("title");
    console.log(title);
    console.log(link);
    $("#contentTitle").html(title);
    $("#youtubeVideo").attr("src",link);
})
$("#btnOk").on('click', function () {
    insertLecture();
})
function insertLecture() {
    var requestURL = contextPath + ADD_LECTURE;
    var requestMethod = "POST";
    var requestData = {
        "title": $("#title").val(),
        "description": $("#description").val(),
        "link": $("#link").val(),
    }
    console.log(requestData);
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function () {
            alert("Add success!");
            window.location.href = contextPath + LECTURE_MANAGEMENT;

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    })
}
