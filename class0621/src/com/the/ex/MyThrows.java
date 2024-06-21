package com.the.ex;

public class MyThrows {

	public static void test1() {
		try {
		System.out.println("hello");
		throw new Exception();
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test1();
		System.out.println("정상종료");
		
	}

}
