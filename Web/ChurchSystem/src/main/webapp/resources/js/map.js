/**
 * Created by hungmcse61561-admin on 6/14/2017.
 */

var contextPath = "/ChurchSystem";
var CHURCH_SEARCH_URL = "/church/Search";
var image = {
    url: icon,
    scaledSize: new google.maps.Size(50, 50),
}

var choosingIcon={
    url:choosing_icon,
    scaledSize: new google.maps.Size(50, 50)
}
var map;
var markers = [];
var churchList = [];
var infoWindow;
var listOfLocation;

$(document).ready(function () {

    $("#geolocationBtn").click(function (e) {
        e.preventDefault();
        $("#geolocationBtn").toggleClass("onclick");
    });

    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("active");
    });

    $("#closeBtn").click(function () {

        $("#youtubeVideo").attr('src', "");

    });



    //Hover Menu in Header
    $('ul.nav li.dropdown').hover(function () {
        $(this).find('.drop-hover').stop(true, true).delay(200).fadeIn(200);
    }, function () {
        $(this).find('.drop-hover').stop(true, true).delay(200).fadeOut(200);
    });
})


google.maps.event.addDomListener(window, 'load', initAutocomplete);
function initAutocomplete() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 16.0544, lng: 108.2022},
        zoom: 13,
        mapTypeControl: false,
        mapTypeId: 'roadmap',
    });


    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    //Create get current position button
    var centerControlDiv = document.getElementById('geocontainer');
    new positionControl(centerControlDiv, map);
    centerControlDiv.index = 1;
    map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(centerControlDiv);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function () {
        searchBox.setBounds(map.getBounds());
    });

    infoWindow = new google.maps.InfoWindow();

    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener('places_changed', function () {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }
        // Clear out the old markers.
        markers.forEach(function (marker) {
            marker.setMap(null);
        });
        markers = [];

        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        var place = places[0];
        // .forEach(function (place) {
        if (!place.geometry) {
            console.log("Returned place contains no geometry");
            return;
        }

        // Create a marker for place.
        markers.push(new google.maps.Marker({
            map: map,
            title: place.name,
            position: place.geometry.location,
        }));


        // Church Position
        searchNearLocationAjaxCall(place.geometry.location);
        map.setCenter(place.geometry.location);

    });

    /* Get your Location*/
    /*==================*/
    getCurrentPosition(map, false)
}

/* Error case */
/*============*/

function handleNoGeolocation(errorFlag) {
    if (errorFlag) {
        var content = 'Sorry, we can not get your location. Please try again.';
    } else {
        var content = 'Your browser do not allow to get location';
    }
    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}

// The mapping between latitude, longitude and pixels is defined by the web
// mercator projection.
function project(latLng) {
    var siny = Math.sin(latLng.lat() * Math.PI / 180);

    // Truncating to 0.9999 effectively limits latitude to 89.189. This is
    // about a third of a tile past the edge of the world tile.
    siny = Math.min(Math.max(siny, -0.9999), 0.9999);

    return new google.maps.Point(
        TILE_SIZE * (0.5 + latLng.lng() / 360),
        TILE_SIZE * (0.5 - Math.log((1 + siny) / (1 - siny)) / (4 * Math.PI)));
}

function positionControl(controlDiv, map) {

    controlDiv.style.cursor = 'pointer';


    controlDiv.addEventListener('click', function () {
        getCurrentPosition(map, true);

    });

}

function getCurrentPosition(map, isGetChurch) {
    markers.forEach(function (marker) {
        marker.setMap(null);
    });
    markers = [];

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            markers.push(new google.maps.Marker({
                map: map,
                position: pos,
            }));
            map.setCenter(pos);
            if (isGetChurch == true) {
                searchNearLocationAjaxCall(pos);
            }

        }, function () {
            handleNoGeolocation(true);
        });
    }
    else {
        handleNoGeolocation(false);
    }
}


function createMarker(latlng, churchId, churchName, address, tel, startTime, endTime, streamLink, streamName,varStatus) {
    var html = "<b class='info-txt'>" + churchName + "</b> <div class='info-txt'>" + address + "</div><div class='info-txt'> Phone number : " + tel + "</div>" + "<div class='info-txt'>Giờ lễ : " +
        startTime + " - " + endTime + "</div>";
    var markerIcon = image;
    if (!(streamLink == null || streamLink == "")) {
        var stream = streamLink.split(",")
        var name = streamName.split(",")
        for (var i = 0; i < stream.length; i++) {
            html = html + "<button class='churchStreamBtn' id=" + stream[i] + " onclick='watchStream(this)' >" +
                "Streaming </button> <p class='stream-title'>" + name[i] + "</p></br>"
        }
        markerIcon = {
            url: streaming_icon,
            scaledSize: new google.maps.Size(50, 50),
        }
    }
    html = html + "<button class='churchFollowBtn' id=" + churchId + ">Follow </button>"
    html = html + "<button class='churchBtn' id=" + churchId + " onclick='gotoChurchPage(this)' >Main Page </button>"


    var marker = new google.maps.Marker({
        map: map,
        position: latlng,
        churchId: churchId,
        streamLink: streamLink,
        icon: markerIcon
    });

    google.maps.event.addListener(marker, 'click', function () {
        infoWindow.setContent(html);
        infoWindow.open(map, marker);
    });

    var sidebarHTML = "<div class='church-name'>" + churchName + "</div> <div class='address'>" + address + "</div>"
    $("#sidebar").append("<li id="+churchId+">" + sidebarHTML + "</li>")
    markers.push(marker);

}


function searchNearLocationAjaxCall(center) {
    $("#sidebar").empty();
    var requestURL = contextPath + CHURCH_SEARCH_URL;
    var requestMethod = "POST";
    var requestData = {
        "inputLatitude": center.lat(),
        "inputLongitude": center.lng()
    }
    $.ajax({
        url: requestURL,
        type: requestMethod,
        data: requestData,
        async: false,
        dataType: 'json',
        success: function (res) {
            infoWindow.close();
            listOfLocation = res;
            var bounds = new google.maps.LatLngBounds();
            listOfLocation.forEach(function (e,i) {
                console.log(e.latitude + " - " + e.longitude)
                console.log(e);
                var latlng = new google.maps.LatLng(
                    parseFloat(e.latitude),
                    parseFloat(e.longitude));
                createMarker(latlng, e.churchId, e.churchName, e.address, e.tel, e.startTime, e.endTime, e.streamLink, e.streamName,i)
                bounds.extend(latlng);

            })
            map.fitBounds(bounds);
            eventChoosing();
            $("#wrapper").toggleClass("active");
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    })
}

function watchStream(e) {
    $("#stream").modal("show");
    console.log(e.getAttribute("id"));
    $("#youtubeVideo").attr('src', "https://www.youtube.com/embed/" + e.getAttribute("id") + "?autoplay=1")
}

function gotoChurchPage(e) {
    window.location.href = contextPath + "/church" + "?churchId=" + e.getAttribute("id");
    console.log("RUN RUN")
}


function eventChoosing(){
    $("#sidebar li").hover(function(){
        var choose=$(this).attr("id");
        console.log(choose);
        if (choose != "none"){
            markers[choose].setAnimation(google.maps.Animation.BOUNCE);
        }
    },function(){
        var choose=$(this).attr("id");
        console.log(choose);
        if (choose != "none"){
            markers[choose].setAnimation(null);
        }
    })
}