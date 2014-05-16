package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, String> {
	
	@Query("SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto")
    public List<Producto> findByCodigo(@Param("codigoProducto") String codigoProducto);
	
	@Query("SELECT p FROM Producto p WHERE p.codigoProducto = :codProducto or p.nombreProducto = :nomProducto or p.descripcionProducto = :desProducto")
	public List<Producto> findProductos(@Param("codProducto") String codProducto, @Param("nomProducto") String nomProducto,
			@Param("desProducto") String desProducto);
		
	
	
	
}
