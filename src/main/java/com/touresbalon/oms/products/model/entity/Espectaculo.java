package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the Espectaculo database table.
 * 
 */
@Entity
@Table(name="Espectaculo")
public class Espectaculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEspectaculo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicial;

	private String nombreEspectaculo;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="IdCiudad")
	private Ciudad ciudad;

	public Espectaculo() {
	}

	public int getIdEspectaculo() {
		return this.idEspectaculo;
	}

	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
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

	public String getNombreEspectaculo() {
		return this.nombreEspectaculo;
	}

	public void setNombreEspectaculo(String nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}