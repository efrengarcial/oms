define(["angular","controllers", "services/OrderService"], function(angular, controllers){

    controllers.controller('OrderController', ['$scope', 'Order','$routeParams', '$location','toaster',
        function($scope, Order, $routeParams, $location, toaster) {
    	  	$scope.order = new Order();

    	    $scope.save = function () {
    	    	$scope.order.$save(function (order, headers) {
    	    		toaster.pop('success', "title", "Submitted New Order");
    	    		//toastr.success("Submitted New Story");
    	           // $location.path('/');
    	        });
    	    };
    	    
    	    $scope.find = function () {
    	    	$scope.order.find(function (ordId, headers) {
    	    		toaster.pop('success', "title", "Submitted New Order");
    	    		//toastr.success("Submitted New Story");
    	           // $location.path('/');
    	        });
    	    };
        }]);
});