package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TarifaTransporte  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifaTransporte;
	
	private String nombreTarifaTransporte;
	private Double ValorTarifaTransporte;
	
	private Transporte transporte;
	private Ciudad ciudadOrigen;
	private Ciudad ciudadDestino;
	
	private Double ValorProveedor;
	
	public Double getValorProveedor() {
		return ValorProveedor;
	}
	public void setValorProveedor(Double valorProveedor) {
		ValorProveedor = valorProveedor;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public Double getValorTarifaTransporte() {
		return ValorTarifaTransporte;
	}
	public void setValorTarifaTransporte(Double valorTarifaTransporte) {
		ValorTarifaTransporte = valorTarifaTransporte;
	}
	public String getNombreTarifaTransporte() {
		return nombreTarifaTransporte;
	}
	public void setNombreTarifaTransporte(String nombreTarifaTransporte) {
		this.nombreTarifaTransporte = nombreTarifaTransporte;
	}
	public int getIdTarifaTransporte() {
		return idTarifaTransporte;
	}
	public void setIdTarifaTransporte(int idTarifaTransporte) {
		this.idTarifaTransporte = idTarifaTransporte;
	}
	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
}
