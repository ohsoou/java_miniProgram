package miniProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AllAvailablePassword {
	private static ArrayList<Character> availableList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 길이를 입력하세요.>");
		int input = sc.nextInt();
		
		addAvailableCharacter();
		
		char[] prevChars = new char[input-1];
		printAllAvailablePassword(prevChars, input);
	}
	
	private static void addAvailableCharacter() {
		for(int i = '0'; i <= '9'; i++) {
			availableList.add((char)i);
		}
		for(int i = 'a'; i <= 'z'; i++) {
			availableList.add((char)i);
		}
		for(int i = 'A'; i <= 'Z'; i++) {
			availableList.add((char)i);
		}
		Collections.addAll(availableList, '!','@','#','$','%','^','&','*','(',')');
	}

	private static void printAllAvailablePassword(char[] prevChars, int len) {
		for(int i =0, size = availableList.size(); i < size; i++) {
			if(len == 1) {
				for(int j = prevChars.length-1; j > -1; j--) {
					System.out.print(prevChars[j]);
				}
				System.out.println(availableList.get(i));
			} else {
				prevChars[len-2] = availableList.get(i);
				printAllAvailablePassword(prevChars, len-1);
			}
		}
	}
}
