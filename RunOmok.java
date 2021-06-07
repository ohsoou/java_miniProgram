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
		//�浹����
		boolean turn = false;

		while(true) {
			String player = turn? "�鵹":"�浹";
			System.out.println(player+" �����Դϴ�. ��ǥ�� �Է��ϼ���: ");
			int x = rand.nextInt(board.BOARD_ROW);
			int y = rand.nextInt(board.BOARD_COLUMN);
			
			Stone stone = new Stone(x,y,turn);
			
			try {
				board.putStone(stone);
				GraphicOmock.printOmock(board);
			} catch (InvalidSpace e) {
				System.out.println("��ǥ ������ �߸��Ǿ����ϴ�.");
				continue;
			} catch (SelectedSpace e) {
				System.out.println("�̹� ���õ� ��ǥ�Դϴ�.");
				continue;
			}
			if(board.isFiveStone(stone)) {
				break;
			}
			turn = !turn;
		}
		
	}

}
