//package a107;
/*
ID: urd00m
LANG: JAVA
TASK: uva10718
 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input; 
		//Thread.sleep(3000);
		while(f.ready() == true) {
			input = new StringTokenizer(f.readLine()); 
			long n = Long.parseLong(input.nextToken()); long l = Long.parseLong(input.nextToken()); long u = Long.parseLong(input.nextToken());
			long m = l; 
			for(int i = 32; i >= 0; i--) {
				if( ((1L<<i) & n) != 0) { //if that bit is one we want the corresponding bit in m to be 0 (minimum m) 
					m &= ~(1L<<i); 
					if(m < l) m |= (1L<<i); //if we fall under l then we want to undo that 
				}
				else { //if that bit is 0 we want to maximize n|m so we set the corresponding bit to 1 
					m |= (1L<<i); 
					if(m > u) m &= ~(1L<<i); //if that makes it bigger than it is supposed to be we undo it 
				}
			}
			long m2 = u; 
			for(int i = 32; i >= 0; i--) {
				if( ((1L<<i) & n) != 0) { //if that bit is one we want the corresponding bit in m to be 0 (minimum m) 
					m2 &= ~(1L<<i); 
					if(m2 < l) m2 |= (1L<<i); //if we fall under l then we want to undo that 
				}
				else { //if that bit is 0 we want to maximize n|m so we set the corresponding bit to 1 
					m2 |= (1L<<i); 
					if(m2 > u) m2 &= ~(1L<<i); //if that makes it bigger than it is supposed to be we undo it 
				}
			}
		//	System.out.println( (n|m) + " " + (n|m2) + " " + m + " " + m2); 
			System.out.println( ( ((n|m) > (n|m2)) ? m : ((n|m) == (n|m2)) ? ((m<m2) ? m : m2) : m2) );
		}
	}
}
