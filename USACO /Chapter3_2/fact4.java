//package Chapter3_2;
/*
ID: alan.li2
LANG: JAVA
TASK: fact4
 */

import java.io.*;
import java.util.*;

public class fact4 {
	static int n;
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("fact4.in")); 
		n = Integer.parseInt(f.readLine()); 
		f.close(); 
		//only maintain a small amount of digits 
		int store = 1; 
		for(int i = 2; i <= n; i++) {
			store *= i; 
			while(store%10 == 0) store = store/10; 
			store %= 1000000; 
		}
		
		
		//output: 2nd to last digit of store
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out"))); 
		out.println(store%10);
		out.close();
	}
}
