package com.the.ex;

public class Computer extends Product {
	public double Ram=0;

	public Computer(String id, double price, double discountRate,double Ram) {
		super(id, price, discountRate);
		this.Ram=Ram;
	}
	public double getProductPrice() {
		return super.getProductPrice()+Ram*20000;
	}
	@Override
	public String toString() {
		return "Computer [Ram=" + Ram + ", id=" + id + ", price=" + price + ", discountRate=" + discountRate + "]";
	}
	

}
