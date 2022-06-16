package com.virtusa.kafka.broker.message;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderPatternMessage {

	private String itemName;
	private long totalItemAmount;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime orderDateTime;
	private String orderLocation;
	private String orderNumber;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getTotalItemAmount() {
		return totalItemAmount;
	}

	public void setTotalItemAmount(long totalItemAmount) {
		this.totalItemAmount = totalItemAmount;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

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

	@Override
	public String toString() {
		return "OrderPatternMessage [itemName=" + itemName + ", totalItemAmount=" + totalItemAmount + ", orderDateTime="
				+ orderDateTime + ", orderLocation=" + orderLocation + ", orderNumber=" + orderNumber + "]";
	}

}
