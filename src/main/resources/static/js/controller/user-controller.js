app.controller("userController", function ($scope, $http) {
    $scope.users = [];
    $scope.user = {};

    $scope.load = function () {
        $http.get("http://localhost:8080/users")
            .then(function (response) {
                $scope.users = response.data;
            })
            .catch(function (err) {
                console.log(err);
            });
    };

    $scope.save = function () {
        $http.post("http://localhost:8080/users", $scope.user)
            .then(function (response) {
                $scope.user = response.data;
            })
            .catch(function (err) {
                console.log(err);
            });
    }

    $scope.delete = function (user) {
        $http.delete("http://localhost:8080/users/"+user.id)
            .then(function (response) {
                let index = $scope.users.indexOf(user);
                $scope.users.splice(index, 1);
            })
            .catch(function (err) {
                console.log(err);
            });
    }

    $scope.load();
})