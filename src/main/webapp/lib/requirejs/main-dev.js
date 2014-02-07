requirejs.config({

    baseUrl: './',

    paths: {
        app: 'js/app.js?(new Date()).getTime()',
        jquery: "lib/jquery/jquery-1.10.2.min",        
        angular: "lib/angular/angular",
        "angular-resource": "lib/angular/angular-resource",
        "angular-route": "lib/angular/angular-route",
        "ng-grid" : "lib/ng-grid/ng-grid-2.0.7.min",
        "ui-bootstrap" :  "lib/ui-bootstrap/ui-bootstrap-tpls-0.8.0",        
        "angular-animate" :  "lib/angular-animate/angular-animate.min",
        "toaster" :  "lib/toaster/toaster",
        controllers: "js/controllers/",
        services: "js/services/",
        filters: "js/filters/",       
        //models: "lib/models",
        //views: "lib/views"
    },
    shim: {
        "angular": {
            deps: ["jquery"],
            exports: "angular"
        },
        "angular-resource": {
            deps: ["angular"]
        },
        "angular-route": {
            deps: ["angular"]
        },
        "ng-grid": {
        	deps: ["angular"]
        },
        "ui-bootstrap": {
        	deps: ["angular"]
        },
        "angular-animate": {
        	deps: ["angular"]
        },
        "toaster": {
        	deps: ["angular-animate"]
        }
    }
});

requirejs([
    "app"
]);
