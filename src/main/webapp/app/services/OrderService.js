define(["angular", "services"], function(angular, services){

    services.factory('Order', ['$resource',
        function($resource){
    	 	var Order = $resource('/oms/api/v1/orders');    
    	    return Order;
        }
    ]);
});