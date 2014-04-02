package com.touresbalon.oms.orders.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, String> {

}
