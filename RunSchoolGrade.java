package miniProgram;

import miniProgram.schoolGrade.MachinLearningClass;
import miniProgram.schoolGrade.NetworkClass;
import miniProgram.schoolGrade.ProgrammingClass;
import miniProgram.schoolGrade.SchoolClass;

public class RunSchoolGrade {
	public static void main(String[] args) {
		test(new ProgrammingClass());
		test(new NetworkClass());
		test(new MachinLearningClass());
	
	}
	public static void test(SchoolClass s) {
		System.out.println("---------------------------------------");
		s.showGrade();
	}
}

