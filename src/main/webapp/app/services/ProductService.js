define(["angular", "services"], function(angular, services){

    services.factory('ProductService', ['$resource',
        function($resource){
    	return {
    		findAllEspectaculos : $resource('/oms/api/v1/products/findAllEspectaculos',{}),
    		
    		findAllTarifaBoleta :$resource('/oms/api/v1/products/findAllTarifaBoleta',{}),
    		
    		findAllTarifaTransporte :$resource('/oms/api/v1/products/findAllTarifaTransporte',{}),
    		
    		findAllTarifaHospedaje :$resource('/oms/api/v1/products/findAllTarifaHospedaje',{}),
    		};
        }
    ]);
    
    services.factory('ProductFactory', function ($resource) {
        return $resource('/oms/api/v1/products/:producto', {}, {
        	query: { method: 'GET', isArray: true },
            save: { method: 'POST' }
           
        })
    });
    
});