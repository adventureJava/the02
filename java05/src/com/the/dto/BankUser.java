package com.the.dto;

import java.util.Objects;

//클래스 필드, static 필드, 전역 필드
//static 유무에 따라 클래스 필드와 인스턴스 필드로 구분된다.
//클래스 필드 : 1개만 생성되고 전역변수 클래스이름으로 접근, new와 관련이 없다.
//인스턴스 필드 : new를 이용해서 원하는 만큼 생성, 인스턴스를 통해서 접근가능
public class BankUser {
	//클래스 필드 예: 전체 고객 수, 해당 은행이름
	private String id="";
	private String pw="";
	private double account=0;
	
	//생성자,getter setter, toString,equals
	public BankUser() {	
		this("u1","u1",0); //자기 자신의 다른 생성자 호출
	} //기본 생성자, 개발자가 생성자에 손대면 컴파일러가 자동으로 등록하지 않는다.
	public BankUser(String id, String pw, double account) {
		super(); //부모의 생성자를 호출한다.
		this.id = id;
		this.pw = pw;
		this.account = account;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserBank [id=" + id + ", pw=" + pw + ", account=" + account + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(account, id, pw);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUser other = (BankUser) obj;
		return Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}
	
	
	

}
