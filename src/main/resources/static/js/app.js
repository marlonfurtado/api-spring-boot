var app = angular.module("app", ["ngRoute"]);

app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/users", {
            templateUrl: "view/user.html",
            controller: "userController"
        })
        .when("/movies", {
            templateUrl: "view/movie.html",
            controller: "movieController"
        })
        .when("/users/:id", {
            templateUrl: "view/user-detail.html",
            controller: "userDetailController"
        })
        .otherwise({
            redirectTo: "/"
        });

    $locationProvider.html5Mode(true);
});