package com.touresbalon.oms.domain.oracle;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = -2915050585407862344L;

	public int idProducto ;

	public int idEspectaculo ;

	public String codigoProducto ;

	public String nombreProducto ;

	public String descripcionProducto ;

	public int idTarifaBoleta ;

	public int idTarifaTransporte ;

	public int idTarifaHospedaje ;

	public BigDecimal precio;
	
	public Producto(){
		
	}
	
	public Producto( String codigoProducto,String nombreProducto,
			String descripcionProducto,BigDecimal precio ){
		 this.codigoProducto= codigoProducto;
		 this.nombreProducto=nombreProducto;
		 this.descripcionProducto=descripcionProducto;
		 this.precio=precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdEspectaculo() {
		return idEspectaculo;
	}

	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
