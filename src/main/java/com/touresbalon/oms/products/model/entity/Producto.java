package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer idProducto;
	
	private String codigoProducto;
	
	private String nombreProducto;
	
	private String descripcionProducto;
	
	//private Espectaculo espectaculo;
	
//	private TarifaBoleta tarifaBoleta;
//	
//	private TarifaTransporte tarifaTransporte;
//	
//	private TarifaHospedaje tarifaHospedaje;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="FechaInicial")
//	private Date fechaInicial;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="FechaFinal")
//	private Date fechaFinal;
	
	//private String rutaImagen;
	
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

//	public String getRutaImagen() {
//		return rutaImagen;
//	}
//
//	public void setRutaImagen(String rutaImagen) {
//		this.rutaImagen = rutaImagen;
//	}

//	public Date getFechaInicial() {
//		return fechaInicial;
//	}
//
//	public void setFechaInicial(Date fechaInicial) {
//		this.fechaInicial = fechaInicial;
//	}
//
//	public Date getFechaFinal() {
//		return fechaFinal;
//	}

//	public void setFechaFinal(Date fechaFinal) {
//		FechaFinal = fechaFinal;
//	}

//	public Espectaculo getEspectaculo() {
//		return espectaculo;
//	}
//
//	public void setEspectaculo(Espectaculo espectaculo) {
//		this.espectaculo = espectaculo;
//	}

//	public TarifaBoleta getTarifaBoleta() {
//		return tarifaBoleta;
//	}
//
//	public void setTarifaBoleta(TarifaBoleta tarifaBoleta) {
//		this.tarifaBoleta = tarifaBoleta;
//	}
//
//	public TarifaTransporte getTarifaTransporte() {
//		return tarifaTransporte;
//	}
//
//	public void setTarifaTransporte(TarifaTransporte tarifaTransporte) {
//		this.tarifaTransporte = tarifaTransporte;
//	}
//
//	public TarifaHospedaje getTarifaHospedaje() {
//		return tarifaHospedaje;
//	}
//
//	public void setTarifaHospedaje(TarifaHospedaje tarifaHospedaje) {
//		this.tarifaHospedaje = tarifaHospedaje;
//	}
	
}