package com.touresbalon.oms.products.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.dao.ProductDaoCustom;
import com.touresbalon.oms.products.model.entity.Producto;

@Repository
public class ProductDaoCustomImpl implements ProductDaoCustom {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Producto> queryProducts(String codProducto, String nomProducto,
			String desProducto, Integer paginaActual,Integer cantidadRegistros){
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("TraerProductos");
		query.setParameter("CodigoProducto", codProducto);
		query.setParameter("NombreProducto", nomProducto);
		query.setParameter("DescripcionProducto", desProducto);
		query.setParameter("PaginaActual", paginaActual);
		query.setParameter("CantidadRegistros", cantidadRegistros);
		query.execute();
		List<Producto> result = (List<Producto>)query.getResultList();
		return result;
	}
}