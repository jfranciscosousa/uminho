var SpotiXico = angular.module('SpotiXico', ['ngRoute', 'ngAnimate']);

angular.module('SpotiXico').config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: '/app/templates/index.html',
        controller: 'IndexCtrl'
      }).
      when('/toptracks/:artist', {
        templateUrl: '/app/templates/toptracks.html',
        controller: 'TopTracksCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);