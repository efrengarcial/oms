package com.touresbalon.oms.orders.model.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Order;

@Service
public class OrderManager {

	@Autowired
	OrderDao orderDao;
		
	public void create(Order order){
		orderDao.save(order);
	}
	
	public void update(Order order){
		orderDao.save(order);
	}
	
	public Order find(String id){
		return orderDao.findOne(id);
	}
}
