package com.touresbalon.oms.products.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPOESPECTACULO")
public class TipoEspectaculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoEspectaculo;
	
	private String nombreTipoEspectaculo;
	
	public int getIdTipoEspectaculo() {
		return idTipoEspectaculo;
	}
	public void setIdTipoEspectaculo(int idTipoEspectaculo) {
		this.idTipoEspectaculo = idTipoEspectaculo;
	}
	public String getNombreTipoEspectaculo() {
		return nombreTipoEspectaculo;
	}
	public void setNombreTipoEspectaculo(String nombreTipoEspectaculo) {
		this.nombreTipoEspectaculo = nombreTipoEspectaculo;
	}
	
}
