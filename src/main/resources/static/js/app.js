(function(){
    'use strict';

    var app = angular.module('hb', ['ngRoute', 'ngResource']);

    app.config(function($routeProvider){
        $routeProvider
            .when('/', {
                templateUrl: '',
                controller: ''
            })
            .otherwise({
                redirectTo: '/'
            });
    });

}());