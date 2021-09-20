package Chapter2_3;
/*
ID: alan.li2
LANG: JAVA
TASK: zerozum
 */

import java.util.*;
import java.io.*;
public class zerosum {
	static int n;
	static ArrayList<String> output = new ArrayList<String>();
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		n = Integer.parseInt(f.readLine());
		f.close();
		
		//algorithm 
		//recursive search
		//brute force attack
		recur("1", 2, 0, "1");
		//sort
		Collections.sort(output);
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		for(String val : output) {
			out.println(val);
		}
		out.close();
				
	}
	
	//cur starts at one and idx starts at 2 
	public static void recur(String cur, int idx, int sum, String answer) {
		//three test cases
		//adding space
		//adding addition sign
		//adding subtraction sign 
		
		//base case 
		if(idx > n) {
			if(sum+Integer.parseInt(cur) == 0) {
				output.add(answer); 
			}
		}
		else {
			//blank space
			recur(cur+idx, idx+1, sum, answer + " " + idx);
			//addition sign 
			recur("" + idx, idx + 1, sum + Integer.parseInt(cur), answer + "+" + idx);
			//subtraction sign
			recur("-" + idx, idx + 1, sum + Integer.parseInt(cur), answer + "-" + idx);
			
		}
	}

}
