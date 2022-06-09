package com.virtusa.kafka.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private int orderId; //order_id

	@Column
	private String orderNumber;

	@Column
	private String orderLocation;

	@Column
	private LocalDateTime orderDateTime;

	@Column
	private String creditCardNumber;

	@OneToMany
	private List<OrderItem> items;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Order(int orderId, String orderNumber, String orderLocation, LocalDateTime orderDateTime,
			String creditCardNumber, List<OrderItem> items) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderLocation = orderLocation;
		this.orderDateTime = orderDateTime;
		this.creditCardNumber = creditCardNumber;
		this.items = items;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderLocation=" + orderLocation
				+ ", orderDateTime=" + orderDateTime + ", creditCardNumber=" + creditCardNumber + ", items=" + items
				+ "]";
	}

}
