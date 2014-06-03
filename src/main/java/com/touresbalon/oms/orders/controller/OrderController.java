package com.touresbalon.oms.orders.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.touresbalon.oms.orders.model.dto.OrdenVO;
import com.touresbalon.oms.orders.model.entity.Order;
import com.touresbalon.oms.orders.model.mgr.OrderManager;


@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired 
	OrderManager orderMgr;

	
	@RequestMapping(value = "/allOrders",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> allOrders() {
		return (List<Order>) orderMgr.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	void save(Order order){
		orderMgr.create(order);
	}
	
	@RequestMapping(value = "/findOrder", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Order consultarOrden(String ordId){
		return orderMgr.find(ordId);
	}
	
	@RequestMapping(value = "/findOrdersByNumberOrder",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> findOrdersByNumberOrder(int paginaActual, String ordId){
		return orderMgr.findOrdersByNumberOrder(ordId);
	}
	
	@RequestMapping(value = "/findOrdersByNumberProduct",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> findOrdersByNumberProduct(int paginaActual, int codigoProducto){
		return orderMgr.findOrdersByNumberProduct(codigoProducto);
	}
	
	@RequestMapping(value = "/findOrdersClosed",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<OrdenVO> findOrdersClosed(){
		return orderMgr.findOrdersClosed();
	}
	
	@RequestMapping(value = "/findCancelOrders",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> findCancelOrders(String ordId){
		return orderMgr.findCancelOrders(ordId);
	}
	
	@RequestMapping(value = "/cancelarOrden",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean cancelarOrden(String ordId){
		return true;
	}
	
	@RequestMapping(value = "/findRankingOpenOrders",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> findRankingOpenOrders(){
		return orderMgr.findRankingOpenOrders();
	}
	
	@RequestMapping(value = "/findRankingClosedOrders",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Order> findRankingClosedOrders(Date fechaInicio, Date fechaFinal){
		return orderMgr.findRankingClosedOrders(fechaInicio, fechaFinal);
	}
	
}
