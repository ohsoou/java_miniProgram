package miniProgram.omok;

public class Stone {
	int x;
	int y;
	boolean color;

	public Stone(int x, int y, boolean color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		Stone stone = (Stone)obj;
		
		if(stone.x == this.x && stone.y == this.y && stone.color == this.color) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}
