package com.touresbalon.oms.orders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.touresbalon.oms.orders.model.entity.Customer;
import com.touresbalon.oms.orders.model.mgr.CustomerManager;


@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired 
	CustomerManager customerMgr;

	
	@RequestMapping(value = "/allCustomers",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> allCustomers() {
		return (List<Customer>) customerMgr.findAll();
	}
	
	@RequestMapping(value = "/findCustomerByIdentification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> findCustomerByIdentification(int paginaActual, String identificacion){
		Customer cust=customerMgr.findCustomerByIdentification(identificacion);
		List<Customer> customers= new ArrayList<>();
		if(cust!=null){
			customers.add(cust);
		}
		return customers;
	}
	
	@RequestMapping(value = "/findCustomerByProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> findCustomerByProduct(int paginaActual,String codigoProducto){
		return null;
		//return customerMgr.findCustomerByProduct(codProduct);
	}
}
