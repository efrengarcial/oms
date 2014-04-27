package com.touresbalon.oms.orders.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, String> {

}
