define(["angular", "controllers", "services/DataService", "services/ShoppingCart", "services/Store",
     "services/ProductoService", "services/Product", "services/UserService", "services/OrderService","services/ProductService"],
		function(angular, controllers){

	//http://nadeemkhedr.wordpress.com/2013/09/01/build-angularjs-grid-with-server-side-paging-sorting-filtering/
		    controllers.controller('StoreController', ['$scope', '$routeParams', 'toaster', 'DataService', 'Store',
                'ProductoService', '$location', '$rootScope', 'UserService', 'OrderService', 'ProductService',
        function ($scope, $routeParams, toaster, DataService, Store, ProductoService, $location, $rootScope, UserService, OrderService,ProductService) {
	    	
	        $scope.store = DataService.store;
	        $rootScope.cart = DataService.cart;
	        $rootScope.campaign = DataService.campaign;
	        $rootScope.isLogged = UserService.isLogged;

	        $scope.totalPages = $scope.store.getTotalPages();
	        $scope.productosCount = $scope.store.getProductosCount();
	        $scope.headers = [
            {
                title: 'Item',
                value: ''
            },
            {
                title: 'Codigo',
                value: 'codigoProducto'
            },
            {
                title: 'Nombre',
                value: 'nombreProducto'
            },
            {
                title: 'Espectaculo',
                value: 'nombre'
            },
            {
                title: 'Fecha',
                value: 'Fecha'
            },
            {
                title: 'Eliminar',
                value: ''
            },
            {
                title: 'Modificar',
                value: ''
            }];
                      


   	  	 $scope.init=function(){
   	  		if($scope.store.espectaculos.length==0){
   	  		ProductService.findAllEspectaculos.query({}).$promise.then(
   	  				function(data){	  
   	  					$scope.store.setEspectaculos(data);
   	  				});
   	  		}
   	  		if($scope.store.tarifaboletas.length==0){
   	  			ProductService.findAllTarifaBoleta.query({}).$promise.then(
   	  				function(data){	  
   	  					$scope.store.setTarifaBoleta(data);
   	  				});
   	  		}
   	  	    if($scope.store.tarifatransporte.length==0){
   	  		ProductService.findAllTarifaTransporte.query({}).$promise.then(
   	  				function(data){	  
   	  					$scope.store.setTarifaTransporte(data);
   	  				});
   	  	    }
   	  	    if($scope.store.tarifahospedaje.length==0){
   	  		ProductService.findAllTarifaHospedaje.query({}).$promise.then(
   	  				function(data){	  
   	  					$scope.store.setTarifaHospedaje(data);
   	  				});
   	  	    }
   	  	 };
            //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'Codigo'
	        };

	        //The function that is responsible of fetching the result from the server and setting the grid to the new result
	        $scope.fetchResult = function ($scope) {
	            $rootScope.loading = true;
                
	            ProductoService.consultarProductos.query({
	        	    paginaActual: $scope.filterCriteria.pageNumber, nombreProducto: $scope.nombre,
	        	     codigoProducto : $scope.codigo , descripcionProducto : $scope.descripcion , idEspectaculo :$scope.idEspectaculo }).$promise.then(
	        			//success
	        			function( data ){	        				
	        			    $scope.store.setProducts(data);	        			  
	        			    $rootScope.loading = false;
        			    	if ($scope.filterCriteria.pageNumber == 1) { 
	        			    	$scope.totalPages = 1;
	        			    	$scope.store.setTotalPages(1);
	        			        $scope.productosCount =  data.length;
	        			        $scope.store.setProductosCount($scope.productosCount);
	        			    }
	        			},
	        			//error
	        			function( error ){ 
	        			    toaster.pop('error', "Mensaje de Error", error.data.Message);
	        			    $rootScope.loading = false;
	        			    $scope.store.setProducts([]);
	        			    $scope.totalPages = 0;
	        			    $scope.productosCount = 0;
	        			    $scope.store.setTotalPages(0);
	        			    $scope.store.setProductosCount(0);
	        			}
	        	);      	
	        };

            //called when navigate to another page in the pagination
	        $scope.selectPage = function (page) {
	            $scope.filterCriteria.pageNumber = page;
	            $scope.fetchResult($scope);
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
	        //$scope.selectPage(1);

	
	        // use routing to pick the selected product
	        if ($routeParams.IdProducto != null) {
	            // $scope.product = $scope.store.getProduct($routeParams.codigoProducto);
	            ProductoService.ConsultarProducto.get({ id: $routeParams.IdProducto }).$promise.then(
	        			//success
	        			function( data ){	        				
	        			    $scope.product = data;
	        			},
	        			//error
	        			function( error ){ 
	        			    toaster.pop('error', "Mensaje de Error", error.data);
	        			}
	        	);      	
	        } 
	        $scope.init();
	        $scope.go = function ( path ) {
	        	  $location.path( path );
	        };

	        $scope.checkout = function () {
	            OrderService.procesarOrden(DataService.cart).
                    success(function(data, status) {
                        toaster.pop('success', "Su numero de ticket es: ", data);
                        console.log(data);
                    }).error(function (data, status) {
                        
                        toaster.pop('error', "Mensaje de Error", error.data);
                        console.log(data);
                    });   
	        }
	        
	        $scope.buscarProductos= function () {
	        	console.log('Buscando productos....');
	        	$scope.selectPage(1);
	        }; 
        }]);
});