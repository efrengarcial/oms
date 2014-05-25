package com.touresbalon.oms.products.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.TipoEspectaculo;

@Repository
public interface TipoEspectaculoDao extends CrudRepository<TipoEspectaculo, Integer> {

}
