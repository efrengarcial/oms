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
		)
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

	@Transient
	private int idEspectaculo;
	
	@ManyToOne
	@JoinColumn(name="IdTarifaBoleta")
	private TarifaBoleta tarifaBoleta;
	
	@Transient
	private int idTarifaBoleta;
	
	@ManyToOne
	@JoinColumn(name="IdTarifaTransporte")
	private TarifaTransporte tarifaTransporte;
	
	@Transient
	private int idTarifaTransporte;
	
	@ManyToOne
	@JoinColumn(name="IdTarifaHospedaje")
	private TarifaHospedaje tarifaHospedaje;
	
	@Transient
	private int idTarifaHospedaje;
	
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