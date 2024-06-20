package com.human.character;

public class Cat implements Pet {
	private int experience=50;
	private int energy=60;
	private int level=1;
	@Override
	public void eat() {
		energy+=25;		
	}
	@Override
	public void sleep() {
		energy+=10;		
	}
	@Override
	public void play() {
		energy-=30;	
		experience+=30;	
	}
	@Override
	public void train() {
		energy-=20;	
		experience+=20;	
	}
	@Override
	public void levelUp() {
		if(experience>60) {
			experience-=40;
			level++;
			System.out.println("렙업!!!");
		}
	}
	@Override
	public boolean endGame() {
		boolean returnValue = true;
		if(level >=4) {
			System.out.println("고양이가 호랭이됨");
			returnValue=false;			
		}else if(energy<=0){
			System.out.println("고양이가 굶어 죽음...");
			returnValue=false;
		}
		return returnValue;
	}
	@Override
	public void printInfo() {
		System.out.println("===========================");
		System.out.println("고양이 정보입니다.");
		System.out.println("경험치 : "+experience);
		System.out.println("에너지 : "+energy);
		System.out.println("레벨 : "+level);
		System.out.println("===========================");		
	}

}
