package services.orders;

import org.junit.Before;
import org.junit.Test;

import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.service.OrderService;
import com.touresbalon.oms.orders.model.service.impl.OrderServiceImpl;

public class TestServiceOrders {
	
	@Before
	public void init() {
	}
	
	@Test
	public void TestNoneUserOffline() {
		OrderService wservice = new OrderServiceImpl();
		Order order = new Order();
		order.setComments("Coments test");
		order.setCustomer(null);
		order.setEndorderdate(null);
		order.setStatus("");
		wservice.createOrder(order);
	}
}
