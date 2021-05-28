package miniProgram.schoolGrade;

public class Student {
	final static int MAX_SCORE = 100;
	final static String[] LAST_NAME = {"��","��","��","��","��","��"};
	final static String[] FIRST_NAME = {"����","����","�ٿ�","����","����","����","����","����","����","����","����","����"};
	
	static String generateRandomName() {
		return LAST_NAME[(int)(Math.random()*LAST_NAME.length)] 
				+ FIRST_NAME[(int)(Math.random()*FIRST_NAME.length)];
	}
	
	static int studentNum;
	int myStudentNum;
	String name;
	int subjectNum;
	
	int kor;
	int eng;
	
	int math;
	int program;
	int algorithm;
	int dataStructure;
	
	int linux;
	int network;
	int ccna;
	
	int statistics;
	
	
	
	Student(){
		this.myStudentNum = studentNum++;
		this.name = generateRandomName();
		this.kor = insertGrade();
		this.eng = insertGrade();
	}
	
	int insertGrade() {
		return (int)(Math.random()*(MAX_SCORE + 1));
	}

}
