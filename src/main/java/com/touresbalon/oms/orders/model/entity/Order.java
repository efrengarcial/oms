package com.touresbalon.oms.orders.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Parameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

		
	@Id
	@GenericGenerator(name = "STRING_SEQUENCE_GENERATOR", strategy = "com.touresbalon.framework.jpa.StringSequenceGenerator", 
						parameters = { @Parameter(name = "sequence", value = "SEQ_ORDERS") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STRING_SEQUENCE_GENERATOR")
	@Column(name = "ORDID")
	private String ordId;

	@Column(name="COMMENTS")
	private String comments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ENDORDERDATE")
	private Date endOrderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ORDERDATE")
	private Date orderDate;

	@Column(name="PRICE")
	private BigDecimal price;

	@Column(name="STATUS")
	private String status;
	
	@Column(name="SHOWTYPE")
	private String showType;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Item> items;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTID")
	private Customer customer;

	public Order() {
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setOrder(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setOrder(null);

		return item;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}