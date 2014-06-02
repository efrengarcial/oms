package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.Espectaculo;

@Repository
public interface EspectaculoDao extends CrudRepository<Espectaculo, Integer> {
	@Query("SELECT p FROM Espectaculo p where p.idEspectaculo < 50")
    public List<Espectaculo> findAllEspectaculo();
}
