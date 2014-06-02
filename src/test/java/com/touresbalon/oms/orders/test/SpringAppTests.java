package com.touresbalon.oms.orders.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.touresbalon.oms.config.RepositoryProductsConfig;
import com.touresbalon.oms.products.model.dao.EspectaculoDao;
import com.touresbalon.oms.products.model.dao.ProductDao;
import com.touresbalon.oms.products.model.dao.TarifaBoletaDao;
import com.touresbalon.oms.products.model.dao.TarifaHospedajeDao;
import com.touresbalon.oms.products.model.dao.TarifaTransporteDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryProductsConfig.class)
public class SpringAppTests {
	
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
	public void testQueryProducts() {
		productDao.queryProducts("","", "Belg", 1,15);
	}
}