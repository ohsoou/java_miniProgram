package miniProgram.blackjack;

public class Graphic {
	public static void PrintBlackJack(Card card) {
		

		char pattern = card.pattern;
		int number = card.number;
		if(card.open) {
				System.out.println("��������������������");
				System.out.println("��        ��");
				if(number == 13) {
					System.out.printf("��   %c%c\n", pattern, 'J');
				}else if (number == 14) {
					System.out.printf("��   %c%c\n", pattern, 'Q');
				}else if (number == 15) {
					System.out.printf("��   %c%c\n", pattern, 'K');
				}else if (number == 1 || number == 11) {
					System.out.printf("��   %c%c\n", pattern, 'A');
				}else {
					System.out.printf("��   %c%d\n", pattern, number);
				}
				System.out.println("��        ��");
				System.out.println("��        ��");
				System.out.println("��������������������");
				System.out.println();
		}else {
				System.out.println("��������������������");
				System.out.println("��////////��");
				System.out.println("��////////��");
				System.out.println("��////////��");
				System.out.println("��////////��");
				System.out.println("��������������������");
				System.out.println();
			}
	}


}
