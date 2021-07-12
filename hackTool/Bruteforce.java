package miniProgram.hackTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bruteforce {
	private File file;
	private List<String> wordListInFile;
	private int key;
	
	public Bruteforce(String path) {
		this.file = new File(path); 
		wordListInFile = new ArrayList<String>();
	}
	
	public void bruteforce() {
		Scanner sc = new Scanner(System.in);
		int[] countMatchWord = new int[26];
		
		for (int k = 1; k < 26; k++) {
			this.key = k;
			countMatchWord[k] = countMatchingWordWithDict();
		}
		
		this.key = getkeyOfMaxValue(countMatchWord);
		
		System.out.println("---------복호화 키: "+ key + "------------------------------");
		System.out.println("영어사전과 일치 데이터 개수" + countMatchWord[key]);
		System.out.println();
		printLines();

	}
	
	private int getkeyOfMaxValue(int[] countMatchWord) {
		int indexOfMax = 0;
		for(int i = 1, len = countMatchWord.length; i < len; i++) {
			indexOfMax = countMatchWord[indexOfMax] < countMatchWord[i]? i : indexOfMax;
		}
		return indexOfMax;
	}
	
	
	private int countMatchingWordWithDict() {
		getDecryptedWordList();
		List<String> wordList = EnglishDictionary.getWordListInDictionary();
		
		int count = 0;
		
		for(String word : wordListInFile) {
			if(wordList.contains(word)) {
				count++;
			}
		}
		return count;
	}
	
	private void getDecryptedWordList() {
		
		try (
				FileReader fin = new FileReader(file);
				BufferedReader in = new BufferedReader(fin);
			){
			getWordListInDecryptedFile(in);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void getWordListInDecryptedFile(BufferedReader in) throws IOException {
		wordListInFile.clear();
		String line;
		
		for(int i = 0; i < 10 && (line = in.readLine()) != null; i++) {
			if(line.trim().equals("") || line.length() < 5) {
				i--;
			} else {
				makeWordListInLine(line);
			}
		}
		//System.out.println(wordListInFile);
	}
	
	private void makeWordListInLine(String line) {
		String word = "";
		for(char ch : line.toCharArray()) {
			ch = decryptCharacter(ch);
			if(Character.isAlphabetic(ch)) {
				word += ch;
			} else if (!word.isEmpty()){
				wordListInFile.add(word);
				word = "";
			}
		}
	}
	
	private void printLines() {
		
		try (
				FileReader fin = new FileReader(file);
				BufferedReader in = new BufferedReader(fin);
			){
			printDecryption(in);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void printDecryption (BufferedReader in) throws IOException {
		String line;
		
		for(int i = 0; i < 10 && (line = in.readLine()) != null; i++) {
			if(line.trim().equals("") || line.length() < 5) {
				i--;
			} else {
				for(char ch : line.toCharArray()) {
					ch = decryptCharacter(ch);
					System.out.print(ch);
				}
			}
			System.out.println();
		}
		
	}
	
	private char decryptCharacter(char ch) {
		if (Character.isUpperCase(ch)) {
			ch = (char) ('A' + ((26 + ((ch-'A')- key)) % 26));
		} else if (Character.isLowerCase(ch)) {
			ch = (char) ('a' + ((26 + ((ch-'a')- key)) % 26));
		} 
		return ch;
	}	

}
