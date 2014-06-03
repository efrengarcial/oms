define(["angular", "services"], function(angular, services){

    services.factory('Store', function(Product){

		//----------------------------------------------------------------
		// store (contains the products)
		function Store() {
		    this.productos = [];	
		    this.orders = [];
		    this.cancelorders = [];
		    this.rankingopenorders = [];
		    this.customers = [];
		    this.espectaculos = [];
		    this.tarifaboletas=[];
		    this.tarifatransporte=[];
		    this.tarifahospedaje=[];
		    
		    this.totalPages = 0;
		    this.productosCount = 0;
		}
		
		// Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
		Store.prototype  = {
				
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
		
		Store.prototype.setCancelOrders = function (cancelorders) {
			this.cancelorders= cancelorders;
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
		
		Store.prototype.getProduct = function (codigoProducto) {
		    for (var i = 0; i < this.productos.length; i++) {
		        if (this.productos[i].codigoProducto == codigoProducto)
		            return this.productos[i];
		    }
		    return null;
		};
		
		Store.prototype.setProducts = function (productos) {
			this.productos= productos;
		};

		Store.prototype.getTotalPages = function () {
		    return this.totalPages;
		};


		Store.prototype.getProductosCount = function () {
		    return this.productosCount;
		};


		Store.prototype.setTotalPages = function (totalPages) {
		    this.totalPages = totalPages;
		};


		Store.prototype.setProductosCount = function (productosCount) {
		    this.productosCount = productosCount;
		};
		
		Store.prototype.setRankingopenorders = function (orders) {
		    this.rankingopenorders = orders;
		};

		

		 // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return( Store );

    });
});
