define(["angular","controllers", "services/DataService",  "services/ShoppingCart", "services/Store" ,"services/Product"],
		function(angular, controllers){

    controllers.controller('StoreController', ['$scope','$routeParams', 'toaster','DataService','Store','Product',
        function($scope, $routeParams ,toaster,DataService,Store,Product) {   
	    	 // get store and cart from service
	        $scope.store = DataService.store;
	        $scope.cart = DataService.cart;
	
	        // use routing to pick the selected product
	        if ($routeParams.productSku != null) {
	            $scope.product = $scope.store.getProduct($routeParams.productSku);
	        }    	
        }]);
});