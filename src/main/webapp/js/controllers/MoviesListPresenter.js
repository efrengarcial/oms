define(["angular","js/controllers", "services/MovieService"], function(angular, controllers){

    controllers.controller('MoviesListPresenter', ['$scope', 'Movie',
        function($scope, Movie) {
            $scope.movies = Movie.query();
        }]);
});