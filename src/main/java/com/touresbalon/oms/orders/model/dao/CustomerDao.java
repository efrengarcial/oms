package com.touresbalon.oms.orders.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, String> {
	
	@Query("SELECT o FROM Customer o WHERE o.identificacion = :identification")
	public Customer findCustomerByIdentification(@Param("identification") String identification);
	
	@Query("SELECT o FROM Customer o WHERE o.identificacion = :identification")
	public List<Customer> findCustomerByProduct(@Param("identification") String codigoProduct);
	
	
}
