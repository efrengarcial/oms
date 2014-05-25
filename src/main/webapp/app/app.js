'use strict';

define("app",["angular", "angular-resource", "angular-route","ng-grid","ui-bootstrap","controllers", "services","filters","angular-animate",
        "angular-sanitize", "toaster", "layout/shell", "layout/sidebar","directives",
    "services/TokenService","controllers/StoryListController","controllers/StoryCreateController","controllers/StoryDetailController",
    "controllers/TableController","controllers/GridController","controllers/ModalInstanceCtrl","controllers/ParametroListController",
    "controllers/dashboard" , "controllers/StoreController","controllers/OrderController","services/OrderService","controllers/SecurityController",
    "controllers/ProductController","services/CustomerService","controllers/CustomerController"
], function(angular){
    /* App Module */
    var app = angular.module('app', [
        'ngResource',
        'ngRoute', 
        'ngGrid',        
        'ui.bootstrap',
        'ngAnimate',
        'ngSanitize',
        'toaster',
        'controllers',
        'services',
        'filters'        
    ]);

    /*app.config(['$routeProvider',
      function($routeProvider) {    
        $routeProvider
          //.when('/', {templateUrl: 'views/stories/list.html', controller: 'StoryListController'})
          .when('/', {templateUrl: 'views/oms/parametros.html', controller: 'ParametroListController'})
          //.when('/table', {templateUrl: 'views/stories/table.html', controller: 'TableController'})
          .when('/table', {templateUrl: 'views/oms/admin.html', controller: 'TableController'})
          .when('/grid', {templateUrl: 'views/stories/grid.html', controller: 'GridController'})
          .when('/stories/new', {templateUrl: 'views/stories/create.html', controller: 'StoryCreateController'})
          .when('/stories/:storyId', {templateUrl: 'views/stories/detail.html', controller: 'StoryDetailController'})         
          .otherwise({
            redirectTo: '/'
          }); 
      }]); */
    
    // Collect the routes
    app.constant('routes', getRoutes());
    
    // Configure the routes and route resolvers
    app.config(['$routeProvider', 'routes', routeConfigurator]);
    function routeConfigurator($routeProvider, routes) {

        routes.forEach(function (r) {
            $routeProvider.when(r.url, r.config);
        });
        $routeProvider.otherwise({ redirectTo: '/' });
    }
    
    // Define the routes 
    function getRoutes() {
        return [
			//Ordenes 
            {
                url: '/',
                config: {
                    templateUrl: 'app/views/oms/dashboard.html',
                    title: 'dashboard',
                   //controller: 'dashboard',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Dashboard'
                    }
                }
            },		{
			    url: '/order',
			    config: {
			        templateUrl: 'app/views/orders/consultarOrdenes.html',
			        title: 'Consultar Ordenes',
			        controller: 'OrderController',
			        settings: {
			            nav: 2,
			            content: '<i class="fa fa-dashboard"></i> Consulta de Ordenes'
			        }
			    }
			},
			{
                url: '/orders/:fechaInicio',
                config: {
                    templateUrl: 'app/views/orders/ordenesCerradas.html',                    
                    controller: 'OrderController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> xxxxxxx'
                    }
                }
            },
            {
                url: '/order/:ordId',
                config: {
                    templateUrl: 'app/views/orders/orden.html',                    
                    controller: 'OrderController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> xxxxxxx'
                    }
                }
            },
            {//Cliente
                url: '/customer/:ordId',
                config: {
                    templateUrl: 'app/views/orders/customer.html',                    
                    controller: 'OrderController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i>Customer'
                    }
                }
            },
            {//item
                url: '/item/:ordId/:itemId',
                config: {
                    templateUrl: 'app/views/orders/item.html',                    
                    controller: 'OrderController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> item'
                    }
                }
            },
            {
                url: '/ords',
                config: {
                    templateUrl: 'app/views/orders/orden.html',                    
                    controller: 'OrderController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> orders'
                    }
                }
            },//Productos
            {
                url: '/consultarProductos',
                config: {
                    templateUrl: 'app/views/productos/consultarProductos.html',
                    title: 'Consultar Productos',   
                    controller: 'ProductController',
                    settings: {
                        nav: 3,
                        content: '<i class="fa fa-dashboard"></i>Consultar Productos'
                    }
                }
            },
            {
                url: '/product',
                config: {
                    templateUrl: 'app/views/productos/producto.html',
                    title: 'Producto',
                    controller: 'ProductController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> Crud Products'
                    }
                }
            },
            {//Clientes
                url: '/customers',
                config: {
                    templateUrl: 'app/views/customer/consultaClientes.html',
                    title: 'Customer',
                    controller: 'CustomerController',
                    settings: {
                        nav: 4,
                        content: '<i class="fa fa-dashboard"></i> Consulta de clientes'
                    }
                }
            },
            {
                url: '/customers/:custid',
                config: {
                    templateUrl: 'app/views/customer/customer.html',                    
                    controller: 'CustomerController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i>Customer'
                    }
                }
            },
            {
                url: '/table',
                config: {
                    title: 'admin',
                    controller: 'TableController',
                    templateUrl: 'app/views/oms/admin.html',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-lock"></i> Admin'
                    }
                }
            }
            //carrito de compras
            ,   {
                url: '/store',
                config: {
                    templateUrl: 'app/views/admincarrito/store.html',
                    title: 'Productos',
                    controller: 'StoreController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> Productos'
                    }
                }
            }
            ,   {
                url: '/products/:productSku',
                config: {
                    templateUrl: 'app/views/admincarrito/product.html',                    
                    controller: 'StoreController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> xxxxxxx'
                    }
                }
            }
            ,   {
                url: '/cart',
                config: {
                    templateUrl: 'app/views/admincarrito/shoppingCart.html',                   
                    controller: 'StoreController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> xxxxxxx'
                    }
                }
            }
            ,   {
                url: '/stories',
                config: {
                    templateUrl: 'app/views/stories/list.html',                   
                    controller: 'StoryListController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> Stories'
                    }
                }
            }
            ,   {
                url: '/stories/new',
                config: {
                    templateUrl: 'app/views/stories/create.html',                   
                    controller: 'StoryCreateController',
                    settings: {
                        nav: null,
                        content: '<i class="fa fa-dashboard"></i> Stories'
                    }
                }
            }
        ];
    }
    
    app.run(['$http','Token','toaster','$log', function run( $http, Token,toaster,$log ){
        //For CSRF token compatibility with Django
        //$http.defaults.headers.post['X-CSRFToken'] = $cookies['csrftoken'];
    	Token.query({}, function(data, headers){
    	    var token =  headers('X-CSRF-TOKEN');
    	    $http.defaults.headers.post['X-CSRF-TOKEN']=token;
    	    toaster.pop('success', "title", "text");
    	});        
    }]);   
    

    
    angular.bootstrap(document, ['app']);
    return app;
});