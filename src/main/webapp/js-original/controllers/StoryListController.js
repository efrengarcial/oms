define(["angular","js/controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('StoryListController', ['$scope', 'Story','toaster',
        function($scope, Story,toaster) {
    		//$scope.stories = Story.query();
    		/* Story.query(function(res) {
    			 $scope.stories =res;
    		}, function(error) {
    		  // Error handler code
    		    toaster.pop('error', "title", error.data);
    		}); */
    	//http://stackoverflow.com/questions/15531117/angularjs-1-1-3-resource-callback-error-and-success
    	Story.query().$promise.then(
    		      //success
    		      function( value ){
    		    	  $scope.stories =value;
    		       },
    		      //error
    		      function( error ){ 
    		    	  toaster.pop('error', "title", error.data);
    		      }
    		   );    		
        }]);
});