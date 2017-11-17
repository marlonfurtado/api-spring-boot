app.controller("movieDetailController", function ($scope, $routeParams, $http) {
    $scope.movie = {};

    $http.get("movies/" + $routeParams.id)
        .then(function (response) {
            $scope.movie = response.data;
        }).catch(function (err) {
            console.log(err);
        });
})