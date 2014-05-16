package com.touresbalon.oms.orders.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.orders.model.dao.CustomerDao;
import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.entity.Customer;
import com.touresbalon.oms.orders.model.entity.Item;
import com.touresbalon.oms.orders.model.entity.Order;

@Service
public class OrderManager {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
		
	@Transactional(value="transactionManagerOrders") 
	public Order create(Order order){
		if (order.getItems() !=null) {
			for (Item item : order.getItems()) {
				item.setOrder(order);
			}
		}
		Customer customer = customerDao.findOne(order.getCustomer().getCustid());
		order.setCustomer(customer);		
		return  orderDao.save(order);		
	}
	
	@Transactional(value="transactionManagerOrders") 
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
	
	@Transactional(value="transactionManagerOrders") 
	public List<Order> findOrdersByNumberOrder(String idOrden){
		return orderDao.findOrdersByNumberOrder(idOrden);
	}
	
	@Transactional(value="transactionManagerOrders") 
	public List<Order> findOrdersByNumberProduct(String codProduct){
		return orderDao.findOrdersByNumberProduct(codProduct);
	}
}
