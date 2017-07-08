/**
 * Created by hungmcse61561-admin on 7/7/2017.
 */
$(document).ready(function () {
    $(".dayOfWeek").each(function () {
        console.log($(this).val())
        var listOfDay = $(this).val().split(",");
        console.log(listOfDay)
        var result="";
        for(var i=0;i<listOfDay.length;i++){
            result=result+"T"+listOfDay[i]+" - ";

        }
        console.log(result);
        result=result.substring(0,result.length-3);
        console.log(result);
        $(this).val(result)
    })
})