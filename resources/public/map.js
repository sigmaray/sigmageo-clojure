var panorama;
function initialize() {
  panorama = new google.maps.StreetViewPanorama(
  document.getElementById('street-view'),
  {
    // position: {lat: 37.869260, lng: -122.254811},
    position: {lat: $("body").data("lat"), lng: $("body").data("lng")},    
    pov: {heading: 165, pitch: 0},
    zoom: 1
  });
}
