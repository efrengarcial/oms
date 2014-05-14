define(["angular", "services"], function(angular, services){

    services.factory('OrderService', ['$resource',
        function($resource){
    	return {
              consultarOrdenes:  $resource('/oms/api/v1/orders/consultarOrdenes?paginaActual=:paginaActual&ordId=:ordId'+
                      '&codigoProducto=:codigoProducto',
                      { paginaActual: '@paginaActual', ordId: '@ordId', 
                          codigoProducto: '@codigoProducto'
                      })
                      //consultarOrden: $resource('/oms/api/v1/orders/consultarOrden', { ordId: '@ordId' }),        
    		};
        }
    ]);
});