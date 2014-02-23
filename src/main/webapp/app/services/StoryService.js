define(["angular", "services"], function(angular, services){

    services.factory('Story', ['$resource',
        function($resource){
    	  var Story = $resource('/oms/api/v1/stories/:storyId', {storyId: '@id'});
          Story.prototype.isNew = function(){
              return (typeof(this.id) === 'undefined');
          };
          return Story;
        }
    ]);
});