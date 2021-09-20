package Chapter2_3;
/*
ID: alan.li2
LANG: JAVA
TASK: prefix
 */

import java.util.*;
import java.io.*;

public class prefix {
	@SuppressWarnings("unchecked")
	static ArrayList<String>[] prefixes = new ArrayList[26];
	static String word = " ";
	static int longestPrefix = 0;

	public static void main(String args[]) throws IOException {
		// input
		long time = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		String inputWord = input.nextToken();
		for (int i = 0; i < 26; i++) {
			prefixes[i] = new ArrayList<String>();
		}
		do {
			prefixes[inputWord.charAt(0) - 'A'].add(inputWord);
			if (input.hasMoreTokens() == false)
				input = new StringTokenizer(f.readLine());
			inputWord = input.nextToken();
		} while (inputWord.equals(".") != true);
		StringBuilder sb=new StringBuilder();
		String line; 
		while ((line=f.readLine())!=null) {
			sb.append(line);
		}
		word=" " + sb.toString();
		f.close();
		// algorithm
		// dynamic programming building off the previous result

		// sort
		for (int i = 0;i <  Math.min(word.length()-1, longestPrefix+1); i++) {
			int index = word.charAt(i + 1) - 'A';
			for (String item : prefixes[index]) {
				if (i+item.length() > longestPrefix && i+1 + item.length() <= word.length()
						&& word.substring(i + 1, i + item.length() + 1).equals(item) == true) {
					longestPrefix = Math.max(longestPrefix, i+item.length());
				}
			}

		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		out.println("" + (longestPrefix));
		out.close();
		System.out.println(System.currentTimeMillis() - time);
	}

}
