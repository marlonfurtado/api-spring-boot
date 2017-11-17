app.controller("movieController", function ($scope, $http) {
    $scope.movies = [];
    $scope.movie = {};

    load = function () {
        $http.get("http://localhost:8080/movies")
            .then(function (response) {
                $scope.movies = response.data;
            })
            .catch(function (err) {
                console.log(err);
            });
    }

    $scope.save = function() {
        $http.post("http://localhost:8080/movies", $scope.movie)
        .then(function(response){
            load();
            $scope.movie = {};
            $scope.formMovie.$setPristine(true);
        })
        .catch(function(err){
            console.log(err);
        })
    }

    $scope.delete = function (movie) {
        $http.delete("http://localhost:8080/movies/"+movie.id)
        .then(function (response) {
            console.log(response);
            let index = $scope.movies.indexOf(movie);
            $scope.movies.splice(index, 1);
        })
        .catch(function(err){
            console.log(err);
        })
    }

    $scope.update = function(movie) {
        $scope.movie = angular.copy(movie);
    }

    $scope.cancelUpdate = function(movie) {
        $scope.movie = {};
    }

    load();
})