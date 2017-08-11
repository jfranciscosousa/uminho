angular.module('app')
  .controller('loginCtrl', ['$scope', '$state', '$ionicNavBarDelegate', 'authenticationService',
    function($scope, $state, $ionicNavBarDelegate, authenticationService) {
      $scope.form = {};

      $scope.login = function() {
        console.log($scope.form.username);
        console.log($scope.form.password);
        authenticationService.Login($scope.form.username, $scope.form.password, function(response) {
          console.log(response);
          if (response.success) {
            $state.go('home');
          }
        });
      };
    }
  ]);
