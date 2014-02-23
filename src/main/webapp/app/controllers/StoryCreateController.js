define(["angular","controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('StoryCreateController', ['$scope', 'Story','$routeParams', '$location','toaster',
        function($scope, Story, $routeParams, $location, toaster) {
    	  	$scope.story = new Story();

    	    $scope.save = function () {
    	    	$scope.story.$save(function (story, headers) {
    	    		toaster.pop('success', "title", "Submitted New Story");
    	    		//toastr.success("Submitted New Story");
    	            $location.path('/');
    	        });
    	    };
        }]);
});