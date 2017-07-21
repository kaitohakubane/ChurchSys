/**
 * Created by hungmcse61561-admin on 7/18/2017.
 */
var STREAM_URL = "/manager/stream";
$(document).ready(function(){

    var parameter={
        streamLink: streamLink,
        streamCode: streamCode
    }
    $("#back").on("click",function(){
        post(contextPath + STREAM_URL,parameter)
    })
})