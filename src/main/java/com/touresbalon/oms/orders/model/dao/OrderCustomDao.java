package com.touresbalon.oms.orders.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.dto.OrdenVO;
import com.touresbalon.oms.orders.model.entity.Order;

@Repository
public interface OrderCustomDao{

	public List<OrdenVO> findOrdersClosed(int paginaActual, Date dateIni, Date dateFin);
}
