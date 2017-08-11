angular.module('SpotiXico').controller('IndexCtrl', ['$scope', '$location',
    function ($scope, $location) {
        $scope.action = function (artist) {
            $location.path('/toptracks/' + artist);
        };
    }]);
