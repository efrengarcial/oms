define(["angular", "services"], function(angular, services){

    services.factory('OrderService', ['$resource',
        function($resource){
    	return {
    		findOrdersByNumberOrder:  $resource('/oms/api/v1/orders/findOrdersByNumberOrder?paginaActual=:paginaActual&ordId=:ordId'+
                      '&codigoProducto=:codigoProducto',
                      { paginaActual: '@paginaActual', ordId: '@ordId'}),
                      findOrdersByNumberProduct:  $resource('/oms/api/v1/orders/findOrdersByNumberProduct?paginaActual=:paginaActual'+
                              '&codigoProducto=:codigoProducto',
                              { paginaActual: '@paginaActual', codigoProducto: '@codigoProducto'}),
                              findCancelOrders:  $resource('/oms/api/v1/orders/findCancelOrders?ordId=:ordId',
                                      {ordId: '@ordId'}),
                                      cancelarOrden:  $resource('/oms/api/v1/orders/cancelarOrden?ordId=:ordId',
                                              {ordId: '@ordId'}),
                                              findRankingOpenOrders:  $resource('/oms/api/v1/orders/findRankingOpenOrders',{}),
                                              findRankingClosedOrders:$resource('/oms/api/v1/orders/findRankingClosedOrders?fechaInicio=:fechaInicio'+
                                            		  '&fechaFin=:fechaFin',
                                                      { fechaInicio: '@fechaInicio', fechaFin: '@fechaFin'}),
                                                      findRankingCustomers:$resource('/oms/api/v1/orders/findRankingCustomers?fechaInicio=:fechaInicio'+
                                                    		  '&fechaFin=:fechaFin',
                                                              { fechaInicio: '@fechaInicio', fechaFin: '@fechaFin'}),
                                              
                                      
                              
    		};
        }
    ]);
});