package com.touresbalon.oms.orders.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CustomersVO {
	private BigDecimal price;
	private String custid;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
}
