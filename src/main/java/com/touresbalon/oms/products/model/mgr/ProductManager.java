package com.touresbalon.oms.products.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.products.model.dao.ProductDao;
import com.touresbalon.oms.products.model.dao.TipoEspectaculoDao;
import com.touresbalon.oms.products.model.entity.Producto;
import com.touresbalon.oms.products.model.entity.TipoEspectaculo;

@Service
public class ProductManager {

	@Autowired
	public ProductDao productoDao;
	
//	@Autowired
//	public ProductCustomDao productCustomDao;
		
	//@Autowired
	//public TipoEspectaculoDao tipoEspectaculoDao;
	
	@Transactional(value="transactionManagerProduct")  
	public Producto create(Producto producto){
		return productoDao.save(producto);
	}
	@Transactional
	public void update(Producto producto){
		productoDao.save(producto);
	}
	//@Transactional(value="transactionManagerProduct") 
	public Producto find(int idProducto){
		return productoDao.findOne(idProducto);
	}
	public List<Producto>  findProductos(String codigoProducto,String nombreProducto, String descripcionProducto){
		return productoDao.findProductos(nombreProducto);
	}
	
	public List<Producto> findAll(){
		return (List<Producto>)productoDao.findAll();
	}
	
	public TipoEspectaculo findTipoEspectaculo(int idTipoEspectaculo){
		//return tipoEspectaculoDao.findOne(idTipoEspectaculo);
		return null;
	}
}
