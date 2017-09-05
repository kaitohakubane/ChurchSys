/**
 * Created by Trung on 9/5/2017.
 */
$('ul.list-lesson-name > li').click(function (e) {
    e.preventDefault();
    $('ul.list-lesson-name > li').removeClass('active-lesson');
    $(this).addClass('active-lesson');
});