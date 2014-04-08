package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    private String custId;
    
	private String fName;
    
    private String lName;
    
    private String phoneNumber;
    
    private String email;
    
    private String password;
    
    private String credicardType;
    
    private String credicardNumber;
    
    private String status;
    
    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCredicardType() {
		return credicardType;
	}

	public void setCredicardType(String credicardType) {
		this.credicardType = credicardType;
	}

	public String getCredicardNumber() {
		return credicardNumber;
	}

	public void setCredicardNumber(String credicardNumber) {
		this.credicardNumber = credicardNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    }
