package miniProgram;

import miniProgram.lotto.Lotto;

public class RunLotto {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.randomSevenNumber();

		long myMoney = 0;
		long myCount = 0;
		
		while(true) {
			myMoney += 1000;
			myCount++;
			System.out.println("�� ��ȣ �̱�");
			lotto.randomSixNumber();
			
			System.out.println(lotto.myNumber);
			lotto.myNumber.removeAll(lotto.winningNumber);
			
			if(lotto.myNumber.size() == 0) {
				System.out.println("[1 �� ��÷!!]");
				System.out.println("���Ʊ���! ����� �� "+myCount+"�� �õ��� "+myMoney+"���� ����ϴ�...");
				System.out.println("�ζ� ��ȣ: "+lotto.winningNumber+" + ["+lotto.bonus+"]");
				break;
			}else if (lotto.myNumber.size() == 1 && lotto.myNumber.remove((Integer)lotto.bonus)) {
				System.out.println("[2 �� ��÷!!]");
				System.out.println("���Ʊ���! ����� �� "+myCount+"�� �õ��� "+myMoney+"���� ����ϴ�...");
				System.out.println("�ζ� ��ȣ: "+lotto.winningNumber+" + ["+lotto.bonus+"]");
				break;
			}
		}
	}

}
