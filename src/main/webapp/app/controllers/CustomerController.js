define(["angular","controllers", "services/CustomerService","services/Store","services/DataService"], function(angular, controllers){

    controllers.controller('CustomerController', ['$scope', '$routeParams', '$location','toaster','DataService','CustomerService','Store',
        function($scope, $routeParams, $location, toaster, DataService,CustomerService,Store) {
    	$scope.customers = [];
    	$scope.store = DataService.store;
    	$scope.headersCustomer = [
						{
						    title: 'Tipo Identificacion',
						    value: 'tipoIdentificacion'
						},          
						{
						    title: 'Identificación',
						    value: 'identificación'
						},
     	                {
    	                      title: 'Nombres',
    	                      value: 'fName'
    	                },
    	                {
    	                      title: 'Apellidos',
    	                      value: 'lName'
    	                },
    	                {
    	                      title: 'Tipo de cliente',
    	                      value: 'type'
    	                },
    	                {
    	                      title: 'Detalle Cliente',
    	                      value: ''
    	                }
    	                ];
    	
    	    $scope.save = function () {
    	    	$scope.customer.$save(function (order, headers) {
    	    		toaster.pop('success', "title", "Submitted Order");
    	        });
    	    };
    	    
	        $scope.buscarClientes= function () {
	        	console.log('Buscando clientes....');
	        	// use routing to pick the selected order
		        if ($scope.identificacion != null) {
		        //$rootScope.loading = true;	
		        CustomerService.findCustomerByIdentification.query({
		        	paginaActual: $scope.filterCriteria.pageNumber,
		        	identificacion: $scope.identificacion}).$promise.then(
		        			//success
		        			function( data ){	        				
		        			    $scope.customers = data;
		        			    $scope.store.setCustomers(data);
		        			    //$scope.totalPages = data.TotalPaginas;
		        			    if ($scope.filterCriteria.pageNumber == 1) {
		        			        $scope.totalPages = 10;//data.TotalPaginas;
		        			        //$scope.store.setTotalPages($scope.totalPages);
		        			        $scope.customersCount = data.TotalRegistros;
		        			        //$scope.store.setOrdenesCount($scope.ordenesCount);
		        			    }
		        			},
		        			//error
		        			function( error ){ 
		        			    toaster.pop('error', "Mensaje de Error", error.data);
		        			}
		        	);      	
		        } else if($scope.codigoProducto != null){	
		        	//$rootScope.loading = true;
		        	CustomerService.findCustomerByProduct.query({
		        	    paginaActual: $scope.filterCriteria.pageNumber, codigoProducto: $scope.codigoProducto}).$promise.then(
		        			//success
		        			function(data){	  
		        				 $scope.customers=data;
		        				 $scope.store.setCustomers(data);
		        			    if ($scope.filterCriteria.pageNumber == 1) {
		        			        $scope.totalPages = 10;//data.TotalPaginas;
		        			        //$scope.store.setTotalPages($scope.totalPages);
		        			        $scope.customersCount = data.TotalRegistros;
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
	            
		        }else{
		        	toaster.pop('error', "La busqueda se debe realizar por Código del producto o identificación del cliente", "");
		        }
	        	$scope.selectPage(1);
	        }; 
	        
	        $scope.buscarClientesProducto= function (fechaInicio,fechaFin) {
	        	console.log('Buscando ordenes cerradas....');
	        	$scope.selectPage(1);
	        };
	        
	        $scope.rankingCustomers= function () {
	        	console.log('Buscando clientes....');
	        	if ($scope.fechaInicio ==null || $scope.fechaInicio==""){
	        		toaster.pop('error', "Se debe ingresar una fecha de inicio para la busqueda del ranking de clientes", "");
	        	}else if ($scope.fechaFin ==null || $scope.fechaFin==""){
	        		toaster.pop('error', "Se debe ingresar una fecha de Fin para la busqueda de ranking de clientes", "");
	        	}else{
	        	
	        	CustomerService.findRankingCustomers.query({
	        		fechaInicio: $scope.fechaInicio, fechaFin : $scope.fechaFin}).$promise.then(
	        			//success
	        			function(data){	  
	        				 $scope.customers=data;
	        				 $scope.store.setOrders(data);
	        			    if ($scope.filterCriteria.pageNumber == 1) {
	        			        $scope.totalPages = 1;//data.TotalPaginas;
	        			        //$scope.store.setTotalPages($scope.totalPages);
	        			        $scope.customersCount = data.TotalRegistros;
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
	        	toaster.pop('success', "Ranking de clientes", "");
	        	$scope.selectPage(1);
	        }
	        
	        };
	        
	        //called when navigate to another page in the pagination
	        $scope.selectPage = function (page) {
	            $scope.filterCriteria.pageNumber = page;
	            $scope.fetchResult($scope);
	        };
	        
	        
	        //The function that is responsible of fetching the result from the server and setting the grid to the new result
	        $scope.fetchResult = function ($scope) {
	        	
	        	
	        };
	        
	        $scope.go = function ( path ) {
	        	  $location.path( path );
	        };
			
			if ($routeParams.custid != null) {
	            $scope.customer = $scope.store.getCustomer($routeParams.custid);
	        } 
			
	        //default criteria that will be sent to the server
	        $scope.filterCriteria = {
	            pageNumber: 1,
	            sortDir: 'asc',
	            sortedBy: 'Codigo'
	        };
	        
        }]);
});