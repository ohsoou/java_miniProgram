package miniProgram.omok;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GraphicOmock {
	public static void printOmock(Board board) {
		List<Stone> stones = board.board;
		for(int i = 0 ; i < board.BOARD_ROW; i++) {
			for(int j = 0; j < board.BOARD_COLUMN; j++) {
				if(stones.contains(new Stone(i, j,true))) {
					System.out.print("¡Û ");
				} else if (stones.contains(new Stone(i, j,false))) {
					System.out.print("¡Ü ");
				} else {
					System.out.print("¦« ");
				}
			}
			System.out.println();
		}
	}

}

//class ArrangeLocationX implements Comparator<Stone> {
//	ArrangeLocationY locationY;
//	public ArrangeLocationX() {
//		locationY = new ArrangeLocationY();
//	}
//	@Override
//	public int compare(Stone o1, Stone o2) {
//		if(o1.x > o2.x) {
//			return 1;
//		} else if (o1.x < o2.x) {
//			return -1;
//		} else {
//			return locationY.compare(o1, o2);
//		}
//	}
//}
//
//class ArrangeLocationY implements Comparator<Stone> {
//	@Override
//	public int compare(Stone o1, Stone o2) {
//		if(o1.y > o2.y) {
//			return 1;
//		} else if (o1.y < o2.y) {
//			return -1;
//		} else {
//			return 0;
//		}
//	}
//}