package com.virtusa.kafka.api.response;

public class PurchaseResponse {

	private String purchaseNumber;

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	@Override
	public String toString() {
		return "PurchaseResponse [purchaseNumber=" + purchaseNumber + "]";
	}

	public PurchaseResponse(String purchaseNumber) {
		super();
		this.purchaseNumber = purchaseNumber;
	}

	public PurchaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
