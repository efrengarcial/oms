define(["angular", "services"], function(angular, services){

    services.factory('ProductoService', ['$resource',
        function($resource){
    	  var Producto = $resource('/oms/api/v1/products/:idProducto', {idProducto: '@idProducto'});
    	  Producto.prototype.save = function(){
              return (typeof(this.id) === 'undefined');
          };
          return Producto;
        }
    ]);
});