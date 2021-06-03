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
			System.out.println("내 번호 뽑기");
			lotto.randomSixNumber();
			
			System.out.println(lotto.myNumber);
			lotto.myNumber.removeAll(lotto.winningNumber);
			
			if(lotto.myNumber.size() == 0) {
				System.out.println("[1 등 당첨!!]");
				System.out.println("미쳤군요! 당신은 총 "+myCount+"번 시도해 "+myMoney+"원을 썼습니다...");
				System.out.println("로또 번호: "+lotto.winningNumber+" + ["+lotto.bonus+"]");
				break;
			}else if (lotto.myNumber.size() == 1 && lotto.myNumber.remove((Integer)lotto.bonus)) {
				System.out.println("[2 등 당첨!!]");
				System.out.println("미쳤군요! 당신은 총 "+myCount+"번 시도해 "+myMoney+"원을 썼습니다...");
				System.out.println("로또 번호: "+lotto.winningNumber+" + ["+lotto.bonus+"]");
				break;
			}
		}
	}

}
