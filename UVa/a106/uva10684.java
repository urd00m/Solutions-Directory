package a106;
/*
ID: urd00m
LANG: JAVA
TASK: uva10684
 */
import java.io.*;
import java.util.*;

public class uva10684 {
	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
		int n = Integer.parseInt(f.readLine()); 
		while(n != 0) {
			int[] bets = new int[n]; 
			int max = 0; 
			StringTokenizer input = new StringTokenizer("");
			for(int i = 0; i < n; i++) {
				while(input.hasMoreElements() == false) input = new StringTokenizer(f.readLine()); 
				bets[i] = Integer.parseInt(input.nextToken()); 
			}
			int sum = 0; 
			for(int i = 0; i < n; i++) {
				sum += bets[i]; 
				if(sum > max) max = sum; 
				if(sum < 0) sum = 0;
			}
			if(max == 0) System.out.println("Losing streak.");
			else System.out.println("The maximum winning streak is " + max + ".");
			
			while(input.hasMoreElements() == false) input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); 
		}
	}
}
