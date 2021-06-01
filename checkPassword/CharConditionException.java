package miniProgram.checkPassword;

public class CharConditionException extends Exception {
	public CharConditionException() {
		super("잘못된 패스워드: 대문자와 소문자 숫자 특수문자 조합");
	}
}