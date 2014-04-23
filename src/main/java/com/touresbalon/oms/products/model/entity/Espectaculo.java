package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


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

	@Temporal(TemporalType.DATE)
	private Timestamp fechaFinal;

	@Temporal(TemporalType.DATE)
	private Timestamp fechaInicial;

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