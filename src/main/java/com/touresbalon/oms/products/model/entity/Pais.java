package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Pais database table.
 * 
 */
@Entity
@Table(name="Pais")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPais;

	private String nombrePais;

	public Pais() {
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}