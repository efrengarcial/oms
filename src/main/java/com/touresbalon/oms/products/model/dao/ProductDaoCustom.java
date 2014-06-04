package com.touresbalon.oms.products.model.dao;

import java.util.List;

import com.touresbalon.oms.products.model.entity.Producto;

public interface ProductDaoCustom{
	
	public List<Producto> queryProducts(String codProducto, String nomProducto,String desProducto, Integer paginaActual,Integer cantidadRegistros,Integer idEspectaculo);
	
	public void executeTop5(String i_cadena);
}
