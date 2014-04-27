package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, String> {
	//public List<Producto> findAll();
}
