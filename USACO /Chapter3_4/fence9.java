//package Chapter3_4;
/*
ID: alan.li2
LANG: JAVA
TASK: fence9
 */

import java.io.*; 
import java.util.*;
public class fence9 {
	static double x1, y1, x2; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("fence9.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		x1 = Double.parseDouble(input.nextToken());
		y1 = Double.parseDouble(input.nextToken()); 
		x2 = Double.parseDouble(input.nextToken());
		f.close();
		
		//algorithm
		//if both positive slope 
		int total = 0; 
		for(int i = 1; i <  Math.max((int)x1, (int)x2); i++) {
			if((-y1/(x2-x1)) < 0) {
				double temp = Math.min( (y1/x1)*(i*1.0), (-y1/(x2-x1))*( (i*1.0)-x1) + y1);
				temp -= .0000000001; 
				int tempInt = (int)(temp); 
				total += tempInt; 
			}
			else {
				int store = (int)(((-y1/(x2-x1))*( (i*1.0)-x1) + y1)+.99999999999);
				if( ((int)((-y1/(x2-x1))*( (i*1.0)-x1) + y1)) * 1.0 == ((-y1/(x2-x1))*( (i*1.0)-x1) + y1) ) store++; //lower bound 
				for(int j = (int)Math.max(1, store); j<((y1/x1)*(i*1.0)); j++) {
					total++;
				}
			}
		}
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence9.out"))); 
		out.println(total);
		out.close();
	}
}
