package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name="ITEMS")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String itemid;

	private String codprod;

	@Temporal(TemporalType.DATE)
	private Date itemdate;

	private String partnum;

	private BigDecimal price;

	private String productname;

	private BigDecimal quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDID")
	private Order order;

	public Item() {
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getCodprod() {
		return this.codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public Date getItemdate() {
		return this.itemdate;
	}

	public void setItemdate(Date itemdate) {
		this.itemdate = itemdate;
	}

	public String getPartnum() {
		return this.partnum;
	}

	public void setPartnum(String partnum) {
		this.partnum = partnum;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}