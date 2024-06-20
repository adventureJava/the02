package com.human.play;

import java.util.Scanner;
import com.human.character.*;

public class PlayGame {
	private Pet character=null;
	private boolean flag=true;
	private Scanner sc=new Scanner(System.in);
	public void gameStart() {
		selectCharacter();
		play();
	}
	public void selectCharacter() {
		System.out.println("캐릭터를 입력하세요.");
		System.out.println("1.피카츄 2.고양이");
		String ch=sc.nextLine();
		if(ch.equals("1")) {
			character=new Pikachu();
		}else if(ch.equals("2")) {
			character=new Cat();
		}
	}
	public void play() {
		while(flag) {
			character.levelUp();			
			character.printInfo();
			flag=character.endGame();			
			if(flag==false) {break;}
			System.out.println("1.밥먹이기 2.잠재우기 3.놀아주기 4.운동 5.종료");
			System.out.print("입력>>");
			String select = sc.nextLine();
			switch(select) {
			case "1":
				character.eat();
				break;
			case "2":
				character.sleep();
				break;
			case "3":
				character.play();
				break;
			case "4":
				character.train();
				break;
			case "5":
				flag=false;
				break;
			default:
				break;
			}
		}
	}

}
