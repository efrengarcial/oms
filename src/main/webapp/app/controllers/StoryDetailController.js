define(["angular","js/controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('StoryDetailController', ['$scope', 'Story','$routeParams', 'toaster',
        function($scope, Story, $routeParams , toaster) {
    	    var storyId = $routeParams.storyId;    	    
    	    $scope.story = Story.get({storyId: storyId});
        }]);
});