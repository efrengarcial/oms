define(["angular","controllers", "services/ProductoService"], function(angular, controllers){

    controllers.controller('ProductCreateController', ['$scope', 'Producto','$routeParams', '$location','toaster',
        function($scope, Producto, $routeParams, $location, toaster) {
    	  	$scope.product = new Producto();

    	    $scope.save = function () {
    	    	$scope.product.$save(function (product, headers) {
    	    		toaster.pop('success', "title", "Submitted Product");
    	        });
    	    };
        }]);
});