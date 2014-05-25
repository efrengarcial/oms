package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the ITEMS database table.
 * 
 */
@Entity
@Table(name="ITEMS")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "com.touresbalon.framework.jpa.StringSequenceGenerator", 
						parameters = { @Parameter(name = "sequence", value = "SEQ_ORDERS") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STRING_SEQUENCE_GENERATOR")
	@Column(name="ITEMID")
	private String itemId;

	@Column(name="PRODID")
	private int prodId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ITEMDATE")
	private Date itemDate;

	@Column(name="PARTNUM")
	private String partNum;

	@Column(name="PRICE")
	private BigDecimal price;

	@Column(name="PRODUCTNAME")
	private String productName;

	@Column(name="QUANTITY")
	private BigDecimal quantity;
	
	@Column(name="CUSTID")
	private String custId;

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
	@JsonIgnore
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
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}