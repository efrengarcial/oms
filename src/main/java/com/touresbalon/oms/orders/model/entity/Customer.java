package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTID")
	private String custid;

	@Column(name="CREDITCARDTYPE")
	private String creditCardType;

	@Column(name="CREDITCARDNUMBER")
	private String creditCardNumber;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FNAME")
	private String fName;

	@Column(name="LNAME")
	private String lName;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="PHONENUMBER")
	private String phoneNumber;

	@Column(name="STATUS")
	private String status;

	@Column(name="TYPE")
	private String type;

	//bi-directional many-to-one association to Address
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTID")
	private List<Address> addresses;



	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer() {
	}

	public String getCustid() {
		return this.custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}



	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
}