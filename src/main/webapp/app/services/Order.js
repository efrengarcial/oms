define(["angular", "services"], function(angular, services){

    services.factory('Order', function(){

		//----------------------------------------------------------------
		// product class
		function Order(ordId, comments, endOrderDate, orderDate, price, status, items, customer) {
		    this.ordId = ordId; // product code (SKU = stock keeping unit)
		    this.comments = comments;
		    this.endOrderDate = endOrderDate;
		    this.orderDate = orderDate;
		    this.price = price;
		    this.status=status;
		    this.items=items;
		    this.customer=customer;
		 }
		
		// Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
		Order.prototype  = {
				
				getOrdId: function() {
	                return( this.ordId );
	            }, 
				getComments: function() {
	                return( this.comments );
	            }, 
				getEndOrderDate: function() {
	                return( this.endOrderDate );
	            }, 
				getOrderDate: function() {
	                return( this.orderDate );
	            }, 
				getPrice: function() {
	                return( this.price );
	            }, 
				getStatus: function() {
	                return( this.status );
	            }, 
				getItems: function() {
	                return( this.items );
	            }, 
				getCustomer: function() {
	                return( this.customer );
	            }           
        };
		
		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Order );

    });
});