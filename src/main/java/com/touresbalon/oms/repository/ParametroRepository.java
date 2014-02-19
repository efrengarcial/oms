package com.touresbalon.oms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.domain.Parametro;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, String> {

}
