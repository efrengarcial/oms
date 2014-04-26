package com.touresbalon.oms.orders.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Item;
import com.touresbalon.oms.orders.model.entity.Order;

@Service
public class OrderManager {

	@Autowired OrderDao orderDao;
		
	@Transactional 
	public Order create(Order order){
		for (Item item : order.getItems()) {
			item.setOrder(order);
		}
		return orderDao.save(order);
	}
	
	@Transactional 
	public void update(String idOrder,String state){
		Order order= orderDao.findOne(idOrder);
		order.setStatus(state);
		orderDao.save(order);
	}
	
	public Order find(String id){
		return orderDao.findOne(id);
	}
	
	public List<Order> findAll(){
		return (List<Order>)orderDao.findAll();
	}
}
