package com.touresbalon.oms.products.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.products.model.dao.EspectaculoDao;
import com.touresbalon.oms.products.model.dao.ProductDao;
import com.touresbalon.oms.products.model.dao.TarifaBoletaDao;
import com.touresbalon.oms.products.model.dao.TarifaHospedajeDao;
import com.touresbalon.oms.products.model.dao.TarifaTransporteDao;
import com.touresbalon.oms.products.model.entity.Espectaculo;
import com.touresbalon.oms.products.model.entity.Producto;
import com.touresbalon.oms.products.model.entity.TarifaBoleta;
import com.touresbalon.oms.products.model.entity.TarifaHospedaje;
import com.touresbalon.oms.products.model.entity.TarifaTransporte;
import com.touresbalon.oms.products.model.entity.TipoEspectaculo;

@Service
public class ProductManager {

	@Autowired
	public ProductDao productDao;
	
	@Autowired
	public EspectaculoDao espectaculoDao;
	
	@Autowired
	public TarifaBoletaDao tarifaBoletaDao;
	
	@Autowired
	public TarifaTransporteDao tarifaTransporteDao;
	
	@Autowired
	public TarifaHospedajeDao tarifaHospedajeDao;
	
	//@Autowired
	//public TipoEspectaculoDao tipoEspectaculoDao;
	
	@Transactional(value="transactionManagerProduct")  
	public Producto create(Producto producto){
		return productDao.save(producto);
	}
	@Transactional
	public void update(Producto producto){
		productDao.save(producto);
	}
	public Producto find(int idProducto){
		return productDao.findOne(idProducto);
	}
	/***
	 * Consulta de productos 
	 * @param codigoProducto
	 * @param nombreProducto
	 * @param descripcionProducto
	 * @return
	 */
	public List<Producto> consultarProductos(int paginaActual, String codigoProducto, String nombreProducto, String descripcionProducto, Integer idEspectaculo){
		return productDao.queryProducts(codigoProducto,nombreProducto, descripcionProducto, paginaActual,10,idEspectaculo);
	}
	
	public List<Producto> findAll(){
		return (List<Producto>)productDao.findAll();
	}
	
	public TipoEspectaculo findTipoEspectaculo(int idTipoEspectaculo){
		//return tipoEspectaculoDao.findOne(idTipoEspectaculo);
		return null;
	}
	/**
	 * Obtener espectaculos
	 * @return
	 */
	public List<Espectaculo> findAllEspectaculos(){
		return (List<Espectaculo>) espectaculoDao.findAll();
	}
	
	/***
	 * Obtener tarifa boleta
	 * @return
	 */
	public List<TarifaBoleta> findAllTarifaBoleta(){
		return (List<TarifaBoleta>) tarifaBoletaDao.findAllTarifaBoleta();
	}
	/***
	 * Obtener tarifas transporte
	 * @return
	 */
	public List<TarifaTransporte> findAllTarifaTransporte(){
		return (List<TarifaTransporte>) tarifaTransporteDao.findAllTarifaTransporte();
	}
	/**
	 * Obtener Tarifa Hospedaje
	 * @return
	 */
	public List<TarifaHospedaje> findAllTarifaHospedaje(){
		return (List<TarifaHospedaje>) tarifaHospedajeDao.findAllTarifaHospedaje();
	}
	
}
