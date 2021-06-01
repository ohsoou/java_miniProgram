package miniProgram.checkPassword;

public class SpecialCharException extends Exception {
	public SpecialCharException(char c) {
		super("잘못된 패스워드: '"+c+"'는 사용 불가");
	}
}
