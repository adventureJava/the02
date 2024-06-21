package com.the.ex;

public class MyThrowThrows {

	public static void main(String[] args) {
		//throw 강제로 예외를 발생시킬 수 있다.
		int a=11;
		try {
			if(a>10) {
				throw new Exception();
			}else {
				
			}
		}catch(Exception e) {
			System.out.println("a가 10보다 커서 예외 발생");
		}

	}

}
