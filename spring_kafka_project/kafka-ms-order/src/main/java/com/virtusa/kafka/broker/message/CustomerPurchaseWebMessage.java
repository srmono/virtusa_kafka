package com.virtusa.kafka.broker.message;

public class CustomerPurchaseWebMessage {

	private String purchaseNumber;
	private int purchseAmount;
	private String browser;
	private String operatingSystem;

	public CustomerPurchaseWebMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPurchaseWebMessage(String purchaseNumber, int purchseAmount, String browser,
			String operatingSystem) {
		super();
		this.purchaseNumber = purchaseNumber;
		this.purchseAmount = purchseAmount;
		this.browser = browser;
		this.operatingSystem = operatingSystem;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public int getPurchseAmount() {
		return purchseAmount;
	}

	public void setPurchseAmount(int purchseAmount) {
		this.purchseAmount = purchseAmount;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
}
