define(["angular","controllers", "services/DataService",  "services/ShoppingCart", "services/Store" ,"services/Product"],
		function(angular, controllers){

	//http://nadeemkhedr.wordpress.com/2013/09/01/build-angularjs-grid-with-server-side-paging-sorting-filtering/
    controllers.controller('StoreController', ['$scope','$routeParams', 'toaster','DataService','Store','Product','$location',
        function($scope, $routeParams ,toaster,DataService,Store,Product,$location) {   
	    	 // get store and cart from service
	        $scope.store = DataService.store;
	        $scope.cart = DataService.cart;

	        $scope.totalPages = 10;
	        $scope.productosCount = 100;
	        $scope.headers = [
            {
                title: 'Item',
                value: ''
            },
            {
                title: 'Nombre',
                value: 'nombre'
            },
            {
                title: 'Precio',
                value: 'precio'
            },
            {
                title: '',
                value: ''
            }];
                      

            //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'codigo'
	        };

            //The function that is responsible of fetching the result from the server and setting the grid to the new result
	        $scope.fetchResult = function () {
	            return api.customers.search($scope.filterCriteria).then(function (data) {
	                $scope.customers = data.Customers;
	                $scope.totalPages = data.TotalPages;
	                $scope.customersCount = data.TotalItems;
	            }, function () {
	                $scope.customers = [];
	                $scope.totalPages = 0;
	                $scope.customersCount = 0;
	            });
	        };

            //called when navigate to another page in the pagination
	        $scope.selectPage = function (page) {
	            $scope.filterCriteria.pageNumber = page;
	            //$scope.fetchResult();
	        };

            //Will be called when filtering the grid, will reset the page number to one
	        $scope.filterResult = function () {
	            $scope.filterCriteria.pageNumber = 1;
	            $scope.fetchResult().then(function () {
	                //The request fires correctly but sometimes the ui doesn't update, that's a fix
	                $scope.filterCriteria.pageNumber = 1;
	            });
	        };

            //call back function that we passed to our custom directive sortBy, will be called when clicking on any field to sort
	        $scope.onSort = function (sortedBy, sortDir) {
	            $scope.filterCriteria.sortDir = sortDir;
	            $scope.filterCriteria.sortedBy = sortedBy;
	            $scope.filterCriteria.pageNumber = 1;
	            $scope.fetchResult().then(function () {
	                //The request fires correctly but sometimes the ui doesn't update, that's a fix
	                $scope.filterCriteria.pageNumber = 1;
	            });
	        };

            //manually select a page to trigger an ajax request to populate the grid on page load
	        $scope.selectPage(1);

	
	        // use routing to pick the selected product
	        if ($routeParams.productSku != null) {
	            $scope.product = $scope.store.getProduct($routeParams.productSku);
	        } 
	        
	        $scope.go = function ( path ) {
	        	  $location.path( path );
	        };
        }]);
});