define(["angular","controllers", "services/OrderService","services/Order","services/Store","services/DataService"], function(angular, controllers){

    controllers.controller('OrderController', ['$scope', '$routeParams', '$location','toaster','OrderService','DataService', 'Store',
        function($scope, $routeParams, $location, toaster, OrderService,DataService, Store) {
    	$scope.orders = [];
    	$scope.store = DataService.store;
    	
    	$scope.headersOrder = [
    	        	                  {
    	        	                      title: 'Atributo',
    	        	                      value: ''
    	        	                  },
    	        	                  {
    	        	                      title: 'Valor',
    	        	                      value: ''
    	        	                  }
    	        	                  ];
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
    	
    	$scope.headersItem = [
    	                  {
    	                      title: 'Id Item',
    	                      value: 'itemId'
    	                  },
    	                  {
    	                      title: 'Id Producto',
    	                      value: 'prodId'
    	                  },
    	                  {
    	                      title: 'Nombre Producto',
    	                      value: 'productName'
    	                  },
    	                  {
    	                      title: 'Detalle del item',
    	                      value: ''
    	                  }
    	                  ];
    	
    	$scope.headersItemDetalle = [
        	                  {
        	                      title: 'Atributo',
        	                      value: ''
        	                  },
        	                  {
        	                      title: 'Valor',
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
	        
	        $scope.buscarOrdenesCerradas= function (fechaInicio,fechaFin) {
	        	console.log('Buscando ordenes cerradas....');
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
		        			    $scope.store.setOrders(data);
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
	        				 $scope.store.setOrders(data);
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
	        $scope.go = function ( path ) {
	        	  $location.path( path );
	        };
			
			if ($routeParams.ordId!=null && $routeParams.itemId != null) {
	            $scope.item = $scope.store.getItem($routeParams.ordId,$routeParams.itemId);
	        } 
			
			if ($routeParams.ordId != null) {
	            $scope.order = $scope.store.getOrder($routeParams.ordId);
	        } 
			
	        //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'Codigo'
	        };
	        
        }]);
});