/**
 * Created by hungmcse61561-admin on 6/14/2017.
 */
var contextPath = "/ChurchSystem";
var markers = [];
var churchList = [];
google.maps.event.addDomListener(window, 'load', initAutocomplete);
function initAutocomplete() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 16.0544, lng: 108.2022},
        zoom: 13,
        mapTypeId: 'roadmap'

    });


    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    //Create get current position button
    var centerControlDiv = document.createElement('div');
    new positionControl(centerControlDiv, map);
    centerControlDiv.index = 1;
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(centerControlDiv);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function () {
        searchBox.setBounds(map.getBounds());
    });


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
            position: place.geometry.location
        }));


        if (place.geometry.viewport) {
            // Only geocodes have viewport.
            bounds.union(place.geometry.viewport);
        } else {
            bounds.extend(place.geometry.location);
        }

        map.setCenter(place.geometry.location);

        // Church Position
        var pos = new google.maps.LatLng('16.066979', '108.223317');
        var image = "https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png";
        markers.push(new google.maps.Marker({
            map: map,
            icon: image,
            position: pos,
            id: 1
        }))

        churchEventRegister();
        // });
        // map.fitBounds(bounds);
    });

    /* Get your Location*/
    /*==================*/
    getCurrentPosition(map, markers)
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

/* get latitude & longitude */
/*==========================*/

var TILE_SIZE = 256;

function createInfoWindowContent(latLng, zoom) {
    var scale = 1 << zoom;

    var worldCoordinate = project(latLng);

    return [
        'LatLng: ' + latLng
    ].join('<br>');
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

    // Set CSS for the control border.
    var controlUI = document.createElement('div');
    controlUI.style.cursor = 'pointer';
    controlDiv.appendChild(controlUI);

    var controlImg = document.createElement('i');
    controlImg.className = "fa fa-crosshairs";

    controlUI.appendChild(controlImg);
    controlUI.addEventListener('click', function () {
        getCurrentPosition(map);

        // Church Position
        var pos = new google.maps.LatLng('16.066979', '108.223317');
        var image = "https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png";
        markers.push(new google.maps.Marker({
            map: map,
            icon: image,
            position: pos,
            id: 1
        }))

        churchEventRegister();
    });

}

function churchEventRegister() {
    markers.forEach(function (e) {
        e.addListener('click', function () {
            console.log(e.id);
            window.location.href = contextPath + "/church/" + e.id;
        });
    })
}

function getCurrentPosition(map) {
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

        }, function () {
            handleNoGeolocation(true);
        });
    }
    else {
        handleNoGeolocation(false);
    }
}