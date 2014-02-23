define(["angular","js/controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('ModalInstanceCtrl', ['$scope', '$modalInstance',
        function($scope, $modalInstance, items) {
    	 	$scope.items = items;
    	 	$scope.ok = function () {
    	 		$modalInstance.close();
    	 	};

    	  $scope.cancel = function () {
    	    $modalInstance.dismiss('cancel');
    	  }; 	 
      }]);
});