define(["angular", "sservices"], function(angular, services){

    services.factory('Movie', ['$resource',
        function($resource){
            return $resource('movies/movies.json', {}, {
                query: {method:'GET', params:{}, isArray:true}
            });
        }
    ]);
});