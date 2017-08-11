/* global $http */

angular.module('SpotiXico').controller('TopTracksCtrl', ['$scope', '$routeParams', '$http', '$animate',
    function ($scope, $routeParams, $http, $animate) {
        $scope.show = false;

        $http({
            method: 'GET',
            url: '/api/toptracks?artist=' + $routeParams.artist
        }).then(function successCallback(response) {
            response = JSON.parse(response.data);
            $scope.tracks = response.tracks;
            $scope.artist = response.artist.name;
            $scope.show = true;
        }, function errorCallback(response) {
            alert("Could not get top tracks for this artist!");
        });
    }]);
