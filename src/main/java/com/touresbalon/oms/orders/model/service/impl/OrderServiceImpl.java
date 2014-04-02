package com.touresbalon.oms.orders.model.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.mgr.OrderManager;
import com.touresbalon.oms.orders.model.service.OrderService;

@Service("orderService") 
@WebService(endpointInterface="com.touresbalon.oms.orders.model.service.OrderService",serviceName = "OrderService",
targetNamespace = "http://www.touresbalon.com/oms/orders/1.0", portName = "OrderServicePort")
public class OrderServiceImpl  implements OrderService {
	@Autowired
	OrderManager orderManager;
	
	@Override
	@WebMethod
	public void updateStateOrder(String idOrder,String state) {
		Order order= orderManager.find(idOrder);
		order.setStatus(state);
		orderManager.update(order);
	}

	@Override
	@WebMethod
	public void createOreder(@WebParam(name = "Order") Order order) {
		orderManager.create(order);
	}

	@Override
	@WebMethod
	public Boolean validateOrder(@WebParam(name = "idOrder") Integer idOrder) {
		// TODO Validate Order
		return true;
	}
	
	
}
