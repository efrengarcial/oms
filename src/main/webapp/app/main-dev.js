requirejs.config({

    baseUrl: './',

    paths: {
        app: 'app/app',
        jquery: "lib/jquery/jquery-2.0.3.min",    
        bootstrap : "lib/bootstrap/bootstrap.min",
        angular: "lib/angular/angular",
        "angular-resource": "lib/angular/angular-resource",
        "angular-route": "lib/angular/angular-route",        
        "angular-animate" : "lib/angular-animate/angular-animate.min",
        "angular-sanitize": "lib/angular-sanitize/angular-sanitize.min",
        "ng-grid" : "lib/ng-grid/ng-grid-2.0.7.min",
        "ui-bootstrap" :  "lib/ui-bootstrap/ui-bootstrap-tpls-0.10.0.min", 
        "toaster" :  "lib/toaster/toaster",
        layout : "app/layout/",
        controllers: "app/controllers",
        services: "app/services",   
        filters: "app/filters",  
        directives: "app/directives",  
        //models: "lib/models",
        //views: "lib/views"
    },
    shim: {
    	"bootstrap": {
          	deps: ["jquery"]
        },
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
        "angular-sanitize": {
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
