angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  var templateDir = 'js/app/templates/';

  $stateProvider
  .state('login', {
    url: '/',
    templateUrl: templateDir + 'login.html',
    controller: 'loginCtrl'
  })

  .state('home', {
    url: '/home',
    templateUrl: templateDir + 'home.html',
    controller: 'homeCtrl'
  })

  .state('nearestPrintshops', {
    cache: 'false',
    url: '/printshops',
    templateUrl: templateDir + 'nearestPrintshops.html',
    controller: 'nearestPrintshopsCtrl'
  })

  .state('printshop', {
    cache: 'false',
    url: '/printshop/:id',
    templateUrl: templateDir + 'printshop.html',
    controller: 'printshopCtrl'
  });

  $urlRouterProvider.otherwise('/');
});
