angular.module('app').factory('backendURLService', [function() {

    var service = {};

    service.getBaseURL = function() {
        return 'https://proxyprint-kitchen.herokuapp.com/';
    };

    return service;
}]);
