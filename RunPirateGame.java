package miniProgram;

import java.util.Scanner;

import miniProgram.pirate.Game;
import miniProgram.pirate.Setting;

public class RunPirateGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 수동 세팅   2. 자동 세팅");
		System.out.print("> ");
		int select = sc.nextInt();
		
		Setting mySetting;
		if(select == 1) {
			System.out.println("구멍 수를 입력하세요:");
			int numOfHole = sc.nextInt();
			System.out.println("참가 플레이어 수를 입력하세요:");
			int numOfPlayer = sc.nextInt();
			while(numOfPlayer < 2 || numOfPlayer > numOfHole) {
				System.out.println("잘못된 입력입니다.\n 다시 참가 플레이어 수를 입력하세요:");
				numOfPlayer = sc.nextInt();
			}
			System.out.println("발사 버튼 수를 입력하세요:");
			int numOfLaunchBtn = sc.nextInt();
			
			mySetting = new Setting(numOfHole, numOfPlayer, numOfLaunchBtn);
		}else {
			mySetting = new Setting();
		}
		Game game = new Game(mySetting);
		game.start();
	}
}
