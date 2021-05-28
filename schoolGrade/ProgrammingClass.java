package miniProgram.schoolGrade;


public class ProgrammingClass extends SchoolClass{
	
	public ProgrammingClass(){
		for(int i = 0; i < MAX_STUDENTS; i++) {
			students[i] = new Student();
			students[i].math = students[i].insertGrade(); 
			students[i].program = students[i].insertGrade();
			students[i].algorithm = students[i].insertGrade();
			students[i].dataStructure = students[i].insertGrade();
		}
		this.subjectNum = 6;
	}

	@Override
	public void showGrade() {
		System.out.println("ÀÌ¸§\t|ÃÑÁ¡\t|Æò±ÕÁ¡¼ö");
		for(int i = 0; i<MAX_STUDENTS; i++) {
			int total = students[i].kor + students[i].eng + students[i].math + students[i].program
					+ students[i].algorithm + students[i].dataStructure;
			double avg = total / subjectNum;
			System.out.printf("%s\t|%d\t|%.2f|%d\n", students[i].name, total, avg);
		}
		
	}
	
}
