package miniProgram.schoolGrade;


public class NetworkClass extends SchoolClass {
	public NetworkClass(){
		for(int i = 0; i < MAX_STUDENTS; i++) {
			students[i] = new Student();
			students[i].linux = students[i].insertGrade(); 
			students[i].network = students[i].insertGrade();
			students[i].ccna = students[i].insertGrade();
		}
		this.subjectNum = 5;
	}

	@Override
	public void showGrade() {
		System.out.println("ÀÌ¸§\t|ÃÑÁ¡\t|Æò±ÕÁ¡¼ö");
		for(int i = 0; i<MAX_STUDENTS; i++) {
			int total = students[i].kor + students[i].eng + students[i].linux + students[i].network
					+ students[i].ccna;
			double avg = total / subjectNum;
			System.out.printf("%s\t|%d\t|%.2f|%d\n", students[i].name, total, avg);
		}
		
	}
}
