package com.the.ex;

import java.util.ArrayList;
import java.util.Scanner;

import com.the.dto.BankUser;
import com.the.en.LoginUserState;

public class ArrayListBank {
	//arrayList를 이용한 은행프로그램
	// 1. 상태값 enum : 프로그램 진행 상태값 저장
	// LoginUserStat	
	public static LoginUserState loginUserState = LoginUserState.LOGOUT;	
	
	//ArrayList에서는 해당 변수 arrayList에 들어있는 size가 전체 개수가 된다.
	//public static int totalUserCount=0
	
	//public static int loginUserIndex=-1;
	//여러 개의 배열의 값을 접근할 때는 index로 접근하는 것이 유리했지만
	//arrayList에서는 찾은 객체를 담아서 처리하는 것이 유리하다. 
	public static BankUser loginUser=null; //BankUser 은행 사용자 계정 정보
	public static BankUser adminUser=new BankUser("admin","1111",0);//admin 사용자 계정 정보
	
	//사용자 입력 처리를 위한 변수들
	public static Scanner sc=new Scanner(System.in);
	public static String inputId=null;
	public static String inputPw=null;
	public static double inputAccount=0;
	
	//은행 사용자 유저 관리 arryList
	public static ArrayList<BankUser> bankUserList=new ArrayList<BankUser>();
	
	public static void main(String[] args) {
		
		bankUserList.add(new BankUser("user1","user1",100));
		bankUserList.add(new BankUser("user2","user2",0));
		bankUserList.add(new BankUser("user3","user3",0)); //3명의 은행사용자 등록
		bankUserList.size(); //전체유저 개수 3
		
		//은행 프로그램 메인 메뉴 구현
		//은행 프로그램은 무한 반복하는데 사용자가 종료를 원하면 종료한다.
		//loginUserState값이 loginUserState.EXIT 로그아웃을 원하는 상태가 아닌동안 반복
		while(!loginUserState.equals(loginUserState.EXIT)) {	
			loginUserState = LoginUserState.LOGOUT;
			System.out.println("id 입력, 종료를 원하면 exit 입력"); //사용자로부터 id입력
			ArrayListBank.inputId=sc.nextLine();
			System.out.println("pw 입력 >>"); //pw 입력
			ArrayListBank.inputPw=sc.nextLine();
			//사용자로부터 정보를 입력한 다음 할 일
			//1.EXIT 종료를 원하는지 확인
			//2.USER_LOGIN 확인
			//3.ADMIN_LOGIN 확인
			//4.사용자가 선택한 하위메뉴 실행
			
			//종료를 원하는지 확인, 종료를 원하면 상태값을 EXIT로 변경
			if(inputId.equals("exit")) {
				loginUserState=loginUserState.EXIT;
				break;
			}
			
			//2.USER_LOGIN 확인
			boolean isFlag=true;
			for(BankUser bankUser:bankUserList) {
				//로그인 성공시 실행되는 if문
				if(bankUser.equals(new BankUser(inputId,inputPw,0))) {
					System.out.println(bankUser+"님 로그인 하셨습니다.");
					loginUserState=LoginUserState.USER_LOGIN;
					ArrayListBank.loginUser=bankUser;
					isFlag=false;
					break;
				}
			}
			if(isFlag) {
				System.out.println("찾을 수 없는 유저입니다. 관리자로 확인해 보겠습니다.");
			}
			
			//3.ADMIN_LOGIN 확인
			//유저 로그인 실패했을 경우에만 실행되는 if문
			if(!loginUserState.equals(loginUserState.USER_LOGIN)) {
				if(ArrayListBank.adminUser.equals(new BankUser(inputId,inputPw,0))) {
					loginUserState=LoginUserState.ADMIN_LOGIN;
					System.out.println("관리자로 로그인 성공");
				}else {
					System.out.println("관리자로 로그인 실패, 아이디와 패스워드를 다시 입력해 주세요.");
				}
			}
			
			//4.사용자가 선택한 현재 프로그램 상태에 따른 하위메뉴 실행
			switch(loginUserState) {	
			case ADMIN_LOGIN:				
				boolean isAdmMenu=true;
				while(isAdmMenu) {
					System.out.println("관리자 메뉴 작업");
					System.out.println("1.계정추가 2.계정삭제 3.id변경"
							+ " 4.모든 사용자 출력 5.종료");
					switch(sc.nextLine()) {
					case "1":
						System.out.println("추가할 id 입력"); 
						ArrayListBank.inputId=sc.nextLine();
						System.out.println("추가할 pw 입력 >>"); 
						ArrayListBank.inputPw=sc.nextLine();
						ArrayListBank.bankUserList.add(new BankUser(inputId,inputPw,0));
						break;
					case "2":
						System.out.println("삭제할 id 입력"); 
						ArrayListBank.inputId=sc.nextLine();
						System.out.println("삭제할 pw 입력 >>"); 
						ArrayListBank.inputPw=sc.nextLine();
						ArrayListBank.bankUserList.remove(new BankUser(inputId,inputPw,0));
						break;
					case "3":
						BankUser preBankUser;//변경전 유저 객체
						BankUser nextBankUser;//변경후 유저 객체
						System.out.println("변경전 id 입력"); 
						ArrayListBank.inputId=sc.nextLine();
						System.out.println("변경전 pw 입력 >>"); 
						ArrayListBank.inputPw=sc.nextLine();
						preBankUser=new BankUser(inputId,inputPw,0);
						
						System.out.println("변경할 id 입력"); 
						ArrayListBank.inputId=sc.nextLine();
						System.out.println("변경할 pw 입력 >>"); 
						ArrayListBank.inputPw=sc.nextLine();						
						//set(변경할 인덱스, 변경할 내용)					
						if(ArrayListBank.bankUserList.contains(preBankUser)) {
							//변경전 index
							int preUserIndex=ArrayListBank.bankUserList.indexOf(preBankUser);
							nextBankUser=new BankUser(inputId,inputPw,bankUserList.get(preUserIndex).getAccount());
							ArrayListBank.bankUserList.set(preUserIndex,nextBankUser);
							System.out.println("사용자 정보가 변경되었습니다.");
						}else {
							System.out.println("변경전 사용자 정보를 잘못 입력했습니다."); 
						}						
						break;
					case "4":
						System.out.println("모든 사용자 출력");
						for(BankUser item:ArrayListBank.bankUserList) {
							System.out.println(item);
						}
						break;
					case "5":
						isAdmMenu=false;
						System.out.println("관리자 메뉴를 종료합니다.");
						break;
					default:
						isAdmMenu=false;
						System.out.println("알 수 없는 선택으로 관리자 메뉴를 종료합니다.");
						break;
					}
				}
				break;
			case USER_LOGIN:
				boolean isUseMenu=true;
				while(isUseMenu) {
					System.out.println("사용자 메뉴 작업");
					System.out.println("1.입금 2.출금 3.잔액조회 4.종료 >>");
					switch(sc.nextLine()) {
					case "1":
						System.out.println("입금액 입력>>");
						ArrayListBank.inputAccount=Double.parseDouble(sc.nextLine());
						//입력받은 금액을 로그인한 계정에 추가한다.
						ArrayListBank.loginUser.setAccount(ArrayListBank.loginUser.getAccount()+ArrayListBank.inputAccount);
						System.out.println(ArrayListBank.loginUser.getAccount());
						break;
					case "2":
						System.out.println("출금액 입력>>");
						ArrayListBank.inputAccount=Double.parseDouble(sc.nextLine());
						//입력받은 금액을 로그인한 계정에 추가한다.
						ArrayListBank.loginUser.setAccount(ArrayListBank.loginUser.getAccount()-ArrayListBank.inputAccount);
						System.out.println(ArrayListBank.loginUser.getAccount());
						//ArrayListBank.loginUser.getId()
						//ArrayListBank.loginUser.getPw()
						//ArrayListBank.loginUser.getAccount()
						break;
					case "3":
						System.out.println("사용자 잔액 정보>>");
						System.out.println(ArrayListBank.loginUser.getAccount());
						break;
					case "4":
						System.out.println("사용자 메뉴 종료>>");
						isUseMenu=false;
						break;
					default:
					}
				}								
				break;			
			case LOGOUT:
				System.out.println("로그인 작업 실패 다시 시도해 주세요");
				break;
			case EXIT:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("알 수 없는 프로그램 상태");
				loginUserState=loginUserState.EXIT;
				break;
			}
			
			
		}//while 종료
		System.out.println("프로그램 종료");
		
		
		
		

	}

	private static double inputAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
