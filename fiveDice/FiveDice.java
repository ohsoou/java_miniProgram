package miniProgram.fiveDice;

public class FiveDice {
	final static int NUM_OF_DICE = 5;
	final static int SIDE_OF_DICE = 6;
	
	private String result;
	private int[] sortedDices;
	int[] dices;
	
	public FiveDice(){
		dices = new int[NUM_OF_DICE];
	}
	
	private int throwDice() {
		return (int)(Math.random()*(SIDE_OF_DICE+1)+1);
	}
	
	public void throwAllDice() {
		for(int i = 0; i < NUM_OF_DICE; i++) {
			dices[i] = throwDice();
		}
	}
	
	public void throwSelectDice(int index) {
		dices[index] = throwDice();
	}
	
	public void printResult() {
		result = "�ƹ� ����� �ƴմϴ�.";
		for(int i = 0; i < NUM_OF_DICE; i++) {
			System.out.printf("  %dst dice   ��", i+1); 
		}
		System.out.println();
		for(int i = 0; i < NUM_OF_DICE; i++) {
			System.out.printf("      %d      ��", dices[i]); 
		}
		System.out.println("\n===== ��� ======");
		sortValues();
		isFullHouse();
		isStraight();

		System.out.println(result);
		System.out.println("===============");
		
	}
	private void isFullHouse() {
		int same = 0;
		boolean fullHouse = false;
		
		for(int i = 1; i < NUM_OF_DICE; i++) {
			if(sortedDices[i-1] == sortedDices[i]) {
				same++;
				if(same == 2) {
					fullHouse = true;
				}
			}else {
				same = 0;
			}
		}
		
		if(same == 4) {
			result = "5 ���̽�";
		}else if (same == 3) {
			result = "4 ���̽�";
		}else if (fullHouse && same == 1) {
			result = "Ǯ �Ͽ콺";
		}
	}
	private void isStraight() {
		int straight = 0;

		for(int i = 1; i < NUM_OF_DICE; i++) {
			if(sortedDices[i-1]+1 == sortedDices[i]) {
				straight++;
			}else {
				straight = 0;
			}
		}
		if(straight == 4) {
			result = "���� ��Ʈ����Ʈ";
		}else if (straight == 3) {
			result = "���� ��Ʈ����Ʈ";
		}
	}
	private int[] sortValues() {
		sortedDices = dices.clone();
		int temp;
		for(int i = 0; i < NUM_OF_DICE; i++) {
			for(int j = i; j < NUM_OF_DICE; j++) {
				if(sortedDices[i] >= sortedDices[j]) {
					temp = sortedDices[i];
					sortedDices[i] = sortedDices[j];
					sortedDices[j] = temp;
				}
			}
		}
		return sortedDices;
	}
}
