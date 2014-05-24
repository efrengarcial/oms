package com.touresbalon.oms.products.model.entity;

import javax.persistence.Id;

public class TipoEspectaculo {
	@Id
	private int idTipoEspectaculo;
	
	private int nombreEspectaculo;
	
	public int getIdTipoEspectaculo() {
		return idTipoEspectaculo;
	}
	public void setIdTipoEspectaculo(int idTipoEspectaculo) {
		this.idTipoEspectaculo = idTipoEspectaculo;
	}
	public int getNombreEspectaculo() {
		return nombreEspectaculo;
	}
	public void setNombreEspectaculo(int nombreEspectaculo) {
		this.nombreEspectaculo = nombreEspectaculo;
	}
}
