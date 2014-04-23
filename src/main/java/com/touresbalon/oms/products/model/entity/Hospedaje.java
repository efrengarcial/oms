package com.touresbalon.oms.products.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Hospedaje database table.
 * 
 */
@Entity
@Table(name="Hospedaje")
public class Hospedaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHospedaje;

	private String correoElectronico;

	private String direccion;

	private int idCiudad;

	private String nombreHospedaje;

	private String telefono;

	public Hospedaje() {
	}

	public int getIdHospedaje() {
		return this.idHospedaje;
	}

	public void setIdHospedaje(int idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreHospedaje() {
		return this.nombreHospedaje;
	}

	public void setNombreHospedaje(String nombreHospedaje) {
		this.nombreHospedaje = nombreHospedaje;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}