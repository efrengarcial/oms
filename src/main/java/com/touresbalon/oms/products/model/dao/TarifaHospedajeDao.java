package com.touresbalon.oms.products.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.touresbalon.oms.products.model.entity.TarifaHospedaje;

@Repository
public interface TarifaHospedajeDao extends CrudRepository<TarifaHospedaje, Integer> {
	
	@Query("SELECT p FROM TarifaHospedaje p where p.idTarifaHospedaje < 50")
    public List<TarifaHospedaje> findAllTarifaHospedaje();
}
