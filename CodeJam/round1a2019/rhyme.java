package round1a2019;
/*
ID: urd00m
LANG: JAVA
TASK: rhyme
 */
import java.io.*;
import java.util.*;

public class rhyme {
	static int t; 
	static int n; 
	static ArrayList<String> words = new ArrayList<String>(); 
	public static void main(String args[]) throws IOException { 
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			words.clear();
			n = Integer.parseInt(f.readLine()); 
			//reversing all the strings and then sorting the array strings and just find the best match (greedy) 
			for(int i = 0; i < n; i++) {
				words.add(reverse(f.readLine())); 
			}
			Collections.sort(words); 
			
			int ret = 0; 
			HashMap<String, Boolean> used = new HashMap<String, Boolean>(); 
			while(true) {
				int max = 0; 
				int maxLoc = -1; 
				String ms = ""; 
				for(int i = 0; i < words.size()-1; i++) {
					int match = 0;
					String a = "";
					String b = ""; 
					for(int j = 0; j < words.get(i).length(); j++) {
						if(j < words.get(i+1).length() && words.get(i).charAt(j) == words.get(i+1).charAt(j)) {
							if(used.containsKey(a+b+words.get(i).charAt(j))) {
								b += words.get(i).charAt(j); 
								continue;
							}
							a += b + words.get(i).charAt(j);
							b = ""; 
							match = j+1; 
						}
						else break; 
					}
					if(match > max && used.containsKey(a) == false) {
						max = match; 
						maxLoc = i; 
						ms = a; 
					}
				}
				if(maxLoc == -1) break; 
				ret += 2; 
				words.remove(maxLoc); words.remove(maxLoc); 
				used.put(ms, true);
			}
			
			//output
			System.out.println("Case #" + cn + ": " + ret);
		}
	}
	
	public static String reverse(String a) {
		String ret = ""; 
		for(int i = a.length()-1; i >= 0; i--) {
			ret += a.substring(i, i+1); 
		}
		return ret; 
	}
}
