package com.touresbalon.oms.customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.touresbalon.oms.config.RepositoryOrdersConfig;
import com.touresbalon.oms.orders.model.dao.CustomerDao;
import com.touresbalon.oms.orders.model.entity.Customer;
import com.touresbalon.oms.orders.model.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryOrdersConfig.class)
public class CustomersTest {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testfindRankingCustomers() {
		
		List<Customer> customers=customerDao.findCustomerByProduct("123");
		if(customers.size()>0){
			for (Customer customer : customers) {
				
			}
			
		}
	}
	

}
