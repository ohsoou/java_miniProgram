package miniProgram.checkPassword;

public class LengthConditionException extends Exception {
	public LengthConditionException() {
		super("잘못된 패스워드: 8자리 이상 24자리 이하로 입력");
	}
}