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
			System.out.println("플레이어 패가 21을 넘었습니다.");
			System.out.println("**딜러 승리!!");
		}else if(playerScore == 21) {
			System.out.println("플레이어 패가 정확히 21 입니다.");
			System.out.println("**플레이어 승리!!");
		}else if(playerScore > dealerScore) {
			System.out.println("플레이어 패가 딜러 패를 넘었습니다.");
			System.out.println("**플레이어 승리!!");
		}else if (playerScore == dealerScore){
			System.out.println("**무승부!!");
		}else {
			System.out.println("딜러 패가 플레이어 패를 넘었습니다.");
			System.out.println("**딜러 승리!!");
		}
	}
	
	public void printScore() {
		System.out.printf("==현재 플레이어의 점수: %d\n", calcCard(playerCard, playerIndex));
		System.out.printf("==현재 딜러의 점수: %d\n", calcCard(dealerCard, dealerIndex));
		System.out.println();
	}
}
