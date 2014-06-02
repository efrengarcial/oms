package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.Producto;

@Repository
public interface ProductDao extends CrudRepository<Producto, Integer>, ProductDaoCustom {
	
	@Query("SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto")
    public List<Producto> findByCodigo(@Param("codigoProducto") String codigoProducto);
	
	@Query("SELECT p FROM Producto p WHERE p.nombreProducto = :nomProducto")
	public List<Producto> findProductos(@Param("nomProducto") String nomProducto);
		
	@Query("SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto")
	public Producto findProductoByCodigo(@Param("codigoProducto") String codigoProducto);
}
