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
@Table(name="TarifaTransporte")
public class TarifaTransporte  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifaTransporte;
	
	private String nombreTarifaTransporte;
	
	private Double valorTarifaTransporte;
	
	@ManyToOne
	@JoinColumn(name="IdTransporte")
	private Transporte transporte;
	
	@ManyToOne
	@JoinColumn(name="IdCiudadOrigen")
	private Ciudad ciudadOrigen;
	
	@ManyToOne
	@JoinColumn(name="IdCiudadDestino")
	private Ciudad ciudadDestino;
	
	private Double valorProveedor;
	
	public Double getValorProveedor() {
		return this.valorProveedor;
	}
	public void setValorProveedor(Double valorProveedor) {
		this.valorProveedor = valorProveedor;
	}
	public Transporte getTransporte() {
		return this.transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public Double getValorTarifaTransporte() {
		return this.valorTarifaTransporte;
	}
	public void setValorTarifaTransporte(Double valorTarifaTransporte) {
		this.valorTarifaTransporte = valorTarifaTransporte;
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
		return this.ciudadOrigen;
	}
	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public Ciudad getCiudadDestino() {
		return this.ciudadDestino;
	}
	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
}
