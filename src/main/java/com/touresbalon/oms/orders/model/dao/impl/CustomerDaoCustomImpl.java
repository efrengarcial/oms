package com.touresbalon.oms.orders.model.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.touresbalon.oms.orders.model.dao.CustomerCustomDao;
import com.touresbalon.oms.orders.model.dto.CustomersVO;
import com.touresbalon.oms.orders.model.entity.Order;

public class CustomerDaoCustomImpl implements CustomerCustomDao {
	
	@PersistenceContext(unitName="ordersPersistenceUnit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Order> findRankingCustomers(Date fechaInicial, Date fechaFinal ){

		Query query =entityManager.createQuery("SELECT p.custid, p.price FROM Order p WHERE (p.endOrderDate BETWEEN :start AND :end)  order by p.price asc ");
					
		query.setParameter("start", fechaInicial, TemporalType.DATE);
		query.setParameter("end", fechaFinal, TemporalType.DATE);
		query.setMaxResults(5);
					
		List<CustomersVO> result = (List<CustomersVO>)query.getResultList();	
					
					return null;
	}	
}
