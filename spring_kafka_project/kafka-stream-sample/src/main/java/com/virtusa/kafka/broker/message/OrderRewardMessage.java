package com.virtusa.kafka.broker.message;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderRewardMessage {

	private String orderLocation;
	private String orderNumber;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime orderDateTime;

	private String itemName;
	private int price;
	private int quantity;

	public String getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderRewardMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRewardMessage(String orderLocation, String orderNumber, LocalDateTime orderDateTime, String itemName,
			int price, int quantity) {
		super();
		this.orderLocation = orderLocation;
		this.orderNumber = orderNumber;
		this.orderDateTime = orderDateTime;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderMessage [orderLocation=" + orderLocation + ", orderNumber=" + orderNumber + ",  orderDateTime="
				+ orderDateTime + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
