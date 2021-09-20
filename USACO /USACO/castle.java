package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: castle
 */

import java.util.*;
import java.io.*;

public class castle {
	static String[][] floor ;
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("castle.in"));
		//take in input and add to a 2D array 
		int h,v; 
		StringTokenizer lineinput = new StringTokenizer(in.readLine());
		h = Integer.parseInt(lineinput.nextToken());
		v = Integer.parseInt(lineinput.nextToken());
		floor = new String[v*2+1][h*2+1];
		//initialize
		for(int i = 0; i < v*2+1; i++) {
			for(int j = 0; j < h*2+1; j++) {
				floor[i][j] = " "; 
			}
		}
		//setting the array
		for(int i = 1; i < v*2+1; i += 2) {
			lineinput = new StringTokenizer(in.readLine());

			for(int j = 1; j < h*2+1; j += 2) {
				add(Integer.parseInt(lineinput.nextToken()),i,j); //setting the 2d area
			}
		}
		
		//to test
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		for(int i = 0; i < v*2+1; i++) {
			for(int j = 0; j < h*2+1; j++) {
				out.print(floor[i][j]);
			}
			out.println();
		}
		out.close();
	}
	public static void add(int record, int index1, int index2)  { //adds record to the 2d array, only for one point
		/*
		    1: wall to the west
			2: wall to the north
			4: wall to the east
			8: wall to the south
		 */
		if(record >= 8) { //south wall
			record -= 8;  //the 3 bellow it get set to a wall
			floor[index1-1][index2-1] = "#";
			floor[index1-1][index2] = "#";
			floor[index1-1][index2+1] = "#";
			
		}
		if(record >= 4) { //east wall
			record -= 4;  //the 3 to the right it get set to a wall
			floor[index1-1][index2] = "#";
			floor[index1][index2] = "#";
			floor[index1+1][index2] = "#";
		}
		if(record >= 2) { //north wall
			record -= 2;  //the 3 above it get set to a wall
			floor[index1+1][index2-1] = "#";
			floor[index1+1][index2] = "#";
			floor[index1+1][index2+1] = "#";
		}
		if(record >= 1) { //west wall
			record -= 1;  //the 3 to the left gets set to a wall
			floor[index1-1][index2+1] = "#";
			floor[index1][index2+1] = "#";
			floor[index1+1][index2+1] = "#";
		}
	}

}
