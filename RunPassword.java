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
			System.out.println("패스워드가 입력되었습니다.");
		} catch (AllNumberException e) {
			System.out.println("숫자만으로 패스워드를 만들 수 없습니다. \n대문자와 소문자 숫자 특수문자를 모두 사용해 만들어주세요");
			e.printStackTrace();
		} catch (CharConditionException e) {
			System.out.println("대문자와 소문자 숫자 특수문자를 모두 사용해 만들어주세요");
			e.printStackTrace();
		} catch (SpecialCharException e) {
			System.out.println("특수 문자는 [ !, @, #, $, %, ^, &, * ]만 사용해주세요.");
			e.printStackTrace();
		} catch (LengthConditionException e) {
			System.out.println("8~24 길이로 만들어주세요.");
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