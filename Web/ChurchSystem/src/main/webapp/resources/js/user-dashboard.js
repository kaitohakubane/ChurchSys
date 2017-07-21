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