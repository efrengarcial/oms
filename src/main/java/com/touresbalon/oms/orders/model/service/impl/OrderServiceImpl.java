package com.touresbalon.oms.orders.model.service.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.service.OrderService;

@Service("orderService") 
@WebService(endpointInterface="com.touresbalon.oms.orders.model.service.OrderService",serviceName = "OrderService",
targetNamespace = "http://www.touresbalon.com/oms/orders/1.0", portName = "OrderServicePort")
public class OrderServiceImpl  implements OrderService {
		

	public String calculator(String nombre){
		return nombre + ".......OK";
	}
}
