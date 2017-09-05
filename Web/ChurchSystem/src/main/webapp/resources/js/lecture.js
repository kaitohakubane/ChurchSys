/**
 * Created by Trung on 9/5/2017.
 */
$('ul.list-lecture-name > li').click(function (e) {
    e.preventDefault();
    $('ul.list-lecture-name > li').removeClass('active-lecture');
    $(this).addClass('active-lecture');
});