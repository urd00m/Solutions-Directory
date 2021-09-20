//package Chapter3_2;
/*
ID: alan.li2
LANG: JAVA
TASK: spin
 */
import java.util.*;
import java.io.*;

public class spin {
	static int[] speeds = new int[5]; 
	static int[][] wedgeStart = new int[5][5];
	static int[][] wedgeEnd = new int[5][5];
	static int[] numWedges = new int[5]; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("spin.in")); 
		for(int count = 0; count < 5; count++) {
			StringTokenizer input = new StringTokenizer(f.readLine());
			speeds[count] = Integer.parseInt(input.nextToken()); 
			numWedges[count] = Integer.parseInt(input.nextToken()); 
			for(int i = 0; i < numWedges[count]; i++) {
				wedgeStart[count][i] = Integer.parseInt(input.nextToken()); 
				wedgeEnd[count][i] = Integer.parseInt(input.nextToken()); 
				wedgeEnd[count][i] += wedgeStart[count][i]; 
			}
 		}
		f.close();
		//brute force 
		int t; 
		for(t = 0; t < 360; t++) {
			if(overlap() == true) 
				break; 
			else {
				addSpeed();
			}
		}
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
		if(t == 360) 
			out.println("none");
		else 
			out.println(t); 
		out.close();
		
	}
	public static void addSpeed() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < numWedges[i]; j++) {
				wedgeStart[i][j] += speeds[i]; 
				wedgeEnd[i][j] += speeds[i]; 
			}
		}
	}
	public static boolean overlap() {
		int[] light = new int[360]; 
		for(int i = 0; i < 5; i++) { //wheel number
			for(int j = 0; j < numWedges[i]; j++) { //wedges 
				for(int k = wedgeStart[i][j]; k < wedgeEnd[i][j]+1; k++) { //adds wedges 
					if(light[k%360] == i) {
						light[k%360] = i+1;
						if(i+1 == 5) //there is a allighnement 
							return true; 
					}
				}
			}
		}
		return false; 
	}
}
