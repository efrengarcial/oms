define(["angular","controllers", "services/OrderService"], function(angular, controllers){

    controllers.controller('OrderController', ['$scope', '$routeParams', '$location','toaster','OrderService',
        function($scope, $routeParams, $location, toaster, OrderService) {
    	$scope.orders = [];
    	
    	$scope.headers = [
    	                  {
    	                      title: 'Orden Id',
    	                      value: 'orderid'
    	                  },
    	                  {
    	                      title: 'Comentarios',
    	                      value: 'comments'
    	                  },
    	                  {
    	                      title: 'Fecha Creacion',
    	                      value: 'orderDate'
    	                  },
    	                  {
    	                      title: 'Fecha Cierre',
    	                      value: 'endOrderDate'
    	                  },
    	                  {
    	                      title: 'Precio',
    	                      value: 'price'
    	                  },
    	                  {
    	                      title: 'Detalle Orden',
    	                      value: ''
    	                  }
    	                  
    	                  ];
    	
    	
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
		        if ($scope.codigoProducto != null) {
		             //$scope.product = $scope.producto.consultarProducto($scope.IdProducto);
		        	
		        	OrderService.findOrdersByNumberProduct.query({
		        	    paginaActual: $scope.filterCriteria.pageNumber, codigoProducto: $scope.codigoProducto}).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.orders = data;
		        			    //$scope.totalPages = data.TotalPaginas;
		        			    if ($scope.filterCriteria.pageNumber == 1) {
		        			        $scope.totalPages = 10;//data.TotalPaginas;
		        			        //$scope.store.setTotalPages($scope.totalPages);
		        			        $scope.ordenesCount = data.TotalRegistros;
		        			        //$scope.store.setOrdenesCount($scope.ordenesCount);
		        			    }
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);      	
		        } else if($scope.ordId != null){	
	        //	$rootScope.loading = true;
		        	OrderService.findOrdersByNumberOrder.query({
	        	    paginaActual: $scope.filterCriteria.pageNumber, ordId: $scope.ordId}).$promise.then(
	        			//success
	        			function(data){	  
	        				 $scope.orders=data;
	        				 //$rootScope.loading = false;
	        			    if ($scope.filterCriteria.pageNumber == 1) {
	        			        $scope.totalPages = 10;//data.TotalPaginas;
	        			        //$scope.store.setTotalPages($scope.totalPages);
	        			        $scope.ordenesCount = data.TotalRegistros;
	        			        //$scope.store.setOrdenesCount($scope.ordenesCount);
	        			    }
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