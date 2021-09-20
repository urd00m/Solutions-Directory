package a500_600;
/*
ID: urd00m
LANG: JAVA
TASK: uva524
 */
import java.util.*;
import java.io.*;

public class uva524 {
	static boolean[] isPrime = new boolean[32]; 
	static ArrayList<String> output = new ArrayList<String>(); 
	static boolean[] used; 
	static int caseNum = 1; 
	public static void main(String args[]) throws IOException, InterruptedException {
		init(); 
		Thread.sleep(3000);
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		while(f.ready()) {
			int n = Integer.parseInt(f.readLine()); 
			used = new boolean[n+1];
			used[1] = true; 
			recur("1", n-1, 1); 
			System.out.println("Case " + caseNum++ + ":");
			Collections.sort(output, new Comparator<String>() {
				@Override
				public int compare(String a, String b) {
					String[] a1 = a.split(" "); 
					String[] b1 = b.split(" ");
					for(int i = 0; i < a1.length; i++) {
						if(Integer.parseInt(a1[i]) < Integer.parseInt(b1[i])) return -1;
						else if (Integer.parseInt(a1[i]) > Integer.parseInt(b1[i])) return 1; 
					}
					return 0;
				}
			}); 
			for(String item : output) System.out.println(item);
			System.out.println();
			output.clear();
		}
	}
	public static void init() {
		isPrime[2] = true; isPrime[3] = true; isPrime[5] = true; isPrime[7] = true; isPrime[11] = true; isPrime[13] = true; isPrime[17] = true; isPrime[19] = true; isPrime[23] = true; isPrime[29] = true; isPrime[31] = true; 
	}
	
	public static void recur(String ret, int n, int prev) {
		if(n == 0) {
			if(isPrime[prev+1] == true) output.add(ret);
		}
		else {
			for(int i = 1; i < used.length; i++) {
				if(used[i] == false && isPrime[i+prev] == true) {
					used[i] = true; 
					recur(ret + " " + i, n-1, i); 
					used[i] = false; 
				}
			}
		}
	}
}
