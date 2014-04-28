'use strict';

define("app",["angular", "angular-resource", "angular-route","ng-grid","ui-bootstrap","controllers", "services","filters","angular-animate",
        "angular-sanitize", "toaster", "layout/shell", "layout/sidebar","directives",
    "services/TokenService","controllers/StoryListController","controllers/StoryCreateController","controllers/StoryDetailController",
    "controllers/TableController","controllers/GridController","controllers/ModalInstanceCtrl","controllers/ParametroListController",
    "controllers/dashboard" , "controllers/StoreController","controllers/OrderController","controllers/SecurityController"
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
			    url: '/consultOrders',
			    config: {
			        templateUrl: 'app/views/orders/consultOrders.html',
			        title: 'Consultar Ordenes',
			        controller: 'OrderController',
			        settings: {
			            nav: 1,
			            content: '<i class="fa fa-dashboard"></i> Ordenes'
			        }
			    }
			}, 
            {
                url: '/',
                config: {
                    templateUrl: 'app/views/oms/dashboard.html',
                    title: 'dashboard',
                   //controller: 'dashboard',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-dashboard"></i> Dashboard'
                    }
                }
            }, {
                url: '/table',
                config: {
                    title: 'admin',
                    controller: 'TableController',
                    templateUrl: 'app/views/oms/admin.html',
                    settings: {
                        nav: 3,
                        content: '<i class="fa fa-lock"></i> Admin'
                    }
                }
            } ,   {
                url: '/param',
                config: {
                    templateUrl: 'app/views/oms/parametros.html',
                    title: 'parametros',
                    controller: 'ParametroListController',
                    settings: {
                        nav: 4,
                        content: '<i class="fa fa-dashboard"></i> Parametros'
                    }
                }
            },   {
                url: '/consultarProductos',
                config: {
                    templateUrl: 'app/views/productos/product.html',
                    title: 'Consultar Productos',                    
                    settings: {
                        nav: 5,
                        content: '<i class="fa fa-dashboard"></i>Consultar Productos'
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
                        nav: 6,
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
                        nav: 7,
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
                        nav: 8,
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
                        nav: 9,
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
                        nav: 10,
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