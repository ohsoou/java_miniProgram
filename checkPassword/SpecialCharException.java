package miniProgram.checkPassword;

public class SpecialCharException extends Exception {
	public SpecialCharException(char c) {
		super("�߸��� �н�����: '"+c+"'�� ��� �Ұ�");
	}
}
