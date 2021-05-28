package miniProgram.blackjack;


public class Game {
	final static private int MAX_TURN_NUMBER = 52;
	
	public Card[] playerCard;
	public Card[] dealerCard;
	
	public int playerIndex;
	public int dealerIndex;
	public boolean going;
	
	public Game(){
		playerCard = new Card[MAX_TURN_NUMBER];
		dealerCard = new Card[MAX_TURN_NUMBER];
		going = true;
		
		for(int i = 0; i < 2; i++) {
			playerCard[i] = new Card();
			dealerCard[i] = new Card();
			
			playerCard[i].draw();
			dealerCard[i].draw();
			playerIndex++;
			dealerIndex++;
		}
		dealerCard[0].open = false;
		
	}
	
	private int calcCard(Card[] cards, int len) {
		int result = 0;
		for(int i = 0; i < len; i++) {
			if(cards[i].open) {
				if(cards[i].number == 13 | cards[i].number == 14 |
						cards[i].number == 15) {
					cards[i].number = 10;
				}
				if(cards[i].number == 11 && result > 21) {
					cards[i].number = 1;
				}
				result += cards[i].number;
			}
		}
		
		return result;
	}
	
	public void hit() {
		playerCard[playerIndex] = new Card();
		playerCard[playerIndex++].draw();
		
		if(calcCard(playerCard, playerIndex) > 21) {
			dealerCard[0].open = true;
			going = false;
		}
	}

	public void stand() {
		dealerCard[0].open = true;
		
		
		while(calcCard(dealerCard, dealerIndex) <= 16) {
			dealerCard[dealerIndex] = new Card();
			dealerCard[dealerIndex++].draw();
		}
		
		going = false;
	}
	
	
	public void checkWinner() {
		int playerScore = calcCard(playerCard, playerIndex);
		int dealerScore = calcCard(dealerCard, dealerIndex);
		if(playerScore > 21) {
			System.out.println("�÷��̾� �а� 21�� �Ѿ����ϴ�.");
			System.out.println("**���� �¸�!!");
		}else if(playerScore == 21) {
			System.out.println("�÷��̾� �а� ��Ȯ�� 21 �Դϴ�.");
			System.out.println("**�÷��̾� �¸�!!");
		}else if(playerScore > dealerScore) {
			System.out.println("�÷��̾� �а� ���� �и� �Ѿ����ϴ�.");
			System.out.println("**�÷��̾� �¸�!!");
		}else if (playerScore == dealerScore){
			System.out.println("**���º�!!");
		}else {
			System.out.println("���� �а� �÷��̾� �и� �Ѿ����ϴ�.");
			System.out.println("**���� �¸�!!");
		}
	}
	
	public void printScore() {
		System.out.printf("==���� �÷��̾��� ����: %d\n", calcCard(playerCard, playerIndex));
		System.out.printf("==���� ������ ����: %d\n", calcCard(dealerCard, dealerIndex));
		System.out.println();
	}
}
