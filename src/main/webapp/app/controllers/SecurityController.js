define(["angular", "controllers", "services/SecutiryService", "services/UserService"], function (angular, controllers) {

    controllers.controller('SecurityController', ['$scope', 'Usuario', '$routeParams', 'toaster', 'UserService',
        function ($scope, Usuario, $routeParams, toaster, User) {
            $scope.showMenu = !User.isLogged;
            $scope.usuario = new Usuario();

            //http://plnkr.co/edit/lOCQi7?p=preview
            //http://nadeemkhedr.wordpress.com/2013/09/08/angularjs-validation-reusable-component/
            
            // function to submit the form after all validation has occurred			
            $scope.submitForm = function () {

                // check to make sure the form is completely valid
                if ($scope.userForm.$valid) {
                    $scope.usuario.$update().then(
    		          //success
    		          function( value ){
    		              $scope.usuario = value;
    		              $scope.showMenu = false;
    		              $scope.$apply();
    		              User.isLogged = true;
    		              User.userSession = value;
    		          },
    		          //error
    		          function( error ){ 
    		              toaster.pop('error', "Error", error.data);
    		              User.isLogged = false;
    		              User.userSession = null;
    		          }
    		   );    
                } else {
                    $scope.submitted = true;
                }

            };
        }]);
});