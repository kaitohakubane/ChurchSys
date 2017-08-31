/**
 * Created by Trung on 9/1/2017.
 */
$('ul.list-chatter > li').click(function (e) {
    e.preventDefault();
    $('ul.list-chatter > li').removeClass('active-chatter');
    $(this).addClass('active-chatter');
});