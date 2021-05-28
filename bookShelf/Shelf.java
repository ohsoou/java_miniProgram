package miniProgram.bookShelf;



public class Shelf {
	Book[][] shelf;
	final static int MAX_ROW = 5;
	final static int MAX_COL = 5;
	
	int row = 0;
	int col = 0;
	
	public Shelf(){
		shelf = new Book[MAX_ROW][MAX_COL];
	}
	private boolean checkSpace() {
		boolean check = false;
		for(int i = 0; i < MAX_ROW; i++) {
			for(int j = 0; j < MAX_COL; j++) {
				if(shelf[i][j] == null) {
					check = true;
					row = i;
					col = j;
					return check;
				}
			}
		}
		return check;
	}
	public void addBook(String name, int serial) {
		if(checkSpace()) {
			shelf[row][col] = new Book(name, serial);
			System.out.printf("'%s'가 책장에 들어갔습니다.\n", name);
		}else {
			System.out.println("책장에 비어있는 자리가 없습니다.");
		}
	}
	public void delBook(String name) {
		for(int i = 0; i < MAX_ROW; i++) {
			for(int j = 0; j < MAX_COL; j++) {
				if(shelf[i][j] == null) {
					continue;
				}
				if(shelf[i][j].name.equals(name)) {
					System.out.printf("'%s'가 책장에서 빠졌습니다.\n", shelf[i][j].name);
					shelf[i][j] = null;
					break;
				}
			}
		}
	}
	public void delBook(int serial) {
		for(int i = 0; i < MAX_ROW; i++) {
			for(int j = 0; j < MAX_COL; j++) {
				if(shelf[i][j] == null) {
					continue;
				}
				if(shelf[i][j].serial == serial) {
					System.out.printf("'%s'가 책장에서 빠졌습니다.\n", shelf[i][j].name);
					shelf[i][j] = null;
					break;
				}
			}
		}
	}
	
	public void showShelf() {
		for(int i = 0; i < MAX_ROW; i++) {
			for(int j = 0; j < MAX_COL; j++) {
				if(shelf[i][j] == null) {
					System.out.print("□ ");
				}else {
					System.out.print("■ ");
				}
			}
			System.out.println();
		}
	}
	
	
	
}
