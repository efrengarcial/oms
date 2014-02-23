define(["angular", "services"], function(angular, services){

    services.factory('Parametro', ['$resource',
        function($resource){
    	  var Parametro = $resource('/oms/api/v1/parametros/:nombre', {nombre: '@id'});
    	  Parametro.prototype.isNew = function(){
              return (typeof(this.nombre) === 'undefined');
          };
          return Parametro;
        }
    ]);
});