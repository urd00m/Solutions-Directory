//package a101;

/*
ID: urd00m
LANG: JAVA
TASK: uva10171
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] graphU, graphM;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		n = Integer.parseInt(f.readLine());
		while (n != 0) {
			graphU = new int[26][26];
			graphM = new int[26][26];
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					graphM[i][j] = 1000000000;
					graphU[i][j] = 1000000000;
					if(i == j) {
						graphU[i][j] = 0;
						graphM[i][j] = 0; 
					}
				}
			}
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				if (input.nextToken().charAt(0) == 'Y') {
					char temp = input.nextToken().charAt(0);
					int a = input.nextToken().charAt(0) - 'A';
					int b = input.nextToken().charAt(0) - 'A';
					int c = Integer.parseInt(input.nextToken());
					graphU[a][b] = Math.min(graphU[a][b], c);
					if (temp == 'B')
						graphU[b][a] = Math.min(graphU[b][a], c);
				} else {
					char temp = input.nextToken().charAt(0);
					int a = input.nextToken().charAt(0) - 'A';
					int b = input.nextToken().charAt(0) - 'A';
					int c = Integer.parseInt(input.nextToken());
					graphM[a][b] = Math.min(graphM[a][b], c);
					if (temp == 'B')
						graphM[b][a] = Math.min(graphM[b][a], c);
				}
			}

			// APSP : can be done with dijistrika's but since it only has 26 nodes floyd-warshalls works fast enough and is much simplier 
			for (int k = 0; k < 26; k++) {
				for (int i = 0; i < 26; i++) {
					for (int j = 0; j < 26; j++) {
						if (graphU[i][k] + graphU[k][j] < graphU[i][j])
							graphU[i][j] = graphU[i][k] + graphU[k][j];
						if (graphM[i][k] + graphM[k][j] < graphM[i][j])
							graphM[i][j] = graphM[i][k] + graphM[k][j];
					}
				}
			}
			//searching
			int min = 1000000000; ArrayList<Character> minLoc = new ArrayList<Character>();  
			input = new StringTokenizer(f.readLine()); 
			int a = input.nextToken().charAt(0)-'A'; int b = input.nextToken().charAt(0)-'A'; 
			for(int i = 0; i < 26; i++) {
				if(min > graphU[a][i]+graphM[b][i]) {
					minLoc.clear();
					min = graphU[a][i]+graphM[b][i]; 
					minLoc.add((char)(i+'A')); 
				}
				else if(graphU[a][i]+graphM[b][i] != 1000000000 && min == graphU[a][i]+graphM[b][i]) {
					minLoc.add((char)(i+'A')); 
				}
			}
			if(minLoc.size() == 0) System.out.println("You will never meet.");
			else {
				System.out.print(min);
				for(char item : minLoc) System.out.print(" " + item);
				System.out.println(); 
			}
			n = Integer.parseInt(f.readLine());
		}
	}
}
