package com.touresbalon.oms.repository.oracle;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.domain.oracle.Parametro;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, String> {

}
