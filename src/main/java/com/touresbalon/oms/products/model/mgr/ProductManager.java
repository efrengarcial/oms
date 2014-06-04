package com.touresbalon.oms.products.model.mgr;

import java.util.Date;
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

	/***
	 * Execute top 5
	 * @param i_cadena
	 */
	public void queryProducts(String i_cadena){
		productDao.executeTop5(i_cadena);
	}
	
	public  Producto saveProduct(String codigoProducto,String nombreProducto,String descripcionProducto,int idEspectaculo,int idTarifaBoleta,int idTarifaTransporte,int idTarifaHospedaje,String rutaImagen,Date fechaFinal,Date fechaInicial)
	{
		Producto producto = getProducto(codigoProducto,nombreProducto,descripcionProducto,idEspectaculo,idTarifaBoleta,idTarifaTransporte,idTarifaHospedaje,rutaImagen,fechaFinal,fechaInicial);
		return productDao.save(producto);
	}
	
	public boolean delete(int idProducto)
	{
		Producto producto= productDao.findOne(idProducto);
		productDao.delete(producto);
		return true;
	}
	
	private Producto getProducto(String codigoProducto,String nombreProducto,String descripcionProducto,int idEspectaculo,int idTarifaBoleta,int idTarifaTransporte,int idTarifaHospedaje,String rutaImagen,Date fechaFinal,Date fechaInicial){
		Producto producto= new Producto();
		producto.setCodigoProducto(codigoProducto);
		producto.setNombreProducto(nombreProducto);
		producto.setDescripcionProducto(descripcionProducto);
		Espectaculo espectaculo=espectaculoDao.findOne(idEspectaculo);
		producto.setEspectaculo(espectaculo);
		TarifaBoleta tarifaBoleta = tarifaBoletaDao.findOne(idTarifaBoleta);
		producto.setTarifaBoleta(tarifaBoleta);
		TarifaTransporte tarifaTransporte = tarifaTransporteDao.findOne(idTarifaTransporte);
		producto.setTarifaTransporte(tarifaTransporte);
		TarifaHospedaje tarifaHospedaje = tarifaHospedajeDao.findOne(idTarifaHospedaje);
		producto.setTarifaHospedaje(tarifaHospedaje);
		producto.setRutaImagen(rutaImagen);
		producto.setFechaInicial(fechaInicial);
		producto.setFechaFinal(fechaFinal);
		return producto;
		
	}
}
