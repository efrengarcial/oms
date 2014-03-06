define(["angular", "services"], function(angular, services){

    services.factory('Store', function(Product){

		//----------------------------------------------------------------
		// store (contains the products)
		function Store() {
		    this.products = [];		    
		}
		
		// Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
		Store.prototype  = {
				
		};
		
		Store.prototype.getProduct = function (codigoProducto) {
		    for (var i = 0; i < this.products.length; i++) {
		        if (this.products[i].codigoProducto == codigoProducto)
		            return this.products[i];
		    }
		    return null;
		};
		
		Store.prototype.setProducts = function (products) {
			this.products= products;
		};
		
		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Store );

    });
});
