angular.module('app')
  .controller('printshopCtrl', ['$scope', '$state', '$stateParams', '$http',
    function($scope, $state, $stateParams, $http) {

      var printshopID = $stateParams.id;

      $http({
        method: 'GET',
        url: 'https://proxyprint-kitchen.herokuapp.com/printshops/' + printshopID
      }).then(function successCallback(response) {
        $scope.printshop = response.data;
      }, function errorCallback() {
        alert('We cannot reach the servers!');
      });
    }
  ]);
