package com.touresbalon.oms.products.model.dao;

import com.touresbalon.oms.products.model.dto.ProductDto;

public interface ProductCustomDao{
	
	public ProductDto findProductos(String codProducto,String nomProducto,String desProducto);
}
