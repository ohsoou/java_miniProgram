package miniProgram.schoolGrade;

abstract public class SchoolClass {
	final int MAX_STUDENTS = 30;
	int subjectNum;
	Student[] students;
	
	public SchoolClass() {
		students = new Student[MAX_STUDENTS];
	}
	abstract public void showGrade();

}
