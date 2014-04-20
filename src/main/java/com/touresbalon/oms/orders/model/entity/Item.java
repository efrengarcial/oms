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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDERS")
    @SequenceGenerator(name="SEQ_ORDERS",sequenceName="SEQ_ORDERS", allocationSize = 1)
	private String itemId;

	private int prodId;

	@Temporal(TemporalType.DATE)
	private Date itemDate;

	private String partNum;

	private BigDecimal price;

	private String productName;

	private BigDecimal quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDID")
	private Order order;

	public Item() {
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

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public int getProdId() {
		return prodId;
	}



	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}