package com.touresbalon.oms.orders.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.touresbalon.oms.config.RepositoryProductsConfig;
import com.touresbalon.oms.products.model.dao.ProductDao;
import com.touresbalon.oms.products.model.entity.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryProductsConfig.class)
public class SpringAppTests {
	
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testQueryProducts() {
		List<Producto> productos=productDao.queryProducts("","", "colombia", 1,15,null);
		if(productos.size()==0){
			
		}
	}
}