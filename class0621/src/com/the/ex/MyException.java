package com.the.ex;
public class MyException {
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5};
		int index=-1;
		java.util.Scanner sc=new java.util.Scanner(System.in);
		
		try {
			System.out.println("출력하고싶은 배열 인덱스 입력");
			index=Integer.parseInt(sc.nextLine());
			System.out.println("사용자 배열내용은 : "+arr[index]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열에서 벗어난 인덱스 사용");
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("배열 인덱스형에 맞지 않는 자료형 사용");
			e.printStackTrace();
		}finally {
			System.out.println("예외 발생 유무와 관련없이 항상 실행되는 코드");
		}
		System.out.println("정상 종료");
	}

}
