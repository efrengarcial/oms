package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the ORDERS database table.
 * 
 */

@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
		name = "TraerProductos",
		resultClasses = Producto.class,
		procedureName = "spTraerProductos",
		parameters = {
			@StoredProcedureParameter(mode=ParameterMode.IN, name="CodigoProducto", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="NombreProducto", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="DescripcionProducto", type=String.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="PaginaActual", type=Integer.class),
			@StoredProcedureParameter(mode=ParameterMode.IN, name="CantidadRegistros", type=Integer.class)//,
			//@StoredProcedureParameter(mode=ParameterMode.IN, name="IdEspectaculo", type=Integer.class)
		}
		),
		@NamedStoredProcedureQuery(
				name = "SpTop5",
				resultClasses = Producto.class,
				procedureName = "spTop5",
				parameters = {
					@StoredProcedureParameter(mode=ParameterMode.IN, name="i_cadena", type=String.class)})})
@Entity
@Table(name="Producto")
public class Producto implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	
	private String codigoProducto;
	
	private String nombreProducto;
	
	private String descripcionProducto;
	
	@ManyToOne
	@JoinColumn(name="IdEspectaculo")
	private Espectaculo espectaculo;
		
	@ManyToOne
	@JoinColumn(name="IdTarifaBoleta")
	private TarifaBoleta tarifaBoleta;
		
	@ManyToOne
	@JoinColumn(name="IdTarifaTransporte")
	private TarifaTransporte tarifaTransporte;
		
	@ManyToOne
	@JoinColumn(name="IdTarifaHospedaje")
	private TarifaHospedaje tarifaHospedaje;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FechaInicial")
	private Date fechaInicial;
	
	@Transient
	private int TotalRegistros;
	
	private String rutaImagen;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FechaFinal")
	private Date fechaFinal;
	
	public Producto() {
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

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Espectaculo getEspectaculo() {
		return this.espectaculo;
	}

	public void setEspectaculo(Espectaculo espectaculo) {
		this.espectaculo = espectaculo;
	}

	public TarifaBoleta getTarifaBoleta() {
		return this.tarifaBoleta;
	}

	public void setTarifaBoleta(TarifaBoleta tarifaBoleta) {
		this.tarifaBoleta = tarifaBoleta;
	}

	public TarifaTransporte getTarifaTransporte() {
		return this.tarifaTransporte;
	}
	public void setTarifaTransporte(TarifaTransporte tarifaTransporte) {
		this.tarifaTransporte = tarifaTransporte;
	}

	public TarifaHospedaje getTarifaHospedaje() {
		return this.tarifaHospedaje;
	}

	public void setTarifaHospedaje(TarifaHospedaje tarifaHospedaje) {
		this.tarifaHospedaje = tarifaHospedaje;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	

	public int getTotalRegistros() {
		return TotalRegistros;
	}

	public void setTotalRegistros(int totalRegistros) {
		this.TotalRegistros = totalRegistros;
	}

}