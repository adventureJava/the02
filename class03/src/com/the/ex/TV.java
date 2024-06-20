package com.the.ex;

public class TV extends Product {
	public double inch=10;
	public double fare=10000;
			
	@Override
	public String toString() {
		return "TV [inch=" + inch + ", fare=" + fare + ", id=" + id + ", price=" + price + ", discountRate="
				+ discountRate + "]";
	}
	
	

	public TV(String id, double price, double discountRate,double inch,double fare) {
		super(id, price, discountRate);
		this.inch=inch;
		this.fare=fare;
		
	}


	public double getProductPrice() {
		double returnValue=price*(1-discountRate/100);
		if(inch>=10) {
			returnValue+=fare;
		}
		return returnValue;
	}

}
