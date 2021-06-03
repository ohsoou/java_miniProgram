package miniProgram.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	public ArrayList<Integer> myNumber;
	public ArrayList<Integer> winningNumber;
	private Random rand;
	public int bonus;
	
	public Lotto() {
		myNumber = new ArrayList<Integer>();
		winningNumber = new ArrayList<Integer>();
		rand = new Random();
	}
	
	public void randomSixNumber() {
		HashSet<Integer> temp = new HashSet<>();
		while(temp.size() < 6) {
			temp.add(rand.nextInt(45)+1);
		}
		myNumber.clear();
		myNumber.addAll(temp);
		Collections.sort(myNumber);
	}
	public ArrayList<Integer> randomSevenNumber() {
		HashSet<Integer> temp = new HashSet<>();
		Random rand = new Random();
		winningNumber.clear();
		
		while(winningNumber.size() < 7) {
			temp.addAll(winningNumber);
			int thisNum = rand.nextInt(45)+1;
			if(!temp.remove(thisNum)) {
				winningNumber.add(thisNum);
			}
		}
		bonus = winningNumber.remove(6);
		return winningNumber;
	}
}
