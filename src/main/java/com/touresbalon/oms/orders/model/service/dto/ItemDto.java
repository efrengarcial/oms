package com.touresbalon.oms.orders.model.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class ItemDto implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String itemId;

	private int prodId;

	private Date itemDate;

	private String partNum;

	private BigDecimal price;

	private String productName;

	private BigDecimal quantity;
	
	private String custId;


	public ItemDto() {
	}	

	
	
	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public Date getItemDate() {
		return itemDate;
	}



	public void setItemDate(Date itemDate) {
		this.itemDate = itemDate;
	}



	public String getPartNum() {
		return partNum;
	}



	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}