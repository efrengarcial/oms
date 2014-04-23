define(["angular", "services"], function(angular, services){

    services.factory('Order', function(){

		//----------------------------------------------------------------
		// product class
		function Order(ordid, comments, endorderdate, orderdate, price, status) {
		    this.ordid = ordid; // product code (SKU = stock keeping unit)
		    this.comments = comments;
		    this.endorderdate = endorderdate;
		    this.orderdate = orderdate;
		    this.price = price;
		    this.status=status;
		}
		
		// Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
		Order.prototype  = {
				getOrdid: function() {
	                return( this.ordid );
	            }, 
				getComments: function() {
	                return( this.comments );
	            }, 
				getEndorderdate: function() {
	                return( this.endorderdate );
	            }, 
				getOrderdate: function() {
	                return( this.orderdate );
	            }, 
				getPrice: function() {
	                return( this.price );
	            }, 
				getStatus: function() {
	                return( this.status );
	            } 
        };
		
		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Order );

    });
});