package com.touresbalon.oms.orders.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.dto.OrdenVO;
import com.touresbalon.oms.orders.model.entity.Order;

@Repository
public interface OrderCustomDao{

	public List<Order> findRankingOpenOrders();
	
	public List<Order> findRankingClosedOrders(String fechaInicial, String fechaFinal );
	
	public List<OrdenVO> findOrdersClosed();
	
	public Boolean cancelOrder(String idOrden);
	
	public List<Order> findRankingCustomers(String fechaInicial, String fechaFinal );
	
	
}
