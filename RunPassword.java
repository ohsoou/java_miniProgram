package miniProgram;

import java.util.Scanner;

import miniProgram.checkPassword.AllNumberException;
import miniProgram.checkPassword.CharConditionException;
import miniProgram.checkPassword.LengthConditionException;
import miniProgram.checkPassword.SpecialCharException;


public class RunPassword {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Password: ");
		try {
			checkCondition(sc.nextLine());
			System.out.println("�н����尡 �ԷµǾ����ϴ�.");
		} catch (AllNumberException e) {
			System.out.println("���ڸ����� �н����带 ���� �� �����ϴ�. \n�빮�ڿ� �ҹ��� ���� Ư�����ڸ� ��� ����� ������ּ���");
			e.printStackTrace();
		} catch (CharConditionException e) {
			System.out.println("�빮�ڿ� �ҹ��� ���� Ư�����ڸ� ��� ����� ������ּ���");
			e.printStackTrace();
		} catch (SpecialCharException e) {
			System.out.println("Ư�� ���ڴ� [ !, @, #, $, %, ^, &, * ]�� ������ּ���.");
			e.printStackTrace();
		} catch (LengthConditionException e) {
			System.out.println("8~24 ���̷� ������ּ���.");
			e.printStackTrace();
		} 
	}
	
	public static void checkCondition(String input) 
			throws AllNumberException, CharConditionException, 
			LengthConditionException, SpecialCharException {
		
		char[] specialChars = {'!','@','#','$','%','^','&','*'};
		int inputLen = input.length();
		boolean allNum = true;
		
		boolean number = false;
		boolean specialChar = false;
		boolean capital = false;
		boolean small = false;
		boolean length = false;
		
		for(int i = 0; i < inputLen; i++) {
			char ch = input.charAt(i);
			if(!(ch >= '0' && ch <= '9')) {
				allNum = false;
			}
			if(ch >= '0' && ch <= '9') {
				number = true;
			} else if(ch >= 'a' && ch <= 'z') {
				small = true;
			} else if(ch >= 'A' && ch <= 'Z') {
				capital = true;
			} else {
				for(int j = 0, len = specialChars.length; j < len; j++) {
					if(ch == specialChars[j]) {
						specialChar = true;
					} else {
						throw new SpecialCharException(ch);
					}
				}
			}
			
		}
		if(allNum) {
			throw new AllNumberException();
		}
		if(!(number && specialChar && capital && small)) {
			throw new CharConditionException();
		}
		if(!(inputLen >= 8 && inputLen <= 24)) {
			throw new LengthConditionException();
		}
	}

}