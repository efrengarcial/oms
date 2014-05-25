package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDRID")
	private String addrid;

	@Column(name="ADDRESSTYPE")
	private String addressType;

	@Column(name="CITY")
	private String city;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="\"STATE\"")
	private String state;

	@Column(name="STREET")
	private String street;

	@Column(name="ZIP")
	private String zip;


	public Address() {
	}

	public String getAddrid() {
		return this.addrid;
	}

	public void setAddrid(String addrid) {
		this.addrid = addrid;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	

}