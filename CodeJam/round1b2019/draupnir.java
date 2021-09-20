package round1b2019;
/*
ID: urd00m
LANG: JAVA
TASK: draupnir
 */
import java.io.*;
import java.util.*;

public class draupnir {
	static int t, w; 
	static long r1, r2, r3, r4, r5, r6; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input = new StringTokenizer(f.readLine()); 
		t = Integer.parseInt(input.nextToken()); w = Integer.parseInt(input.nextToken()); 
		for(int cn = 1; cn < t+1; cn++) {
			//ask for day 200 
			System.out.println("200");
			long temp = Long.parseLong(f.readLine());
			r6 = (long) (((temp)%(Math.pow(2, 40)))/(Math.pow(2, 33))); 
			r5 = (long)( ((temp)%(Math.pow(2, 50))-(r6*Math.pow(2, 33)))/Math.pow(2, 40)); 
			r4 = (long) ((temp - r5*Math.pow(2, 40) - r6*Math.pow(2, 33))/Math.pow(2, 50));
			System.out.println("40");
			temp = Long.parseLong(f.readLine()); 
			long sub = (long) (r4*Math.pow(2, 10)+r5*Math.pow(2, 8) + r6*Math.pow(2, 6)); 
			r3 = (long)(((temp%Math.pow(2, 20))-sub)/Math.pow(2, 13) ); 
			r2 = (long)( ((temp%Math.pow(2, 40))-sub-(r3*Math.pow(2, 13)))/Math.pow(2, 20));
			r1 = (long)( (temp-sub-(r3*Math.pow(2, 13))-(r2*Math.pow(2, 20)))/Math.pow(2, 40)  );
			System.out.println(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5 + " " + r6);
			int verdict = Integer.parseInt(f.readLine()); 
			if(verdict == -1) break; 
		}
		
	}
}
