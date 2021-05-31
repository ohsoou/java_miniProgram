package miniProgram;

import java.util.Scanner;

import miniProgram.fiveDice.FiveDice;

public class RunFiveDice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		FiveDice fiveDice = new FiveDice();
		
		boolean going = true;

		fiveDice.throwAllDice();
		fiveDice.printResult();
		
		while(going) {
			System.out.println("�ٽ� �����ðڽ��ϱ�? 1.Yes 2. No: ");
			going = sc.nextInt() == 1? true:false;
			if(going) {
			System.out.println("�� ���� �ֻ����� �ٽ� �����ðڽ��ϱ�? ");
			int numReDice = sc.nextInt();
					
			int reDice;
			System.out.println("�� ��° �ֻ����� �ٽ� �����ðڽ��ϱ�? (1~5)");
			for(int i = 0; i <numReDice; i++) {
				System.out.printf("%d> ", i+1);
				reDice = sc.nextInt();
				fiveDice.throwSelectDice(reDice-1);
				
			}
			fiveDice.printResult();
			}
		}

		System.out.println("���� ��!");

	}
}
