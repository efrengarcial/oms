package com.touresbalon.oms.orders.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.touresbalon.oms.config.RepositoryOrdersConfig;
import com.touresbalon.oms.orders.model.dao.CustomerDao;
import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Customer;
import com.touresbalon.oms.orders.model.entity.Item;
import com.touresbalon.oms.orders.model.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = RepositoryOrdersConfig.class)
public class OrderTest {
	
	@Autowired(required=true)
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Test
	public void testCreateOrder() {
		Order order = orderDtoToOrder();
		orderDao.save(order);
	}
	
	private Order orderDtoToOrder(){
		Order order = new Order();
		order.setOrdId("10000");
		order.setComments("Comentarios");
		Customer customer =customerDao.findOne("71");
		order.setCustId("71");
		order.setCustomer(customer);
		order.setEndOrderDate(Calendar.getInstance().getTime());
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setPrice(BigDecimal.valueOf(123));
		order.setStatus("EN_RESERVACION");
		
		List<Item>  items = new ArrayList<>();
		
			Item item  = new Item();
			item.setCustId("241");
			item.setItemDate(Calendar.getInstance().getTime());
			item.setOrder(order);
			item.setPartNum("PARTNUM");
			item.setPrice(BigDecimal.valueOf(123));
			item.setProdId(978);
			item.setProductName("name");
			item.setQuantity(BigDecimal.valueOf(123));
			item.setShowType("5");
			items.add(item);
		order.setItems(null);
		
		return order;
	}

}
