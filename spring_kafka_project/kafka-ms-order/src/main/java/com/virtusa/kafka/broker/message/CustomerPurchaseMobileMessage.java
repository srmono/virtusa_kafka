package com.virtusa.kafka.broker.message;



public class CustomerPurchaseMobileMessage {
	public static class Location {
		private double latitude;
		private double longitude;

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		@Override
		public String toString() {
			return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
		}

		public Location(double latitude, double longitude) {
			super();
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public Location() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	private String purchaseNumber;
	private int purchaseAmount;
	private String mobileAppVersion;
	private String operationSystem;
	private Location location;

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getMobileAppVersion() {
		return mobileAppVersion;
	}

	public void setMobileAppVersion(String mobileAppVersion) {
		this.mobileAppVersion = mobileAppVersion;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String operationSystem) {
		this.operationSystem = operationSystem;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CustomerPurchaseMobileMessage(String purchaseNumber, int purchaseAmount, String mobileAppVersion,
			String operationSystem, Location location) {
		super();
		this.purchaseNumber = purchaseNumber;
		this.purchaseAmount = purchaseAmount;
		this.mobileAppVersion = mobileAppVersion;
		this.operationSystem = operationSystem;
		this.location = location;
	}

	public CustomerPurchaseMobileMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
