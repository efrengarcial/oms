package com.touresbalon.oms.orders.model.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.touresbalon.oms.orders.model.dao.OrderCustomDao;
import com.touresbalon.oms.orders.model.dto.OrdenVO;



public class OrderCustomDaoImpl implements OrderCustomDao {

	@PersistenceContext
	EntityManager em;
	
	public List<OrdenVO> findOrdersClosed(int paginaActual, Date dateIni, Date dateFin){
		
		return null;
	}
}
