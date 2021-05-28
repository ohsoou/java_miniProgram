package miniProgram.pirate;

public class Setting {
	int numOfHole;
	int numOfPlayer;
	int numOfLaunchBtn;
	
	public Setting() {
		numOfHole = 10;
		numOfPlayer = 3;
		numOfLaunchBtn = 2;
	}
	
	public Setting(int numOfHole) {
		this.numOfHole = numOfHole;
		numOfPlayer = 3;
		numOfLaunchBtn = 2;
	}
	
	public Setting(int numOfHole, int numOfPlayer, int numOfLaunchBtn) {
		this.numOfHole = numOfHole;
		this.numOfPlayer = numOfPlayer;
		this.numOfLaunchBtn = numOfLaunchBtn;
	}

}
