app.controller("userController", function ($scope, $http) {
    $scope.users = [];

    load = function () {
        $http.get("http://localhost:8080/users")
            .then(function (response) {
                $scope.users = response.data;
            })
            .catch(function (err) {
                console.log(err);
            });
    };
    load();
})