app.controller("movieController", function ($scope, $http) {
    $scope.movies = []
    $scope.movie = {}

    load = function () {
        $http.get("http://localhost:8080/movies")
            .then(function (response) {
                console.log("LOADING MOVIES...");
                $scope.movies = response.data;
            })
            .catch(function (err) {
                console.log(err);
            });
    }

    load();
})