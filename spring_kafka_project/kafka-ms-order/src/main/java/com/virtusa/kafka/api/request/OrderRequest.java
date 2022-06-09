package com.virtusa.kafka.api.request;

import java.util.List;

public class OrderRequest {

	private String orderLocation;
	private String creditCardNumber;
	private List<OrderItemRequest> items;

	public String getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public List<OrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemRequest> items) {
		this.items = items;
	}

	public OrderRequest(String orderLocation, String creditCardNumber, List<OrderItemRequest> items) {
		super();
		this.orderLocation = orderLocation;
		this.creditCardNumber = creditCardNumber;
		this.items = items;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderRequest [orderLocation=" + orderLocation + ", creditCardNumber=" + creditCardNumber + ", items="
				+ items + "]";
	}

}
