package com.touresbalon.oms.products.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Boleta")
public class Boleta {
	@Id
	private int idBoleta;
	
	private String nombreBoleta;
	
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="IdCiudad")
	private Ciudad ciudad;
	
	public int getIdBoleta() {
		return idBoleta;
	}
	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}
	public String getNombreBoleta() {
		return nombreBoleta;
	}
	public void setNombreBoleta(String nombreBoleta) {
		this.nombreBoleta = nombreBoleta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
