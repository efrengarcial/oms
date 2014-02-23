define(["angular","controllers", "services/StoryService"], function(angular, controllers){
    controllers.controller('GridController', ['$scope', '$http','$modal',
        function($scope, $http , $modal) {
    		
    	   var datos;
	   	    $scope.mySelections = [];
	   	    $scope.filterOptions = {
	   	        filterText: "",
	   	        useExternalFilter: true
	   	    }; 
	   	    $scope.totalServerItems = 0;
	   	    $scope.pagingOptions = {
	   	        pageSizes: [250, 500, 1000],
	   	        pageSize: 250,
	   	        currentPage: 1
	   	    };	
	   	    $scope.setPagingData = function(data, page, pageSize){	
	   	        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
	   	        $scope.myData = pagedData;
	   	        $scope.totalServerItems = data.length;
	   	        if (!$scope.$$phase) {
	   	            $scope.$apply();
	   	        }
	   	    };
	   	    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
	   	        setTimeout(function () {
	   	            var data;
	   	            if (searchText) {
	   	                var ft = searchText.toLowerCase();
	   	                $http.get('jsonFiles/largeLoad.json').success(function (largeLoad) {		
	   	                    data = largeLoad.filter(function(item) {
	   	                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
	   	                    });
	   	                    $scope.setPagingData(data,page,pageSize);
	   	                });            
	   	            } else {	        
	   	            	if (undefined == datos) {
	   		                $http.get('jsonFiles/largeLoad.json').success(function (largeLoad) {
	   		                	datos= largeLoad;
	   		                	$scope.setPagingData(largeLoad,page,pageSize);
	   		                });
	   	                } else {
	   	                	$scope.setPagingData(datos,page,pageSize);
	   	                }
	   	            }
	   	        }, 100);
	   	    };
	   		
	   	    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
	   		
	   	    $scope.$watch('pagingOptions', function (newVal, oldVal) {
	   	        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
	   	          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
	   	        }
	   	    }, true);
	   	    $scope.$watch('filterOptions', function (newVal, oldVal) {
	   	        if (newVal !== oldVal) {
	   	          $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
	   	        }
	   	    }, true);
	   		
	   	    $scope.gridOptions = {
	   	        data: 'myData',
	   	        enablePaging: true,
	   			showFooter: true,
	   	        totalServerItems: 'totalServerItems',
	   	        pagingOptions: $scope.pagingOptions,
	   	        filterOptions: $scope.filterOptions,
	   	        multiSelect: false,
	   	        jqueryUITheme: true, 
	   	        selectedItems: $scope.mySelections,
	   	        afterSelectionChange: function() {	
	   	        	 $scope.details = $scope.mySelections;
	   	        	 if ($scope.details.length  >0 ) {
	   		        	 var modalInstance = $modal.open({
	   		        	        templateUrl: 'views/stories/myModalContent.html',
	   		        	        controller: 'ModalInstanceCtrl',
	   		        	        resolve: {
	   		        	          items: function () {
	   		        	            return $scope.details;
	   		        	          }
	   		        	        }
	   		        	      });
	   	        	 }
	   	        }
	   	    };
	   }]);
});