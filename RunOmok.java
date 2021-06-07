package miniProgram;

import java.util.Random;
import java.util.Scanner;

import miniProgram.omok.Board;
import miniProgram.omok.GraphicOmock;
import miniProgram.omok.Stone;
import miniProgram.omok.Exception.InvalidSpace;
import miniProgram.omok.Exception.SelectedSpace;

public class RunOmok {
	
	public static void main(String[] args) {
		Board board = new Board();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		//흑돌부터
		boolean turn = false;

		while(true) {
			String player = turn? "백돌":"흑돌";
			System.out.println(player+" 차례입니다. 좌표를 입력하세요: ");
			int x = rand.nextInt(board.BOARD_ROW);
			int y = rand.nextInt(board.BOARD_COLUMN);
			
			Stone stone = new Stone(x,y,turn);
			
			try {
				board.putStone(stone);
				GraphicOmock.printOmock(board);
			} catch (InvalidSpace e) {
				System.out.println("좌표 선택이 잘못되었습니다.");
				continue;
			} catch (SelectedSpace e) {
				System.out.println("이미 선택된 좌표입니다.");
				continue;
			}
			if(board.isFiveStone(stone)) {
				break;
			}
			turn = !turn;
		}
		
	}

}
