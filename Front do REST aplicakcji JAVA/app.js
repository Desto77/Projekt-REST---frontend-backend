'use strict';

var App = angular.module('App', ['restangular', 'appStates', 'HomeModule'])
    .config(function (RestangularProvider) {
        RestangularProvider.setBaseUrl('http://localhost:8080/REST_Project/');
    });