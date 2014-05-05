define(["angular", "services"], function(angular, services){

    services.factory('ProductService', ['$resource',
        function($resource){
    	return {
    		consultarProductos:  $resource('/oms/api/v1/products/consultarProductos?paginaActual=:paginaActual&codigoProducto=:codigoProducto'+
                    '&nombreProducto=:nombreProducto&descripcionProducto=:descripcionProducto',
                    { paginaActual: '@paginaActual', codigoProducto: '@codigoProducto', 
                        nombreProducto: '@nombreProducto', descripcionProducto: '@descripcionProducto'
                    }),
                    
    		consultarProducto: $resource('/oms/api/v1/products/consultarProducto', { idProducto: '@idProducto' })
    		
    	};
        }
    ]);
});