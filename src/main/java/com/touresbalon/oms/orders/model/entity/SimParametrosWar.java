package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SIM_PARAMETROS_WAR database table.
 * 
 */
@Entity
@Table(name="SIM_PARAMETROS_WAR")
public class SimParametrosWar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nombre;

	private String descripcion;

	private String valor;

	public SimParametrosWar() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}