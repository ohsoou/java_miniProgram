package miniProgram.bookShelf;

public class Book {
	String name;
	int serial;
	
	Book(){
		this.name = "Unknown";
		this.serial = -1;
	}
	Book(String name, int serial) {
		this.name = name;
		this.serial = serial;
	}
}
