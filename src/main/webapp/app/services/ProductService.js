define(["angular", "services"], function(angular, services){

    services.factory('ProductService', ['$resource',
        function($resource){
    	return {
    		findAllEspectaculos : $resource('/oms/api/v1/products/findAllEspectaculos',{}),
    		
    		findAllTarifaBoleta :$resource('/oms/api/v1/products/findAllTarifaBoleta',{}),
    		
    		findAllTarifaTransporte :$resource('/oms/api/v1/products/findAllTarifaTransporte',{}),
    		
    		findAllTarifaHospedaje :$resource('/oms/api/v1/products/findAllTarifaHospedaje',{}),
    		
    		createProduct :$resource('/oms/api/v1/products/createProduct?&codigoProducto=:codigoProducto'+
                    '&nombreProducto=:nombreProducto&descripcionProducto=:descripcionProducto&idEspectaculo=:idEspectaculo&idTarifaBoleta=:idTarifaBoleta&idTarifaTransporte=:idTarifaTransporte&idTarifaHospedaje=:idTarifaHospedaje&rutaImagen=:rutaImagen&fechaFinal=:fechaFinal&fechaInicial=:fechaInicial',
    				{codigoProducto: '@codigoProducto', 
                	nombreProducto: '@nombreProducto', 
                	descripcionProducto: '@descripcionProducto',
                	idEspectaculo: '@idEspectaculo',
                	idTarifaBoleta:"@idTarifaBoleta",
                	idTarifaTransporte:"@idTarifaTransporte",
                	idTarifaHospedaje:"@idTarifaHospedaje",
                	rutaImagen:"@rutaImagen",
                	fechaFinal:"@fechaFinal",
                	fechaInicial:"@fechaInicial"
    					}),
					updateProduct :$resource('/oms/api/v1/products/updateProduct?idProducto=:idProducto&codigoProducto=:codigoProducto'+
		                    '&nombreProducto=:nombreProducto&descripcionProducto=:descripcionProducto&idEspectaculo=:idEspectaculo&idTarifaBoleta=:idTarifaBoleta&idTarifaTransporte=:idTarifaTransporte&idTarifaHospedaje=:idTarifaHospedaje&rutaImagen=:rutaImagen&fechaFinal=:fechaFinal&fechaInicial=:fechaInicial',
		    				{idProducto: '@idProducto',
							codigoProducto: '@codigoProducto', 
		                	nombreProducto: '@nombreProducto', 
		                	descripcionProducto: '@descripcionProducto',
		                	idEspectaculo: '@idEspectaculo',
		                	idTarifaBoleta:"@idTarifaBoleta",
		                	idTarifaTransporte:"@idTarifaTransporte",
		                	idTarifaHospedaje:"@idTarifaHospedaje",
		                	rutaImagen:"@rutaImagen",
		                	fechaFinal:"@fechaFinal",
		                	fechaInicial:"@fechaInicial"
		    					}),		
		    					
					removeProduct :$resource('/oms/api/v1/products/removeProduct?idProducto=:idProducto',
		    				{idProducto: '@idProducto'}),	
		
    		};
        }
    ]);
    
    services.factory('ProductFactory', function ($resource) {
        return $resource('/oms/api/v1/productos', {}, {
        	      save: { method: 'POST' }
        });
    	
//    	$http({
//    		url:'/oms/api/v1/products/save',
//    		method:"POST",
//    		data:{'producto':$scope.product}
//    	}
//    			);
    });
    
});