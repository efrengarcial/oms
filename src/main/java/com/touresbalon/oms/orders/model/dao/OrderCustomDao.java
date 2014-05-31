package com.touresbalon.oms.orders.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.dto.OrdenVO;

@Repository
public interface OrderCustomDao{

	public List<OrdenVO> findOrdersClosed(int paginaActual, Date dateIni, Date dateFin);
}
