package round1b2019;
/*
ID: urd00m
LANG: JAVA
TASK: crepe
 */
import java.io.*;
import java.util.*;

public class crepe {
	static int t; 
	static int n, q; 
	static HashMap<Integer, pair> facingx, facingy; 
	static Integer[] x;
	static Integer[] y; 
	static int totalw, totals; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
		t = Integer.parseInt(f.readLine()); 
		for(int cn = 1; cn < t+1; cn++) {
			input = new StringTokenizer(f.readLine()); 
			n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken()); 
			//store the people
			//isolate x and y 
			//and find the coordinates
			totalw = 0; 
			totals = 0; 
			facingx = new HashMap<Integer, pair>();
			facingy = new HashMap<Integer, pair>();
			for(int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine()); 
				int a = Integer.parseInt(input.nextToken()); int b = Integer.parseInt(input.nextToken()); String c = input.nextToken();
				if(c.equals("N") || c.equals("S")) {
					if(facingy.containsKey(b) == false) {
						facingy.put(b, new pair( c.equals("S") ? 1 : 0, c.equals("N") ? 1 : 0)); 
					}
					else {
						if(c.equals("S"))
							facingy.get(b).l++; 
						else facingy.get(b).r++;
					}
					if(c.equals("S")) totals++; 
				}
				else {
					if(facingx.containsKey(a) == false) {
						facingx.put(a, new pair( c.equals("W") ? 1 : 0, c.equals("E") ? 1 : 0)); 
					}
					else {
						if(c.equals("W"))
							facingx.get(a).l++; 
						else facingx.get(a).r++; 
					}
					if(c.equals("W")) totalw++; 
				}
			}
			
			//sorting x and y 
			x = facingx.keySet().toArray(new Integer[facingx.keySet().size()]); 
			y = facingy.keySet().toArray(new Integer[facingy.keySet().size()]); 
			Arrays.sort(x);
			Arrays.sort(y);
			
			
			//doing horozontal first
			int maxLocx = 0; 
			int maxx = totalw;
			int totale = 0; 
			for(int i = 0; i < x.length; i++) {
				totale += facingx.get(x[i]).r; 
				totalw -= facingx.get(x[i]).l; 
				int factor = 0; 
				if(facingx.containsKey(x[i]+1)) factor = facingx.get(x[i]+1).l;  
				int votes = totalw+totale-factor; 
				if(maxx < votes) {
					maxx = votes;
					maxLocx = x[i]+1; 
				}
			}
			int maxLocy = 0; 
			int maxy = totals;
			int totaln = 0;
			for(int i = 0; i < y.length; i++) {
				totaln += facingy.get(y[i]).r; 
				totals -= facingy.get(y[i]).l;
				int factor = 0; 
				if(facingy.containsKey(y[i]+1)) factor = facingy.get(y[i]+1).l;  
				int votes = totals+totaln - factor; 
				if(maxy < votes) {
					maxy = votes;
					maxLocy = y[i]+1; 
				}
			}
			
			System.out.println("Case #" + cn + ": " + maxLocx + " " + maxLocy);
		}
	
	}
	
	public static class pair {
		int l, r; //horozontal l = w, r = e    vertical l = s r = n 
		public pair(int a, int b) {
			l = a; 
			r = b; 
		}
	}
	public static class tuple {
		int x, y; 
		String direction; 
		public tuple(int a, int b, String c) {
			x = a; 
			y = b; 
			direction = c; 
		}
	}
}
