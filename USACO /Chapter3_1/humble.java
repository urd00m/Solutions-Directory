//package Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: humble
 */
import java.io.*;
import java.util.*;

public class humble {
	static int[] primes; 
	static int numOfPrimes; 
	static int nthHumbleNum; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("humble.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		numOfPrimes = Integer.parseInt(input.nextToken());
		nthHumbleNum = Integer.parseInt(input.nextToken()); 
		primes = new int[numOfPrimes]; 
		//The primes
		for(int count = 0; count < numOfPrimes; count++) {
			if(input.hasMoreTokens() == false)
				input = new StringTokenizer(f.readLine()); 
			String a = input.nextToken(); 
			primes[count] = (Integer.parseInt(a)); 
		}
		f.close(); 
		
		//dynamic, finding previous humble numsa and building off that. 
		long[] humbleNums = new long[nthHumbleNum+1];
		int[] idx = new int[numOfPrimes]; 
		humbleNums[0] = 1; //first humble number is always 1, but isn't included in our count, so it is at position zero 
		for(int i = 1; i <= nthHumbleNum; i++) { //finds all the humble nums up to the nth one 
			long best = Integer.MAX_VALUE; 
			for(int j = 0; j < numOfPrimes; j++) { //goes through the primes, finding the next humble number not already in the set using that prime 
				while(idx[j] < i && primes[j]*humbleNums[idx[j]] <= humbleNums[i-1]) 
					idx[j]++; 
				best = min(best, primes[j]*humbleNums[idx[j]]); //the minimum out of all the values generated is the next humble num 
			}
			humbleNums[i] = best; 
		}
		print(humbleNums); 		
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out"))); 
		out.println(humbleNums[nthHumbleNum]);
		out.close();
	}
	//utility functions 
	private static long min(long a, long b) {
		if(a < b) 
			return a;
		else return b; 
	}

	public static void print(long[] a) {
		for(long item : a) {
			System.out.println(item);
		}
	}

}
