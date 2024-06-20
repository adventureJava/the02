package com.the.ex;

public class Product {
	public String id="";
	public double price=0;
	public double discountRate=0;
		
	public Product(String id, double price, double discountRate) {
		this.id = id;
		this.price = price;
		this.discountRate = discountRate;
	}

	public double getProductPrice() {
		return price*(1-discountRate/100);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", discountRate=" + discountRate + "]";
	}
	

}
