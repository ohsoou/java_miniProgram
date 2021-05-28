package miniProgram.pirate;

import java.util.Scanner;


public class Game {
	Scanner sc;
	private Setting env;
	private static int[] choice;
	private static int index;
	int[] targetHoles;
	
	public Game(Setting setting) {
		env = setting;
		sc = new Scanner(System.in);
		choice = new int[env.numOfHole];
		targetHoles = randomeTargetHole();
	}
	
	public void start() {
		int turn = 0;
		int select = -1;
		while(!checkTarget(select)) {
			turn = turn % env.numOfPlayer;
			System.out.printf("%d��° �÷��̾� �����Դϴ�.\n", turn);
			select = sc.nextInt();
			
			for(int i = 0; i <= index; i++) {
				if(choice[i] == select) {
					System.out.println("�̹� ���õ� �ڸ� �Դϴ�.");
					System.out.printf("�ٽ� %d��° �÷��̾� �����Դϴ�.\n", turn);
					select = sc.nextInt();
				}
			}
			choice[index++] = select;
			turn++;
		}
		System.out.printf("***%d�� �����ؼ� %d �÷��̾ �й��߽��ϴ�.",select, turn-1);
	
	}
	
	int[] randomeTargetHole() {
		int targetNum = (int)(Math.random()*(env.numOfLaunchBtn+1)+1);
		int[] randomHole = new int[targetNum];
		
		boolean duplicate = false;
		for(int i = 0; i < targetNum; ) {
			int randomNum = (int)(Math.random()*(env.numOfHole+1)+1);
			for(int j = 0; j < targetNum; j++) {
				if(randomHole[j] == randomNum) {
					duplicate = true;
					break;
				}
			}
			if(!duplicate) {
				randomHole[i] = randomNum;
				i++;
			}
			
		}
		return randomHole;
	}
	
	public boolean checkTarget(int select) {
		for(int i = 0; i < targetHoles.length; i++) {
			if(select == targetHoles[i]) {
				return true;
			}
		}
		return false;
	}
}
