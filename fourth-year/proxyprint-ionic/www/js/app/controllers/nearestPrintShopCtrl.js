angular.module('app')
  .controller('nearestPrintshopsCtrl', ['$scope', '$http', '$cordovaGeolocation', function($scope, $http, $cordovaGeolocation) {

    if (typeof(Number.prototype.toRad) === 'undefined') {
      Number.prototype.toRadians = function() {
        return this * Math.PI / 180;
      };
    }

    function distance(lat1, lon1, lat2, lon2) {
      var R = 6371e3; // metres
      var φ1 = lat1.toRadians();
      var φ2 = lat2.toRadians();
      var Δφ = (lat2 - lat1).toRadians();
      var Δλ = (lon2 - lon1).toRadians();

      var a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
        Math.cos(φ1) * Math.cos(φ2) *
        Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
      var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

      return R * c;
    }

    var posOptions = {
      timeout: 10000,
      enableHighAccuracy: false
    };

    $cordovaGeolocation
      .getCurrentPosition(posOptions)
      .then(function(position) {
        var lat = position.coords.latitude;
        var long = position.coords.longitude;
        console.log('lat: %d long:%d', lat, long);
        $http({
          method: 'GET',
          url: 'https://proxyprint-kitchen.herokuapp.com/printshops/nearest?latitude=' + lat + '&longitude=' + long
        }).then(function successCallback(response) {
          var printshops = response.data.printshops;
          for (var i in printshops) {
            printshops[i].distance = distance(printshops[i].latitude, printshops[i].longitude, lat, long) / 1000;
            printshops[i].distance = printshops[i].distance.toFixed(2);
          }
          $scope.printshops = printshops;
        }, function errorCallback() {
          alert('We cannot reach the servers!');
        });
      });

      $scope.goToPrintshop = function (printshopID){
        $state.go("printshop/:id",{id: printshopID});
      }
  }]);
