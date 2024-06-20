package com.the.ex;

public class Customer {
	
	public String id="";
	public int point=0;
	public double pointRate=0;
	public void setPoint(Product p) {
		this.point=(int)(p.getProductPrice()*(pointRate/100));
	}
	public Customer(String id, int point, double pointRate) {
		this.id = id;
		this.point = point;
		this.pointRate = pointRate;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", point=" + point + ", pointRate=" + pointRate + "]";
	}
	

}
