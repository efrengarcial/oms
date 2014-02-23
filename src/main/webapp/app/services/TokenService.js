define(["angular", "services"], function(angular, services){

    services.factory('Token', ['$resource',
        function($resource){
    	 	var Token = $resource('/oms/api/v1/ping');    
    	    return Token;
        }
    ]);
});