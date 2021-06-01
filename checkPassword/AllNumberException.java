package miniProgram.checkPassword;

public class AllNumberException extends Exception {
	public AllNumberException() {
		super("잘못된 패스워드: 모두 숫자");
	}
}
