package Free_Response;

import java.util.ArrayList;
import java.util.List;

public class freeResponse2014 {
	
	public static void main(String args[]) {
		List<String> testList = new ArrayList<String>();
		testList.add("TAN");
		testList.add("ABRACADABRA");
		testList.add("WHOA");
		testList.add("APPLE");
		testList.add("EGGS");
		System.out.println(scrambleWord("ABRACADABRA"));  //ABRACADABRA
		scrambleOrRemove(testList);
		print(testList);
		
	}
	
	public static String scrambleWord(String word) {
		String scrambled = "";
		for(int i = 0; i < word.length(); i++) {
			if(word.substring(i,i+1).equals("A") == true) {
				if( i < (word.length()-1) && word.substring(i+1,i+2).equals("A") == false) {
					scrambled = scrambled + word.substring(i+1,i+2) + word.substring(i,i+1);
					i++;
				}
				else  {
					scrambled = scrambled + word.substring(i,i+1);
				}
			}
			else {
				scrambled = scrambled + word.substring(i,i+1);
			}
		}
		return scrambled;
	}
	
	public static void scrambleOrRemove(List<String> wordList) {
		for(int i = 0; i < wordList.size(); i++) {
			if(scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
				wordList.remove(i);
				i--;
			}
			else {
				wordList.add(i, scrambleWord(wordList.get(i)));
				wordList.remove(i+1);
			
			}
		}
	}
	public static void print(List<String> print) {
		for(String i:print) {
			System.out.println(i);
		}
	}

}
