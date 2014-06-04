package com.touresbalon.oms.orders.model.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class OrderDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ordId;

	private String comments;

	private Date endOrderDate;

	private Date orderDate;

	private BigDecimal price;

	private String status;
	
	private List<ItemDto> items;

	private String custId;
	
	private String showType;

	public OrderDto() {
	}
	
	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public Date getEndOrderDate() {
		return endOrderDate;
	}

	public void setEndOrderDate(Date endOrderDate) {
		this.endOrderDate = endOrderDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemDto> getItems() {
		return this.items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

}