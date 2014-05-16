package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String addrid;

	private String addressType;

	private String city;

	private String country;

	@Column(name="\"STATE\"")
	private String state;

	private String street;

	private String zip;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

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
	@JsonIgnore
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}