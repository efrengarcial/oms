'use strict';

define(["angular", "angular-resource", "angular-route","ng-grid","ui-bootstrap","js/controllers", "js/services","js/filters","angular-animate",
      "toaster",  
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
        'toaster',
        'controllers',
        'services',
        'filters'        
    ]);

    omsApp.config(['$routeProvider',
      function($routeProvider) {
        $routeProvider
          //.when('/', {templateUrl: 'views/stories/list.html', controller: 'StoryListController'})
          .when('/', {templateUrl: 'views/oms/parametros.html', controller: 'ParametroListController'})
          .when('/table', {templateUrl: 'views/stories/table.html', controller: 'TableController'})
          .when('/grid', {templateUrl: 'views/stories/grid.html', controller: 'GridController'})
          .when('/stories/new', {templateUrl: 'views/stories/create.html', controller: 'StoryCreateController'})
          .when('/stories/:storyId', {templateUrl: 'views/stories/detail.html', controller: 'StoryDetailController'})         
          .otherwise({
            redirectTo: '/'
          });
      }]);
    
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