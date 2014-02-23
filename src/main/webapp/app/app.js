'use strict';

define(["angular", "angular-resource", "angular-route","ng-grid","ui-bootstrap","js/controllers", "js/services","js/filters","angular-animate",
        "angular-sanitize", "toaster", "layout/shell", "layout/sidebar",
    "services/TokenService","controllers/StoryListController","controllers/StoryCreateController","controllers/StoryDetailController",
    "controllers/TableController","controllers/GridController","controllers/ModalInstanceCtrl","controllers/ParametroListController"
], function(angular){
    /* App Module */
    var omsApp = angular.module('omsApp', [
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

    /*omsApp.config(['$routeProvider',
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
    omsApp.constant('routes', getRoutes());
    
    // Configure the routes and route resolvers
    omsApp.config(['$routeProvider', 'routes', routeConfigurator]);
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
                    templateUrl: 'views/oms/parametros.html',
                    title: 'dashboard',
                    controller: 'ParametroListController',
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Dashboard'
                    }
                }
            }, {
                url: '/table',
                config: {
                    title: 'admin',
                    controller: 'TableController',
                    templateUrl: 'views/oms/admin.html',
                    settings: {
                        nav: 2,
                        content: '<i class="fa fa-lock"></i> Admin'
                    }
                }
            }
        ];
    }
    
    omsApp.run(['$http','Token','toaster', function run( $http, Token,toaster ){
        //For CSRF token compatibility with Django
        //$http.defaults.headers.post['X-CSRFToken'] = $cookies['csrftoken'];
    	Token.query({}, function(data, headers){
    	    var token =  headers('X-CSRF-TOKEN');
    	    $http.defaults.headers.post['X-CSRF-TOKEN']=token;
    	    toaster.pop('success', "title", "text");
    	});        
    }]);
    
    angular.bootstrap(document, ['omsApp']);
    return omsApp;
});