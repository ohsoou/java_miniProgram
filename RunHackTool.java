package miniProgram;

import miniProgram.hackTool.Bruteforce;

public class RunHackTool {
	public static void main(String[] args) {
		
		Bruteforce bf = new Bruteforce(new String("files/frankenstein_encrypted.txt"));
		bf.bruteforce();
	}
}
