//package src;

/*
ID: urd00m
LANG: JAVA
TASK: PRIME1
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class Prime1 {
	static int t; 
	//static boolean[] prime = new boolean[1000000000]; 
	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine());
		for(int i = 0; i < t; i++) {
			input = new StringTokenizer(f.readLine()); 
			int l = Integer.parseInt(input.nextToken()); 
			int r = Integer.parseInt(input.nextToken()); 
			for(int j = l; j <= r; j++) { //brute force with a prime checker
				if( isPrime(j) == true) { //prime[j] == true ||
					//prime[j] = true; 
					System.out.println(j);
				}
			}
			System.out.println();
		}
		f.close();
	}

	public static boolean isPrime(int num) {
		int temp;
		if(num == 1) return false; 
		boolean isPrime = true;
		for (int i = 2; i*i <= num; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
