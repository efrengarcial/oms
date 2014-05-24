package com.touresbalon.oms.orders.model.dto;

import java.util.Date;

public class OrdenVO {
	private Integer mes;
	private Integer dia;
	private Integer ano;
	private Date fecha;
	private Integer numeroOrdenesCerradas;
	private Double totalfacturado;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getNumeroOrdenesCerradas() {
		return numeroOrdenesCerradas;
	}
	public void setNumeroOrdenesCerradas(Integer numeroOrdenesCerradas) {
		this.numeroOrdenesCerradas = numeroOrdenesCerradas;
	}
	public Double getTotalfacturado() {
		return totalfacturado;
	}
	public void setTotalfacturado(Double totalfacturado) {
		this.totalfacturado = totalfacturado;
	}
}
