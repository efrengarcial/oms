package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.TarifaTransporte;

@Repository
public interface TarifaTransporteDao extends CrudRepository<TarifaTransporte, Integer> {
	
	@Query("SELECT p FROM TarifaTransporte p where p.idTarifaTransporte < 50")
    public List<TarifaTransporte> findAllTarifaTransporte();
}
