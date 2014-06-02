define(["angular", "services"], function(angular, services){

    services.factory('Store', function(Product){

		//----------------------------------------------------------------
		// store (contains the products)
		function Store() {
		    this.products = [];	
		    this.orders = [];
		    this.customers = [];
		    this.espectaculos = [];
		    this.tarifaboletas=[];
		    this.tarifatransporte=[];
		    this.tarifahospedaje=[];
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
		Store.prototype.getOrder = function (ordId) {
		    for (var i = 0; i < this.orders.length; i++) {
		        if (this.orders[i].ordId == ordId)
		            return this.orders[i];
		    }
		    return null;
		};
		
		Store.prototype.getItem = function (ordId,itemId) {
		    for (var i = 0; i < this.orders.length; i++) {
		        if (this.orders[i].ordId == ordId){
		        	for(var j=0; j<this.orders[i].items.length; j++){
		        		if (this.orders[i].items[j].itemId == itemId){
		        			return this.orders[i].items[j];
		        		}
		        	}
		        }
		    }
		    return null;
		};
		Store.prototype.getCustomer = function (custid) {
		    for (var i = 0; i < this.customers.length; i++) {
		        if (this.customers[i].custid == custid)
		            return this.customers[i];
		    }
		    return null;
		};
		
		Store.prototype.setOrders = function (orders) {
			this.orders= orders;
		};
		
		Store.prototype.setProducts = function (products) {
			this.products= products;
		};
		
		Store.prototype.setCustomers = function (customers) {
			this.customers= customers;
		};
		
		//Espectaculos
		Store.prototype.setEspectaculos = function (espectaculos) {
			this.espectaculos= espectaculos;
		};
		//Tarifa Boleta
		Store.prototype.setTarifaBoleta = function (tarifaboletas) {
			this.tarifaboletas= tarifaboletas;
		};
		
		Store.prototype.setTarifaTransporte = function (tarifatransporte) {
			this.tarifatransporte= tarifatransporte;
		};
		
		Store.prototype.setTarifaHospedaje = function (tarifahospedaje) {
			this.tarifahospedaje= tarifahospedaje;
		};
		
		
		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Store );

    });
});
