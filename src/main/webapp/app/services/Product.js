define(["angular", "services"], function(angular, services){

    services.factory('Product', function(){

		//----------------------------------------------------------------
		// product class
		function Product(sku, name, description, price, cal, carot, vitc, folate, potassium, fiber) {
		    this.sku = sku; // product code (SKU = stock keeping unit)
		    this.name = name;
		    this.description = description;
		    this.price = price;
		    this.cal = cal;
		    this.nutrients = {
		        "Carotenoid": carot,
		        "Vitamin C": vitc,
		        "Folates": folate,
		        "Potassium": potassium,
		        "Fiber": fiber
		    };
		}
		
		// Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
		Product.prototype  = {
				getSku: function() {
	                return( this.sku );
	            }, 
				getName: function() {
	                return( this.name );
	            }, 
				getDescription: function() {
	                return( this.description );
	            }, 
				getPrice: function() {
	                return( this.price );
	            }, 
				getCal: function() {
	                return( this.cal );
	            }, 
				getCarot: function() {
	                return( this.carot );
	            }, 
				getVitc: function() {
	                return( this.vitc );
	            }, 
				getFolate: function() {
	                return( this.folate );
	            }, 
				getPotassium: function() {
	                return( this.potassium );
	            }, 
				getFiber: function() {
	                return( this.fiber );
	            }           
        };
		
		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Product );

    });
});