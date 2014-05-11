package com.touresbalon.oms.orders.model.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.entity.Item;
import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.mgr.OrderManager;
import com.touresbalon.oms.orders.model.service.OrderService;

@Service("orderService") 
@WebService(endpointInterface="com.touresbalon.oms.orders.model.service.OrderService",serviceName = "OrderService",
targetNamespace = "http://www.touresbalon.com/oms/orders/1.0", portName = "OrderServicePort")
public class OrderServiceImpl  implements OrderService {
	
	@Autowired
	private OrderManager orderManager;
	
	@Override
	public void updateStateOrder(String idOrder,String state) {
		orderManager.update(idOrder,state);
	}

	@Override	
	public Order createOrder(Order order) {		
		Order orderCreated = orderManager.create(order);
		for (Item item : orderCreated.getItems()) {
			item.setOrder(null);
		}
		return orderCreated;
	}	
	
}
