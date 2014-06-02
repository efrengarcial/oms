package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TarifaBoleta")
public class TarifaBoleta  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTarifaBoleta;
	
	@Column(name="NombreTarifaBoleta")
	private String nombreTarifaBoleta;
	
	@Column(name="ValorTarifaBoleta")
	private Double valorTarifaBoleta;
	
	@Column(name="ValorProveedor")
	private Double valorProveedor;
	
	@ManyToOne
	@JoinColumn(name="IdBoleta")
	private Boleta boleta;
	
	public String getNombreTarifaBoleta() {
		return nombreTarifaBoleta;
	}
	public void setNombreTarifaBoleta(String nombreTarifaBoleta) {
		this.nombreTarifaBoleta = nombreTarifaBoleta;
	}
	public Double getValorTarifaBoleta() {
		return valorTarifaBoleta;
	}
	public void setValorTarifaBoleta(Double valorTarifaBoleta) {
		this.valorTarifaBoleta = valorTarifaBoleta;
	}
	public Double getValorProveedor() {
		return valorProveedor;
	}
	public void setValorProveedor(Double valorProveedor) {
		this.valorProveedor = valorProveedor;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	public int getIdTarifaBoleta() {
		return idTarifaBoleta;
	}
	public void setIdTarifaBoleta(int idTarifaBoleta) {
		this.idTarifaBoleta = idTarifaBoleta;
	}
}
