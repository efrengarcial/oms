package com.touresbalon.oms.product;

import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.config.RepositoryProductsConfig;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryProductsConfig.class)
public class ProductTest {
	@Autowired
	private ProductDao productDao;

	@Autowired
	public EspectaculoDao espectaculoDao;
	
	@Autowired
	public TarifaBoletaDao tarifaBoletaDao;
	
	@Autowired
	public TarifaTransporteDao tarifaTransporteDao;
	
	@Autowired
	public TarifaHospedajeDao tarifaHospedajeDao;

	@Test
	public void testCreateProduct() {
		Producto producto = new Producto();
		
		producto.setCodigoProducto("CODEFL");
		producto.setDescripcionProducto("Descripcion producto");
		Espectaculo espectaculo = espectaculoDao.findOne(1);
		producto.setEspectaculo(espectaculo);
		producto.setFechaInicial(Calendar.getInstance().getTime());
		producto.setFechaFinal(Calendar.getInstance().getTime());
		producto.setNombreProducto("Nombre producto");
		producto.setRutaImagen("/images");
		TarifaBoleta tarifaBoleta = tarifaBoletaDao.findOne(1);
		producto.setTarifaBoleta(tarifaBoleta);
		TarifaHospedaje tarifaHospedaje= tarifaHospedajeDao.findOne(30);
		producto.setTarifaHospedaje(tarifaHospedaje);
		TarifaTransporte tarifaTransporte = tarifaTransporteDao.findOne(50);
		producto.setTarifaTransporte(tarifaTransporte);
		producto = productDao.save(producto);
		//1,1,30,50
	}
	
	
	@Test
	public void testDeleteProduct() {
		Producto producto = productDao.findProductoByCodigo("CODEFL");
		if(producto!=null){
			productDao.delete(producto);
		}
	}

}
