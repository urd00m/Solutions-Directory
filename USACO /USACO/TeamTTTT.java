package USACO;

/* 
 * ID: alan.li2
 * LANG: java
 * TASK: Team Tic Tac Toe
 */


import java.io.*;
import java.util.*;

public class TeamTTTT {
	
	private static int Scow = 0;
	private static int Mcow = 0;
        private static ArrayList<String> win = new ArrayList<String>();
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		//anything for 2 in the same column or line or horozontally then scan the next one
		
		
		char[][] input = new char[3][3];
		for(int i = 0; i < 3; i++) {
			String read = f.readLine();
			for(int j = 0; j < 3; j++) {
				input[i][j] = read.charAt(j);
			}
		}
		
		check(input[0][0], input[0][1], input[0][2]);
		check(input[0][0], input[1][1], input[2][2]);
		check(input[0][0], input[1][0], input[2][0]);

		check(input[0][1], input[1][1], input[2][1]);
		
		check(input[0][2], input[1][2], input[2][2]);
		check(input[0][2], input[1][1], input[2][0]);
		
		check(input[1][0], input[1][1], input[1][2]);
		
		check(input[2][0], input[2][1], input[2][2]);
		
		out.println("" + Scow);
		out.println("" + Mcow);
		out.close();
		
	}
	
	public static int check(char a, char b, char c) {
		if(a == b || a == c || c == b) {
			if( win.contains("" + a) == true || win.contains("" + a+b) == true || win.contains("" + a+c) == true || win.contains("" + b+c) == true) return 1;
			
			if(a == b && b == c) {
				win.add("" + a); 
				Scow++;
			}
			else {
				if(a == b) {
					win.add("" + a+b);
					win.add("" + b+a);
				}
				else if(a == c) {
					win.add("" + a+c);
					win.add("" + c + a);
				}
				else {
					win.add("" + b + c);
					win.add("" + c + b);	
				}
				Mcow++;
			}
		}
		return 1;
	}

}
