package miniProgram;

import miniProgram.bookShelf.Shelf;

public class RunBookShelf {
	public static void main(String[] args) {
		Shelf s1 = new Shelf();
		
		s1.showShelf();
		
		s1.addBook("JAVA", 001);
		s1.showShelf();
		s1.addBook("������ Ű���", 060);
		s1.showShelf();
		s1.delBook(001);
		s1.showShelf();
		s1.addBook("�п� ������", 007);
		s1.showShelf();
	}
}
