//package Chapter4_3;
/*
ID: alan.li2
LANG: JAVA
TASK: lgame
 */
import java.util.*;
import java.io.*;

public class lgame {
	static int[] charToInt = {2,5,4,4,1,6,5,5,1,7,6,3,5,2,3,5,7,2,1,2,4,6,6,7,5,7}; //a is 97 
	static int[] letters = new int[26]; 
	static int max = 0; 
	static ArrayList<String> words = new ArrayList<String>(); //storage for the words 
	static ArrayList<int[]> wordsLetters = new ArrayList<int[]>(); //the letters contained in the wrods 
	static ArrayList<String> maxWords = new ArrayList<String>();  // the max words 
	static ArrayList<int[]> maxLetters = new ArrayList<int[]>(); //the letters contained in the max wrods 
	static int[] transfer; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("lgame.in")); 
		String input = f.readLine(); 
		for(int i = 0; i < input.length(); i++) {
			letters[input.charAt(i)-97]++; 
		}
		f = new BufferedReader(new FileReader("lgame.dict")); 
		input = f.readLine();
		//algorithm brute force 
		while(input.equals(".") == false) {
			int[] totalUsed = new int[26]; 
			int score = 0; 
			for(int i = 0; i < input.length(); i++) {
				if(letters[(input.charAt(i)-97)] > totalUsed[(input.charAt(i)-97)]) { //if we have enough letters 
					score += charToInt[(input.charAt(i)-97)]; 
					totalUsed[(input.charAt(i)-97)]++;
				}
				else { //if we don't we can't use that word 
					score = -1; 
					break; 
				}
			}
			if(score != -1) {
				words.add(input); 
				wordsLetters.add(totalUsed);
				if(score > max) {
					max = score; 
					maxWords.clear(); 
					maxLetters.clear(); 
					maxWords.add(input); 
					maxLetters.add(totalUsed); 
				}
				else if (score == max) {
					maxWords.add(input); 
					maxLetters.add(totalUsed); 
				}
				
				for(int i = 0; i < wordsLetters.size(); i++) {
					//checks all words that could be words and sees if current word plus that word work 
					int temp = check(wordsLetters.get(i),totalUsed);
					if(temp >= max) {
						if(temp > max) {
							max = temp; 
							maxWords.clear();
							maxLetters.clear();
						}
						if(words.get(i).compareTo(input) > 0) {
							maxWords.add(input + " " + words.get(i)); 
							maxLetters.add(transfer);
						}
						else {
							maxWords.add(words.get(i) + " " + input); 
							maxLetters.add(transfer);
						}
					}
				}
			}
			input = f.readLine(); 
		}
		f.close();
		
		//output
		Collections.sort(maxWords);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lgame.out"))); 
		out.println(max);
		for(String word : maxWords)
			out.println(word);
		out.close();
	}
	
	public static int check(int[] a, int[] b) {
		int score = 0; 
		int[] temp = new int[26]; 
		for(int i = 0; i < 26; i++) {
			if(a[i]+b[i] > letters[i]) {
				score = -1; 
				break;
			}
			else {
				score += charToInt[i]*(a[i]+b[i]); 
				temp[i] = a[i]+b[i]; 
			}
		}
		//other info returned 
		transfer = temp; 
		return score; 
	}
}
