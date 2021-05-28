package miniProgram;

import java.util.Scanner;

import miniProgram.blackjack.Game;
import miniProgram.blackjack.Graphic;

public class RunBlackJack {
	public static void main(String[] args) {
		System.out.println("---------BLACK JACK--------");
		Scanner sc = new Scanner(System.in);
		Game game = new Game();
		
		int select;
		
		
		System.out.println("<<<딜러 패>>>");
		Graphic.PrintBlackJack(game.dealerCard[0]);
		Graphic.PrintBlackJack(game.dealerCard[1]);
		System.out.println("<<<플레이어 패>>>");
		Graphic.PrintBlackJack(game.playerCard[0]);
		Graphic.PrintBlackJack(game.playerCard[1]);
		

		while(game.going) {
			game.printScore();
			System.out.println("------------------------------");
			System.out.println("hit?[0] stand?[1]:");
			select = sc.nextInt();
			System.out.println("------------------------------");
			if(select == 0) {
				game.hit();
				Graphic.PrintBlackJack(game.playerCard[game.playerIndex-1]);
			}else {
				game.stand();
			}
		}
		
		if(!game.going) {
			System.out.println("<<<딜러 패>>>");
			for(int i = 0; i < game.dealerIndex; i++) {
				Graphic.PrintBlackJack(game.dealerCard[i]);
			}
			game.printScore();
			System.out.println("=======================");
			game.checkWinner();
			System.out.println("=======================");
		}
	}
}
