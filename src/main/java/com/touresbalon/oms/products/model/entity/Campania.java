package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


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
	
	@Temporal(TemporalType.DATE)
	private Timestamp fechaFinal;

	@Temporal(TemporalType.DATE)
	private Timestamp fechaInicial;

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

	public Timestamp getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Timestamp fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Timestamp getFechaInicial() {
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