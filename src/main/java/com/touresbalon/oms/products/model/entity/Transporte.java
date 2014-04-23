package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Transporte database table.
 * 
 */
@Entity
@Table(name="Transporte")
public class Transporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransporte;

	private String nombreTransporte;

	public Transporte() {
	}

	public int getIdTransporte() {
		return this.idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getNombreTransporte() {
		return this.nombreTransporte;
	}

	public void setNombreTransporte(String nombreTransporte) {
		this.nombreTransporte = nombreTransporte;
	}

}