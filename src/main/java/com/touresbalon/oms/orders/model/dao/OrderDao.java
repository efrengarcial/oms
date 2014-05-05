package com.touresbalon.oms.orders.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, String> {

	@Query("SELECT p FROM Order p WHERE p.ordId = :idOrden")
    public List<Order> consultarOrden(@Param("idOrden") String idOrden);
	
	
}
