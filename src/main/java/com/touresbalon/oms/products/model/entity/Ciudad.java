package com.touresbalon.oms.products.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdCiudad;
	
	private String NombreCiudad;
	
	public int getIdCiudad() {
		return IdCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		IdCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return NombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		NombreCiudad = nombreCiudad;
	}
	
}
