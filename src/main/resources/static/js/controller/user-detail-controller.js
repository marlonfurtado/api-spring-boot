app.controller("userDetailController", function ($scope, $routeParams, $http) {
    $scope.user = {};

    $http.get("users/" + $routeParams.id)
        .then(function (response) {
            $scope.user = response.data;

        }).catch(function (err) {
            console.log(err);
        });
})