package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TarifaHospedaje  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdTarifaHospedaje;
	
	private String NombreTarifaHospedaje;
	private Double valorTarifaHospedaje;
	private Double valorProveedor;
	
	private Hospedaje hospedaje;
	
	public String getNombreTarifaHospedaje() {
		return NombreTarifaHospedaje;
	}
	public void setNombreTarifaHospedaje(String nombreTarifaHospedaje) {
		NombreTarifaHospedaje = nombreTarifaHospedaje;
	}
	public int getIdTarifaHospedaje() {
		return IdTarifaHospedaje;
	}
	public void setIdTarifaHospedaje(int idTarifaHospedaje) {
		IdTarifaHospedaje = idTarifaHospedaje;
	}
	public Double getValorTarifaHospedaje() {
		return valorTarifaHospedaje;
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
