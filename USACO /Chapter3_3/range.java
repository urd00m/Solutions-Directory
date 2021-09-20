//package Chapter3_3;
/*
ID: alan.li2
LANG: JAVA
TASK: range
 */
import java.util.*;
import java.io.*;

public class range {
	static int n; 
	static int[][] field; 
	static int[] eatable; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("range.in"));
		n = Integer.parseInt(f.readLine());
		eatable = new int[n+1]; 
		field = new int[n][n]; 
		for(int i = 0; i < n; i++) {
			String input = f.readLine(); 
			for(int j = 0; j < n; j++) {
				field[i][j] = input.charAt(j) - 48; 
			}
		}
		f.close();
		//algorithm: brute force with time savers 
		for(int i = 2; i <= n; i++) {
			int[][] store = new int[n][n]; 
			for(int a = 0; a < n-i+1; a++) {
				for(int b = 0; b < n-i+1; b++) {
					if(field[a][b] != 0 && field[a+1][b] != 0 && field[a][b+1] != 0 && field[a+1][b+1] != 0) {
						eatable[i]++; 
						store[a][b] = 1; 
					}
				}
			}
			field = store; 
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out"))); 
		for(int i = 0; i <= n; i++) {
			if(eatable[i] != 0) out.println(i + " " + eatable[i]);
		}
		out.close(); 
	}
}
