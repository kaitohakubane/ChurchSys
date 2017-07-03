/**
 * Created by hungmcse61561-admin on 7/2/2017.
 */

$(document).ready(function(){
    Initial();
})

function Initial(){
    $("#step-2").hide();

    $("#next").on('click', function(){
        $("#step-1").hide();
        $("#step-2").show();
    });
}