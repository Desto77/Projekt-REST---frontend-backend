'use strict';

angular.module('HomeModule', [])
    .controller('HomeController', function ($scope, $state, Restangular) {
        $scope.message = "Hello";

        var restData = Restangular.all('rest/users');
        restData.getList().then(function (data) {
            $scope.users = data;
        });


        $scope.deleteUser = function (user, index) {
            Restangular.all("rest/delete/" + user.id).remove().then(function (data) {
                $scope.users.splice(index, 1);
            });
        };

        $scope.addUser = function (newuser) {
            newuser.id = 0;
            Restangular.all("rest/add").customPUT(newuser).then(function (data) {
                restData.getList().then(function (data) {
                    $scope.users = data;
                });
            });
        };

        // ==== SORTING THE TABLE ==== //
        $scope.sortType = 'name'; // set the default sort type
        $scope.sortReverse = false; // set the default sort order
        $scope.searchFish = ''; // set the default search/filter term

    });