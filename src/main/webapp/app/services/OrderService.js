define(["angular", "services"], function(angular, services){

    services.factory('OrderService', ['$resource',
        function($resource){
    	return {
              consultarOrden: $resource('/oms/api/v1/orders/consultarOrden', { ordId: '@ordId' })
    		};
        }
    ]);
});