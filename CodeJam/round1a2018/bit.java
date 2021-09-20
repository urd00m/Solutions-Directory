package round1a2018;
/*
ID: urd00m
LANG: JAVA
TASK: bit
 */
import java.io.*;
import java.util.*; 

public class bit {
	static int t;
	static int r, b, c; 
	static int[][] cashier; 
	public static void main(String args[]) throws IOException {
		//input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			r = Integer.parseInt(input.nextToken()); b = Integer.parseInt(input.nextToken()); c = Integer.parseInt(input.nextToken());
			cashier = new int[c][3]; //goings m, s, and p respectively
			int maxS = 0; 
			int maxP = 0; 
			for(int i = 0; i < c; i++) {
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken()); int c = Integer.parseInt(input.nextToken());   
				cashier[i][0] = a; 
				cashier[i][1] = b; 
				cashier[i][2] = c; 
				maxS = Math.max(maxS, b); 
				maxP = Math.max(maxP, c); 
			}
			long l = 0; 
			long r = (long)((long)maxS*(long)b + (long)maxP + 1);  
			while(l + 1 < r) {
				long mid = (l+r)/2; 
				if(works(mid)) 
					r = mid; 
				else {
					l = mid; 
				}
			}
			System.out.println("Case #" + cn + ": " + r);
		}
	}
	
	public static boolean works(long t) {
		ArrayList<Long> store = new ArrayList<Long>(); 
		for(int i = 0; i < c; i++) 
			store.add((long)Math.max(0, Math.min(cashier[i][0], Math.floor((t-(long)cashier[i][2])/(long)cashier[i][1]))));  
		Collections.sort(store); //increasing order so we have to go backwards
		long totalBits = 0;
		int j = store.size()-1; 
		for(int i = 0; i < r; i++) { //r is always less than or equal to size 
			totalBits+=store.get(j); 
			j--; //next cashier 
		}
		
		return (totalBits >= b); //if we have enough bits then T works 
	}
}
