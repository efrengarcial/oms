define(["angular", "services"], function(angular, services){

    services.factory('ProductoService', ['$resource',
        function ($resource) {

            return {
              		consultarProductos:  $resource('/oms/api/v1/products/consultarProductos?paginaActual=:paginaActual&codigoProducto=:codigoProducto'+
                                            '&nombreProducto=:nombreProducto&descripcionProducto=:descripcionProducto&idEspectaculo=:idEspectaculo',
                                            { paginaActual: '@paginaActual', codigoProducto: '@codigoProducto', 
                                                nombreProducto: '@nombreProducto', descripcionProducto: '@descripcionProducto',idEspectaculo: '@idEspectaculo'
                                            }),
                                            
                    consultarProducto: $resource('/oms/api/v1/products/consultarProducto', { idProducto: '@idProducto' }),
            };
        }
    ]);
});