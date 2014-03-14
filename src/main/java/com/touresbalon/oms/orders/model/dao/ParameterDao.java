package com.touresbalon.oms.orders.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.orders.model.entity.Parameter;

@Repository
public interface ParameterDao extends CrudRepository<Parameter, String> {

}
