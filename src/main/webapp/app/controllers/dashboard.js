define(["angular","controllers", "services/StoryService"], function(angular, controllers){

    controllers.controller('dashboard', ['$rootScope',
        function($rootScope) {
    			
    	 //var getLogFn = common.logger.getLogFn;
         //var log = getLogFn(controllerId);

         var vm = this;
         vm.news = {
             title: 'Hot Towel Angular',
             description: 'Hot Towel Angular is a SPA template for Angular developers.'
         };
         vm.messageCount = 0;
         vm.people = [];
         vm.title = 'Dashboard';

         activate();

         function activate() {
            //var promises = [getMessageCount(), getPeople()];           
         }

         function getMessageCount() {
             return datacontext.getMessageCount().then(function (data) {
                 return vm.messageCount = data;
             });
         }

         function getPeople() {
             return datacontext.getPeople().then(function (data) {
                 return vm.people = data;
             });
         }
    	
      }]);
});