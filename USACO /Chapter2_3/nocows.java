package Chapter2_3;
/*
ID: alan.li2
LANG: JAVA
TASK: nocows
 */

import java.util.*;
import java.io.*;

public class nocows {
	static int n, k; 
	static int[][] treePos = new int[101][201]; //depth of 100, max nodes of 200
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		n = Integer.parseInt(in.nextToken());
		k = Integer.parseInt(in.nextToken());
		f.close();
		//initialization
		treePos[1][1] = 1; //node 1 with depth of one has 1 possibility 
		treePos[2][3] = 1; //node 3 with depth of 2 has 1 possibility 
		
		//algorithm
		//Dynamic programming
		for(int i = 3; i <= k; i++) {
			for(int j = 1; j <= n; j += 2) {
				for(int nodeOne = j - 2; nodeOne >= 1; nodeOne -= 2) {
					//second node value found by doing j-1-nodeOne = nodeTwo
					for(int nodeTwoHeights = 1; nodeTwoHeights <= i-1; nodeTwoHeights++) {
						int c = 2; 
						if(nodeTwoHeights == i-1) c = 1;
						treePos[i][j] += (c*treePos[i-1][nodeOne] * treePos[nodeTwoHeights][j-1-nodeOne]);
						treePos[i][j] %= 9901;
						//print();
					}
				}
			}
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		out.println(treePos[k][n]);
		out.close(); 
	}
	
	public static void print() {
		for(int[] item : treePos) {
			for(int value : item) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
