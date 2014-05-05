package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	private Integer idEspectaculo;
	private Integer idTarifaBoleta;
	private Integer idTarifaTransporte;
	private Integer idTarifaHospedaje;
	
	private String codigoProducto;

	private String nombreProducto;
	
	private String descripcionProducto;
		
	public Producto() {
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public String getDescripcionProducto() {
		return descripcionProducto;
	}


	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}


	public int getIdEspectaculo() {
		return idEspectaculo;
	}


	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}


	public int getIdTarifaBoleta() {
		return idTarifaBoleta;
	}


	public void setIdTarifaBoleta(int idTarifaBoleta) {
		this.idTarifaBoleta = idTarifaBoleta;
	}


	public int getIdTarifaTransporte() {
		return idTarifaTransporte;
	}


	public void setIdTarifaTransporte(int idTarifaTransporte) {
		this.idTarifaTransporte = idTarifaTransporte;
	}


	public int getIdTarifaHospedaje() {
		return idTarifaHospedaje;
	}


	public void setIdTarifaHospedaje(int idTarifaHospedaje) {
		this.idTarifaHospedaje = idTarifaHospedaje;
	}
	
}