package com.virtusa.kafka.broker.message;

public class DiscountMessage {

	private String discountCode;

	private int discountPercentage;

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public DiscountMessage(String discountCode, int discountPercentage) {
		super();
		this.discountCode = discountCode;
		this.discountPercentage = discountPercentage;
	}

	public DiscountMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
