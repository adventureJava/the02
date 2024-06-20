package com.the.ex;
import com.the.ex.*;
import java.util.ArrayList;

public class MyProduct {

	public static void main(String[] args) {
		//사용자가 구매한 물품의 총합을 구하는 프로그램
		Product p1=new TV("LG",100000,10,40,10000);
		Product p2=new Computer("삼송",1000000,10,10);
//		System.out.println(p1.getProductPrice());
//		System.out.println(p2.getProductPrice());
		Customer c2=new VIPCustomer("kim",300,3,5);
		System.out.println(c2);		
		c2.setPoint(p2);
		System.out.println(c2);
		
		ArrayList<Customer> cArrs=new ArrayList<Customer>();
		cArrs.add(new Customer("Park",200,2));
		cArrs.add(new VIPCustomer("kim",300,3,5));
		
		
		ArrayList<Product> pArrs=new ArrayList<Product>();
		pArrs.add(new Product("더조은",316000,5));
		pArrs.add(new TV("LG",100000,10,40,10000));
		pArrs.add(new Computer("삼송",1000000,10,10));
//		for(int i=0;i<pArrs.size();i++) {
//			System.out.println(pArrs.get(i).getProductPrice());
//		}
		System.out.println(cArrs.get(1));
		cArrs.get(1).setPoint(pArrs.get(2));
		System.out.println(cArrs.get(1));
	}

}
