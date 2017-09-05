/**
 * Created by Trung on 6/19/2017.
 */

$(document).ready(function () {
    //Hover Menu in Header
    $('ul.nav li.dropdown').hover(function () {
        $(this).find('.drop-hover').stop(true, true).delay(200).fadeIn(200);
    }, function () {
        $(this).find('.drop-hover').stop(true, true).delay(200).fadeOut(200);
    });

    $('ul li.dropdown').hover(function () {
        $(this).find('.online').stop(true, true).delay(200).fadeIn(200);
    }, function () {
        $(this).find('.online').stop(true, true).delay(200).fadeOut(200);
    });

    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("active");
    });


});
