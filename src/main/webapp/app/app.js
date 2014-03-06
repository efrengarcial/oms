'use strict';

define("app",["angular", "angular-resource", "angular-route","ng-grid","ui-bootstrap","controllers", "services","filters","angular-animate",
        "angular-sanitize", "toaster", "layout/shell", "layout/sidebar","directives",
    "services/TokenService","controllers/StoryListController","controllers/StoryCreateController","controllers/StoryDetailController",
    "controllers/TableController","controllers/GridController","controllers/ModalInstanceCtrl","controllers/ParametroListController",
    "controllers/dashboard", "controllers/StoreController", "controllers/SecurityController"
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
            }
            //carrito de compras
            ,   {
                url: '/store',
                config: {
                    templateUrl: 'app/views/admincarrito/store.html',
                    title: 'Productos',
                    controller: 'StoreController',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-dashboard"></i> Productos'
                    }
                }
            }
            ,   {
                url: '/products/:codigoProducto',
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
            , {
                url: '/grid',
                config: {
                    templateUrl: 'app/views/stories/grid.html',
                    title: 'Grid',
                    controller: 'GridController',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-dashboard"></i> Grid'
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