package miniProgram;

import java.util.Scanner;

import miniProgram.pirate.Game;
import miniProgram.pirate.Setting;

public class RunPirateGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. ���� ����   2. �ڵ� ����");
		System.out.print("> ");
		int select = sc.nextInt();
		
		Setting mySetting;
		if(select == 1) {
			System.out.println("���� ���� �Է��ϼ���:");
			int numOfHole = sc.nextInt();
			System.out.println("���� �÷��̾� ���� �Է��ϼ���:");
			int numOfPlayer = sc.nextInt();
			while(numOfPlayer < 2 || numOfPlayer > numOfHole) {
				System.out.println("�߸��� �Է��Դϴ�.\n �ٽ� ���� �÷��̾� ���� �Է��ϼ���:");
				numOfPlayer = sc.nextInt();
			}
			System.out.println("�߻� ��ư ���� �Է��ϼ���:");
			int numOfLaunchBtn = sc.nextInt();
			
			mySetting = new Setting(numOfHole, numOfPlayer, numOfLaunchBtn);
		}else {
			mySetting = new Setting();
		}
		Game game = new Game(mySetting);
		game.start();
	}
}
