(function(){
    'use strict';

    var app = angular.module('hb');

    app.controller('BookCtrl', ['$scope', 'books', 'book', function($scope, books, book){
        $scope.editing = false;

        var onCreateSuccess = function(){
            getBooks();
        };

        var onCreateError = function(reason){
            console.log(reason);
        };

        $scope.createBook = function(){
            books.create($scope.book).$promise
                .then(onCreateSuccess, onCreateError)
                .finally(function(){
                    $scope.editing = false;
                    $scope.book = {};
                })
        };

        $scope.deleteBook = function(currBook){
            book.delete({id: currBook.bookCode})
                .$promise
                .finally(function(){
                    getBooks();
                });
        };

        $scope.createInit = function(){
            $scope.editing = true;
        };

        var getBooks = function(){
            $scope.books = books.query();
        };

        getBooks();
    }]);

}());