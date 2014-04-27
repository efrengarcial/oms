package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Campania database table.
 * 
 */
@Entity
@Table(name="Campania")
public class Campania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCampania")
	private int idCampania;

	private boolean estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicial;

	private String nombreCampania;

	public Campania() {
	}

	public int getIdCampania() {
		return this.idCampania;
	}

	public void setIdCampania(int idCampania) {
		this.idCampania = idCampania;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Timestamp fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getNombreCampania() {
		return this.nombreCampania;
	}

	public void setNombreCampania(String nombreCampania) {
		this.nombreCampania = nombreCampania;
	}

}