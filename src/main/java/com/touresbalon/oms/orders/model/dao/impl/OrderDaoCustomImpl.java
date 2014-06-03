package com.touresbalon.oms.orders.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.touresbalon.oms.orders.model.dao.OrderCustomDao;
import com.touresbalon.oms.orders.model.dto.OrdenVO;
import com.touresbalon.oms.orders.model.entity.Order;



public class OrderDaoCustomImpl implements OrderCustomDao {
	
	@PersistenceContext(unitName="ordersPersistenceUnit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Order> findRankingOpenOrders(){
		//SELECT * FROM ( (p.endorderdate is null ) and 'EN_RESERVACION'
		Query query =entityManager.createQuery("SELECT p FROM Order p WHERE (p.endOrderDate is null ) and (p.status= 'EN_RESERVACION' or p.status= 'EN_VALIDACION') order by p.orderDate asc ");//) WHERE ROWNUM <= 5");
					query.setMaxResults(5);
					List<Order> result = (List<Order>)query.getResultList();	
					return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> findRankingClosedOrders(Date fechaInicial, Date fechaFinal ){
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//		Date start=null;
//		Date end=null;
//		try {
//			start = formatter.parse(fechaInicial);
//			end=formatter.parse(fechaFinal);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Query query =entityManager.createQuery("SELECT p FROM Order p WHERE  (p.status= 'CERRADA') and (p.endOrderDate BETWEEN :start AND :end)  order by p.price asc ");
					query.setParameter("start", fechaInicial, TemporalType.DATE);
					query.setParameter("end", fechaFinal, TemporalType.DATE);
					query.setMaxResults(6);
					List<Order> result = (List<Order>)query.getResultList();	
					return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdenVO> findOrdersClosed(){
		OrdenVO orderVO = new OrdenVO();
		List<OrdenVO> listOrders= new ArrayList<>();
		
		return listOrders;
	}
}
