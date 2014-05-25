package com.touresbalon.oms.orders.model.mgr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.oms.orders.model.dao.CustomerDao;
import com.touresbalon.oms.orders.model.entity.Customer;

@Service
public class CustomerManager {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional(value="transactionManagerOrders") 
	public Customer find(String id){
		return customerDao.findOne(id);
	}
	
	@Transactional(value="transactionManagerOrders")
	public List<Customer> findAll(){
		return (List<Customer>)customerDao.findAll();
	}
	
	@Transactional(value="transactionManagerOrders") 
	public Customer findCustomerByIdentification(String identification){
		return customerDao.findCustomerByIdentification(identification);
	}
//	public List<Customer> findCustomerByProduct(String codProduct){
//		return customerDao.findCustomerByProduct(codProduct);
//	}	
	
}
