package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TarifaHospedaje")
public class TarifaHospedaje  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifaHospedaje;
	
	private String nombreTarifaHospedaje;
	private Double valorTarifaHospedaje;
	private Double valorProveedor;
	
	@ManyToOne
	@JoinColumn(name="IdHospedaje")
	private Hospedaje hospedaje;
	
	public String getNombreTarifaHospedaje() {
		return this.nombreTarifaHospedaje;
	}
	public void setNombreTarifaHospedaje(String nombreTarifaHospedaje) {
		this.nombreTarifaHospedaje = nombreTarifaHospedaje;
	}
	public int getIdTarifaHospedaje() {
		return this.idTarifaHospedaje;
	}
	public void setIdTarifaHospedaje(int idTarifaHospedaje) {
		this.idTarifaHospedaje = idTarifaHospedaje;
	}
	public Double getValorTarifaHospedaje() {
		return this.valorTarifaHospedaje;
	}
	public void setValorTarifaHospedaje(Double valorTarifaHospedaje) {
		this.valorTarifaHospedaje = valorTarifaHospedaje;
	}
	public Double getValorProveedor() {
		return valorProveedor;
	}
	public void setValorProveedor(Double valorProveedor) {
		this.valorProveedor = valorProveedor;
	}
	public Hospedaje getHospedaje() {
		return hospedaje;
	}
	public void setHospedaje(Hospedaje hospedaje) {
		this.hospedaje = hospedaje;
	}
}
