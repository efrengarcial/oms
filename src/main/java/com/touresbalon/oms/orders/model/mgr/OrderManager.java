package com.touresbalon.oms.orders.model.mgr;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.orders.model.dao.CustomerDao;
import com.touresbalon.oms.orders.model.dao.OrderDao;
import com.touresbalon.oms.orders.model.dto.OrdenVO;
import com.touresbalon.oms.orders.model.entity.Customer;
import com.touresbalon.oms.orders.model.entity.Order;

@Service
public class OrderManager {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CustomerDao customerDao;
		
	@Transactional(value="transactionManagerOrders") 
	public Order create(Order order){
		Customer customer = customerDao.findOne(order.getCustId());
		order.setCustomer(customer);		
		return  orderDao.save(order);		
	}
	
	@Transactional(value="transactionManagerOrders") 
	public void update(Order order){
		orderDao.save(order);
	}
	 
	public Order find(String id){
		return orderDao.findOne(id);
	}
	
	public List<Order> findAll(){
		return (List<Order>)orderDao.findAll();
	}
	
	public List<Order> findOrdersByNumberOrder(String idOrden){
		return orderDao.findOrdersByNumberOrder(idOrden);
	}
	
	public List<Order> findOrdersByNumberProduct(int codProduct){
		return orderDao.findOrdersByNumberProduct(codProduct);
	}
	public List<Order> findCancelOrders(String idOrden){
		return orderDao.findCancelOrders(idOrden);
	}
	public List<Order> findRankingOpenOrders(){
		return orderDao.findRankingOpenOrders();
	}
	public List<Order> findRankingClosedOrders(Date fechaInicial, Date fechaFinal ){
		return orderDao.findRankingClosedOrders(fechaInicial,fechaFinal);
	}
	
	public List<OrdenVO> findOrdersClosed(){
		
		return orderDao.findOrdersClosed();
	}
}
