define(["angular", "services"], function(angular, services){

    services.factory('ProductService', ['$resource',
        function($resource){
    	return {
    		findAllEspectaculos : $resource('/oms/api/v1/products/findAllEspectaculos',{}),
    		
    		findAllTarifaBoleta :$resource('/oms/api/v1/products/findAllTarifaBoleta',{}),
    		
    		findAllTarifaTransporte :$resource('/oms/api/v1/products/findAllTarifaTransporte',{}),
    		
    		findAllTarifaHospedaje :$resource('/oms/api/v1/products/findAllTarifaHospedaje',{}),
    		
    		createProduct :$resource('/oms/api/v1/products/createProduct',{producto:"@product"}),
    		
    		};
        }
    ]);
    
    services.factory('ProductFactory', function ($resource) {
        return $resource('/oms/api/v1/productos', {producto:"@product"}, {
        	      create: { method: 'POST' }
        });
    	
//    	$http({
//    		url:'/oms/api/v1/products/save',
//    		method:"POST",
//    		data:{'producto':$scope.product}
//    	}
//    			);
    });
    
});