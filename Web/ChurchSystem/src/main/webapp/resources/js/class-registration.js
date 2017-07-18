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

    $(".class-registration").on("click",function(){
        var eventId=$(this).prop("id");
        registerClass(eventId,churchId);
    })

})
function registerClass(eventId, churchId) {
    var requestURL = contextPath + ADD_REGISTRATION;
    var requestMethod = "POST";
    var requestData = {
        "churchId": churchId,
        "eventId":eventId
    }

    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        success: function (res) {

        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('Error happen')
            console.error(textStatus);
        }
    });
}