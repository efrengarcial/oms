package com.touresbalon.oms.products.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.products.model.dao.ProductoDao;
import com.touresbalon.oms.products.model.entity.Producto;

@Service
public class ProductoManager {

	@Autowired
	private ProductoDao productoDao;
		
	@Transactional 
	public Producto create(Producto producto){
		return productoDao.save(producto);
	}
	
	@Transactional 
	public void update(Producto producto){
		productoDao.save(producto);
	}
	public Producto find(String idProducto){
		return productoDao.findOne(idProducto);
	}
	
	public List<Producto> findAll(){
		return (List<Producto>)productoDao.findAll();
	}
}
