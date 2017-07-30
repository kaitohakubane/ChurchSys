/**
 * Created by hungmcse61561-admin on 7/20/2017.
 */
$(document).ready(function(){
    $(".alert.alert-dismissible").each(function(){
        var style=$(this).attr("id")%3;
        console.log($(this))
        console.log($(this).attr("id"));

        if(style==1){
            $(this).addClass("alert-success");
        } else if(style==2) {
            $(this).addClass("alert-info");
        }else{
            $(this).addClass("alert-warning");
        }
    })
})

$(function () {
    $(".fl-church").slice(0, 3).show();
    $("#loadMore").on('click', function (e) {
        e.preventDefault();
        $(".fl-church:hidden").slice(0, 1).slideDown();
        if ($(".fl-church:hidden").length == 0) {
            $("#load").fadeOut('slow');
        }
        $('html,body').animate({
            scrollTop: $(this).offset().top
        }, 500);
    });
});

$(function () {
    $(".ev-church").slice(0, 3).show();
    $("#loadMore1").on('click', function (e) {
        e.preventDefault();
        $(".ev-church:hidden").slice(0, 1).slideDown();
        if ($(".ev-church:hidden").length == 0) {
            $("#load").fadeOut('slow');
        }
        $('html,body').animate({
            scrollTop: $(this).offset().top
        }, 500);
    });
});