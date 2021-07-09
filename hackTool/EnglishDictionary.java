package miniProgram.hackTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class EnglishDictionary {
	final static File file = new File("files/engDict.txt");

	public static List<String> getWordListInDictionary() {
		try (
				FileReader fin = new FileReader(file, Charset.forName("UTF-8"));
				BufferedReader in = new BufferedReader(fin); 
		){
			String line;
			List<String> wordList = new ArrayList<>();
			
			while((line = in.readLine()) != null) {
				wordList.add(line);
			}
			return wordList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
