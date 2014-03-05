define(["angular", "services"], function(angular, services){

    services.factory('Producto', ['$resource',
        function($resource){
    	 	var Producto = $resource('/oms/api/v1/productos');    
    	    return Producto;
        }
    ]);
});