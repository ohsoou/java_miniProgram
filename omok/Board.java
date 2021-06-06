package miniProgram.omok;

import java.util.ArrayList;
import java.util.List;

import miniProgram.omok.Exception.InvalidSpace;
import miniProgram.omok.Exception.SelectedSpace;


public class Board {
	final public static int BOARD_COLUMN = 10;
	final public static int BOARD_ROW = 10;
	static List<Stone> board;
	private Stone myStone;
	private List<Stone> myStoneList;

	public Board() {
		board = new ArrayList<Stone>(BOARD_COLUMN * BOARD_ROW);
		myStoneList = new ArrayList<Stone>();
	}
	
	public void putStone(Stone stone) throws InvalidSpace, SelectedSpace{
		if(stone.x < 0 || stone.y < 0 || stone.x > BOARD_ROW || stone.y > BOARD_ROW) {
			throw new InvalidSpace();
		}
		if(!existStone(stone)) {
			myStone = stone;
			board.add(stone);
		} else {
			throw new SelectedSpace();
		}
	}
	
	public boolean isFiveStone() {
		makeSameColorStoneList();
		
		if(checkHorizontal() || checkVertical() || checkDiagonal() || checkDiagonal_desc()) {
			String winner = myStone.color? "백돌":"흑돌";
			System.out.println("[["+winner+ " 승리!!!]]");
			return true;
		}
		return false;
	}
	
	
	private boolean existStone(Stone stone) {
		for(Stone stoneOnBoard : board) {
			if(stone.y == stoneOnBoard.y && stone.x == stoneOnBoard.x) {
				return true;
			}
		}
		return false;
	}
	
	private void makeSameColorStoneList(){
		myStoneList.clear();

		for(Stone stoneOnBoard : board) {
			if(myStone.color == stoneOnBoard.color) {
				myStoneList.add(stoneOnBoard);
			}
		}
	}

	//가로
	private boolean checkHorizontal() {
		int count = 1;
		int diff = 1;
		boolean checking = true;
		boolean reverseChecking = true;
		
		while(checking || reverseChecking) {
			Stone checkingStone = new Stone(myStone.x, myStone.y+diff, myStone.color);
			Stone reverseCheckingStone = new Stone(myStone.x, myStone.y-diff, myStone.color);
			if(myStoneList.contains(checkingStone) && checking) {
				count++;
			} else {
				checking = false;
			}
			
			if(myStoneList.contains(reverseCheckingStone) && reverseChecking) {
				count++;
			} else {
				reverseChecking = false;
			}
			diff++;
		}
		return count >= 5? true:false;
		
	}
	//세로
	private boolean checkVertical() {
		int count = 1;
		int diff = 1;
		boolean checking = true;
		boolean reverseChecking = true;
		
		while(checking || reverseChecking) {
			Stone checkingStone = new Stone(myStone.x+diff, myStone.y, myStone.color);
			Stone reverseCheckingStone = new Stone(myStone.x-diff, myStone.y, myStone.color);
			
			if(myStoneList.contains(checkingStone) && checking) {
				count++;
			} else {
				checking = false;
			}
			
			if(myStoneList.contains(reverseCheckingStone) && reverseChecking) {
				count++;
			} else {
				reverseChecking = false;
			}
			diff++;
		}
		return count >= 5? true:false;
		
	}

	//대각선 /
	private boolean checkDiagonal() {
		int count = 1;
		int diff = 1;
		boolean checking = true;
		boolean reverseChecking = true;
		
		while(checking || reverseChecking) {
			Stone checkingStone = new Stone(myStone.x-diff, myStone.y+diff, myStone.color);
			Stone reverseCheckingStone = new Stone(myStone.x+diff, myStone.y-diff, myStone.color);
			
			if(myStoneList.contains(checkingStone) && checking) {
				count++;
			} else {
				checking = false;
			}
			
			if(myStoneList.contains(reverseCheckingStone) && reverseChecking) {
				count++;
			} else {
				reverseChecking = false;
			}
			diff++;
		}
		return count >= 5? true:false;
	}

	//대각선 \
	private boolean checkDiagonal_desc() {
		int count = 1;
		int diff = 1;
		boolean checking = true;
		boolean reverseChecking = true;
			
		while(checking || reverseChecking) {
			Stone checkingStone = new Stone(myStone.x-diff, myStone.y-diff, myStone.color);
			Stone reverseCheckingStone = new Stone(myStone.x+diff, myStone.y+diff, myStone.color);
				
			if(myStoneList.contains(checkingStone) && checking) {
				count++;
			} else {
				checking = false;
			}
				
			if(myStoneList.contains(reverseCheckingStone) && reverseChecking) {
				count++;
			} else {
				reverseChecking = false;
			}
			diff++;
		}
		return count >= 5? true:false;
	}
	@Override
	public String toString() {
		return board.toString();
	}


}
