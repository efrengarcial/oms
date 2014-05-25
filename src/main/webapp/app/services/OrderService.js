define(["angular", "services"], function(angular, services){

    services.factory('OrderService', ['$resource',
        function($resource){
    	return {
    		findOrdersByNumberOrder:  $resource('/oms/api/v1/orders/findOrdersByNumberOrder?paginaActual=:paginaActual&ordId=:ordId'+
                      '&codigoProducto=:codigoProducto',
                      { paginaActual: '@paginaActual', ordId: '@ordId'}),
                      findOrdersByNumberProduct:  $resource('/oms/api/v1/orders/findOrdersByNumberProduct?paginaActual=:paginaActual'+
                              '&codigoProducto=:codigoProducto',
                              { paginaActual: '@paginaActual', codigoProducto: '@codigoProducto'})         
    		};
        }
    ]);
});