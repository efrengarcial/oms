define(["angular","controllers", "services/ProductService"], function(angular, controllers){

    controllers.controller('ProductController', ['$scope', 'Producto','$routeParams', '$location','toaster',
        function($scope, Producto, $routeParams, $location, toaster) {
    	  	$scope.producto = new Producto();

    	    $scope.save = function () {
    	    	$scope.producto.$save(function (producto, headers) {
    	    		toaster.pop('success', "title", "Submitted Product");
    	        });
    	    };
    	    
    	    $scope.find = function () {
    	    	$scope.producto.findAll(function (codigoProducto, headers) {
    	    		toaster.pop('success', "title", "Submitted search");
    	    		//toastr.success("Submitted New Story");
    	           // $location.path('/');
    	        });
    	    };
        }]);
});