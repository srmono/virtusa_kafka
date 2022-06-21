package com.virtusa.kafka.api.request;

public class CustomerPurchaseWebRequest {
	
	private int purchaseAmount;
	private String browser;
	private String operationSystem;
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOperationSystem() {
		return operationSystem;
	}
	public void setOperationSystem(String operationSystem) {
		this.operationSystem = operationSystem;
	}
	public CustomerPurchaseWebRequest(int purchaseAmount, String browser, String operationSystem) {
		super();
		this.purchaseAmount = purchaseAmount;
		this.browser = browser;
		this.operationSystem = operationSystem;
	}
	@Override
	public String toString() {
		return "CustomerPurchaseWebRequest [purchaseAmount=" + purchaseAmount + ", browser=" + browser
				+ ", operationSystem=" + operationSystem + "]";
	}
	public CustomerPurchaseWebRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
