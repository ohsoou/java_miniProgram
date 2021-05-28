package miniProgram.schoolGrade;


public class MachinLearningClass extends SchoolClass {
	public MachinLearningClass(){
		for(int i = 0; i < MAX_STUDENTS; i++) {
			students[i] = new Student();
			students[i].math = students[i].insertGrade(); 
			students[i].program = students[i].insertGrade();
			students[i].statistics = students[i].insertGrade();
		}
		this.subjectNum = 5;
	}

	@Override
	public void showGrade() {
		System.out.println("�̸�\t|����\t|�������");
		for(int i = 0; i<MAX_STUDENTS; i++) {
			int total = students[i].kor + students[i].eng + students[i].math + students[i].program
					+ students[i].statistics;
			double avg = total / subjectNum;
			System.out.printf("%s\t|%d\t|%.2f|%d\n", students[i].name, total, avg);
		}
		
	}
}
