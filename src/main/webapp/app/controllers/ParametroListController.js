define(["angular","controllers", "services/ParametroService"], function(angular, controllers){

    controllers.controller('ParametroListController', ['$scope', 'Parametro','toaster',
        function($scope, Parametro,toaster) {    	
    		Parametro.query().$promise.then(
    		      //success
    		      function( value ){
    		    	  $scope.parametros =value;
    		       },
    		      //error
    		      function( error ){ 
    		    	  toaster.pop('error', "title", error.data);
    		      }
    		   );    		
        }]);
});