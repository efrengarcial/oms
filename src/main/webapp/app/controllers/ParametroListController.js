define(["angular","controllers", "services/ParametroService"], function(angular, controllers){

    controllers.controller('ParametroListController', ['$scope','$rootScope', 'Parametro','toaster',
        function($scope, $rootScope,Parametro,toaster) {   
    	$rootScope.loading = true;
    		Parametro.query().$promise.then(
    		      //success
    		      function( value ){
    		    	  $scope.parametros =value;
    		    	  $rootScope.loading = false;
    		       },
    		      //error
    		      function( error ){ 
    		    	  toaster.pop('error', "title", error.data);
    		    	  $rootScope.loading = false;
    		      }
    		   );    		
        }]);
});