define(["angular","controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('OrderCreateController', ['$scope', 'Order','$routeParams', '$location','toaster',
        function($scope, Order, $routeParams, $location, toaster) {
    	  	$scope.order = new Order();

    	    $scope.save = function () {
    	    	$scope.order.$save(function (order, headers) {
    	    		toaster.pop('success', "title", "Submitted New Story");
    	    		//toastr.success("Submitted New Story");
    	            $location.path('/');
    	        });
    	    };
        }]);
});