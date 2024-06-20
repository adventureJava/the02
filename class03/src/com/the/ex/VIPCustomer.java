package com.the.ex;

public class VIPCustomer extends Customer {
		public double priceRate=0;
		
		public VIPCustomer(String id, int point, double pointRate, double priceRate) {
			super(id, point, pointRate);
			this.priceRate=priceRate;
		}
		public void setPoint(Product p) {
			double resultPrice=p.getProductPrice()-(p.getProductPrice()*(priceRate/100));
			this.point+=(int)(p.getProductPrice()*(pointRate/100));
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", point=" + point + ", pointRate=" + pointRate + "]";
		}
		

	
}
