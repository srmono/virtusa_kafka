package com.virtusa.kafka;

public class Order {

	private String isbn;
	private String prodName;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Order(String isbn, String prodName) {
		super();
		this.isbn = isbn;
		this.prodName = prodName;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
