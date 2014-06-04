define(["angular","controllers","services/ProductoService", "services/ProductService","services/Store"], function(angular, controllers){

    controllers.controller('ProductController', ['$scope', '$routeParams', '$location','toaster','ProductService','DataService', 'Store','ProductoService','ProductFactory','$http',
        function($scope,  $routeParams, $location, toaster, ProductService,DataService, Store,ProductoService,ProductFactory,$http) {
    	  	$scope.products = [];
    	  	$scope.store = DataService.store;
    		//$scope.producto = new Producto();
    		
    	    $scope.save = function () {
    	    	
    	    	ProductService.createProduct.get({codigoProducto: $scope.product.codigoProducto, 
    	    		nombreProducto:$scope.product.nombreProducto,
    	    		descripcionProducto:$scope.product.descripcionProducto,
    	    		idEspectaculo:$scope.product.idEspectaculo.idEspectaculo,
    	    		idTarifaBoleta:$scope.product.idTarifaBoleta.idTarifaBoleta,
    	    		idTarifaTransporte:$scope.product.idTarifaTransporte.idTarifaTransporte,
    	    		idTarifaHospedaje:$scope.product.idTarifaHospedaje.idTarifaHospedaje,
    	    		rutaImagen:$scope.product.rutaImagen,
    	    		fechaFinal:$scope.product.fechaFinal,
    	    		fechaInicial:$scope.product.fechaInicial}).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.product = data;
		        			    $location.path('/store');
		        			    toaster.pop('success', "Su producto se ha agregado correctamente por favor consultar el producto con el identificador: ", data.idProducto);
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);  

    	    };
    	    
    	    
    	    $scope.update = function () {
    	    	
    	    	ProductService.updateProduct.get({idProducto: $scope.product.idProducto,
    	    		codigoProducto: $scope.product.codigoProducto, 
    	    		nombreProducto:$scope.product.nombreProducto,
    	    		descripcionProducto:$scope.product.descripcionProducto,
    	    		idEspectaculo:$scope.product.idEspectaculo.idEspectaculo,
    	    		idTarifaBoleta:$scope.product.idTarifaBoleta.idTarifaBoleta,
    	    		idTarifaTransporte:$scope.product.idTarifaTransporte.idTarifaTransporte,
    	    		idTarifaHospedaje:$scope.product.idTarifaHospedaje.idTarifaHospedaje,
    	    		rutaImagen:$scope.product.rutaImagen,
    	    		fechaFinal:$scope.product.fechaFinal,
    	    		fechaInicial:$scope.product.fechaInicial}).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.product = data;
		        			    $location.path('/store');
		        			    toaster.pop('success', "Su producto se ha actualizado correctamente por favor consultar el producto con el identificador: ", data.idProducto);
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);  

    	    };
    	    
    	    
    	    
	        $scope.buscarProductos= function () {
	        	console.log('Buscando productos....');
	        	$scope.selectPage(1);
	        }; 
	        
	        //called when navigate to another page in the pagination
	        $scope.selectPage = function (page) {
	            $scope.filterCriteria.pageNumber = page;
	            $scope.fetchResult($scope);
	        };
	        
	        
	        //The function that is responsible of fetching the result from the server and setting the grid to the new result
	        $scope.fetchResult = function ($scope) {
	        	
	        	// use routing to pick the selected product
		        if ($scope.IdProducto != null) {
		             //$scope.product = $scope.producto.consultarProducto($scope.IdProducto);
		        	
		            ProductService.consultarProducto.get({idProducto: $scope.IdProducto }).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.product = data;
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);      	
		        } else{	
	        //	$rootScope.loading = true;
	            ProductService.consultarProductos.get({
	        	    paginaActual: $scope.filterCriteria.pageNumber, codigoProducto :  $scope.codigo,
	        	    nombreProducto: $scope.nombre, descripcionProducto : $scope.descripcion }).$promise.then(
	        			//success
	        			function( data ){	        				
	        			    $scope.store.setProducts(data.InfoConsultaProductos);	        			  
	        			    //$rootScope.loading = false;
	        			    if ($scope.filterCriteria.pageNumber == 1) {
	        			        $scope.totalPages = data.TotalPaginas;
	        			        $scope.store.setTotalPages($scope.totalPages);
	        			        $scope.productosCount = data.TotalRegistros;
	        			        $scope.store.setProductosCount($scope.productosCount);
	        			    }
	        			},
	        			//error
	        			function( error ){ 
	        			    //toaster.pop('error', "Mensaje de Error", error.data.Message);
	        			   // $rootScope.loading = false;
	        			    //$scope.store.setProducts([]);
	        			    $scope.totalPages = 0;
	        			    $scope.productosCount = 0;
	        			    //$scope.store.setTotalPages(0);
	        			    //$scope.store.setProductosCount(0);
	        			}
	        	); 
	            
		        }
	            
	        };
	        
	        if ($routeParams.idProducto != null) {
	            $scope.product = $scope.store.getIdProduct($routeParams.idProducto);
	        }
	        
	        //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'Codigo'
	        };
	        
	        $scope.go = function ( path ) {
	        	  $location.path( path );
	        };
	        
        }]);
});