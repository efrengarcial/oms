package com.touresbalon.oms.products.model.dao.impl;

import com.touresbalon.oms.products.model.dao.ProductCustomDao;
import com.touresbalon.oms.products.model.dto.ProductDto;

public class ProductCustomDaoImpl implements ProductCustomDao{
	
//	@PersistenceContext(type = PersistenceContextType.EXTENDED)  
//    private EntityManager entityManager;  
//	
	
	public ProductDto findProductos(String codProducto, String nomProducto,String desProducto){
		
		ProductDto rta= new ProductDto();
		rta.setNombre("nombreefl");
		return rta;
	}
}
