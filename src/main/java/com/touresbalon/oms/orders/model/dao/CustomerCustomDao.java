package com.touresbalon.oms.orders.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Order;

@Repository
public interface CustomerCustomDao{
	
	public List<Order> findRankingCustomers(Date fechaInicial, Date fechaFinal );
}
