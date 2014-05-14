define(["angular","controllers", "services/OrderService"], function(angular, controllers){

    controllers.controller('OrderController', ['$scope', '$routeParams', '$location','toaster','OrderService',
        function($scope, $routeParams, $location, toaster, OrderService) {
    	$scope.orders = [];
    	
    	    $scope.save = function () {
    	    	$scope.order.$save(function (order, headers) {
    	    		toaster.pop('success', "title", "Submitted Order");
    	        });
    	    };
    	    
	        $scope.buscarOrdenes= function () {
	        	console.log('Buscando ordenes....');
	        	$scope.selectPage(1);
	        }; 
	        
	        //called when navigate to another page in the pagination
	        $scope.selectPage = function (page) {
	            $scope.filterCriteria.pageNumber = page;
	            $scope.fetchResult($scope);
	        };
	        
	        
	        //The function that is responsible of fetching the result from the server and setting the grid to the new result
	        $scope.fetchResult = function ($scope) {
	        	
	        	// use routing to pick the selected order
		        if ($scope.ordId != null && $scope.ordId<0) {
		             //$scope.product = $scope.producto.consultarProducto($scope.IdProducto);
		        	
		            OrderService.consultarOrden.get({ordId: $scope.ordId }).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.orders = data;
		        			    $scope.totalPages = data.TotalPaginas;
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);      	
		        } else{	
	        //	$rootScope.loading = true;
		        	OrderService.consultarOrdenes.get({
	        	    paginaActual: $scope.filterCriteria.pageNumber, ordId: $scope.ordId,
	        	    codigoProducto :  $scope.codigo}).$promise.then(
	        			//success
	        			function( data ){	        				
	        			     $scope.orders=data;
	        				 $scope.totalPages = 10;
	        				 $scope.ordenesCount = 100;
	        			    //$rootScope.loading = false;
//	        			    if ($scope.filterCriteria.pageNumber == 1) {
//	        			        $scope.totalPages = 10;//data.TotalPaginas;
//	        			        //$scope.store.setTotalPages($scope.totalPages);
//	        			        $scope.ordenesCount = 100;//data.TotalRegistros;
//	        			        //$scope.store.setOrdenesCount($scope.ordenesCount);
//	        			    }
	        			},
	        			//error
	        			function( error ){ 
	        			    //toaster.pop('error', "Mensaje de Error", error.data.Message);
	        			   // $rootScope.loading = false;
	        			    //$scope.store.setProducts([]);
	        			    $scope.totalPages = 0;
	        			    $scope.ordenesCount = 0;
	        			    //$scope.store.setTotalPages(0);
	        			    //$scope.store.setProductosCount(0);
	        			}
	        	); 
	            
		        }
	            
	        };
	        
	        
	        
	        //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'Codigo'
	        };
	        
        }]);
});