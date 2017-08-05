/**
 * Created by hungmcse61561-admin on 8/5/2017.
 */

$(document).ready(function(){
    $('#us3').locationpicker({
        location: {
            latitude: 16.0759032,
            longitude: 108.16987130000007
        },
        radius: false,
        inputBinding: {
            latitudeInput: $('#us3-lat'),
            longitudeInput: $('#us3-lon'),
            locationNameInput: $('#us3-address')
        },
        enableAutocomplete: true,
    });

    $('#locationModal').on('shown.bs.modal', function () {
        $('#us3').locationpicker('autosize');
    });
})
