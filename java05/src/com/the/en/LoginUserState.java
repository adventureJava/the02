package com.the.en;
//프로그램 진행 상태 enum
public enum LoginUserState {
	LOGOUT, //로그아웃 상태
	USER_LOGIN, //유저로그인
	ADMIN_LOGIN, //관리자로그인
	EXIT //프로그램 종료
}
//해당 프로그램은 4개중 반드시 하나의 상태를 가진다.
