package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.TarifaBoleta;

@Repository
public interface TarifaBoletaDao extends CrudRepository<TarifaBoleta, Integer> {
	@Query("SELECT p FROM TarifaBoleta p where p.idTarifaBoleta < 50")
    public List<TarifaBoleta> findAllTarifaBoleta();

}
