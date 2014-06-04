define(["angular", "services"], function(angular, services){

    services.factory('CustomerService', ['$resource',
        function($resource){
    	return {
    		findCustomerByIdentification:  $resource('/oms/api/v1/customers/findCustomerByIdentification?paginaActual=:paginaActual&identificacion=:identificacion',
                      { paginaActual: '@paginaActual', identificacion: '@identificacion'}),
                      findCustomerByProduct:  $resource('/oms/api/v1/customers/findCustomerByProduct?paginaActual=:paginaActual'+
                              '&codigoProducto=:codigoProducto',
                              { paginaActual: '@paginaActual', codigoProducto: '@codigoProducto'}),
                              findRankingCustomers:  $resource('/oms/api/v1/orders/findRankingCustomers?fechaInicio=:fechaInicio'+
                            		  '&fechaFin=:fechaFin', { fechaInicio: '@fechaInicio', fechaFin: '@fechaFin'})
    		};
        }
    ]);
});