package miniProgram.blackjack;

public class Card {
	boolean open;
	int number;
	char pattern;
	private char[] patterns;
	private int[] numbers;
	
	//��, ī�� ���� ������ ����... �������̷� ���� ��
	
	public Card() {
		open = true;
		patterns = new char[]{'��', '��', '��','��'};
		numbers = new int[]{11,2,3,4,5,6,7,8,9,10,13,14,15};
	}
	
	void draw() {
		int patternLen = patterns.length;
		int numberLen = numbers.length;
		
		pattern = patterns[(int)(Math.random()*patternLen)];
		number = numbers[(int)(Math.random()*numberLen)];

	}
}
