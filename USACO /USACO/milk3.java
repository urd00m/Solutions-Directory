package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: milk3
 */
import java.util.*;
import java.io.*;

public class milk3 {
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(in.nextToken());
		int b = Integer.parseInt(in.nextToken());
		int c = Integer.parseInt(in.nextToken());
		find(0, 0, c, a, b, c, 10);
		//can use recursion to enmurate all of the possiblilities 
		//sort the arraylist
		System.out.println(nums.size());
		Collections.sort(nums);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		for(int i = 0; i < nums.size(); i++) {
			if(i == nums.size()-1)
				out.print(nums.get(i)+"\n");
			else 
				out.print(nums.get(i)+" ");
		}
		out.close();
	
	}
	
	public static void find(int a, int b, int c, int aSize, int bSize, int cSize, int counter) { //not the actual ammounts but the amount it has at the moment 
		//goes through all of the possibilities
		if(counter != 0) {
			for(int i = 0; i < 6; i++) {
					if(i == 0) { //for c the current 
						if(c == 0) find(0,0,0,0,0,0,0);
						else {
							if(c >= aSize-a) find(aSize, b, c-(aSize-a), aSize, bSize, cSize, counter-1); 
							else if (c < aSize-a)find(c+a, b, 0, aSize, bSize, cSize, counter-1);
						}
					}
					else if( i == 1){
						if(c == 0) find(0,0,0,0,0,0,0);
						else {
							if(c >= bSize-b) find(a, bSize, c-(bSize-b), aSize, bSize, cSize, counter-1);
							else if (c < bSize-b)find(a, c+b, 0, aSize, bSize, cSize, counter-1);
						}
					}
					else if( i == 2){ //for b 
						if(b == 0) find(0,0,0,0,0,0,0);
						else {
							if(b >= cSize-c) find(a, b-(cSize-c), cSize, aSize, bSize, cSize, counter-1);
							else if (b < cSize-c)find(a, 0, b+c, aSize, bSize, cSize, counter-1); 
						}
					}
					else if( i == 3){ //for b 
						if(b == 0) find(0,0,0,0,0,0,0);
						else {
							if(b >= aSize-a) find(aSize, b-(aSize-a), c, aSize, bSize, cSize, counter-1);
							else if (b < aSize-a) find(a+b, 0, c, aSize, bSize, cSize, counter-1);
						}
					}
					else if( i == 4){ //for a
						if(a != 0 && a >= bSize-b) find(a-(bSize-b), bSize, c, aSize, bSize, cSize, counter-1);
						else if (  a != 0 && a < bSize-b) find(0, a+b, c, aSize, bSize, cSize, counter-1);
						else {
							if(inList(c) == false) {
								System.out.println("hit " + nums.size());
								nums.add(c); 
							}
							find(0,0,0,0,0,0,0);
						}
					}
					else if( i == 5){ //for a
						if(a != 0 && a >= cSize-c) find(a-(cSize-c), b, cSize, aSize, bSize, cSize, counter-1);
						else if (a != 0 && a < cSize-c) find(0, b, c+a, aSize, bSize, cSize, counter-1);
						else {
							if(inList(c) == false) nums.add(c); 
							find(0,0,0,0,0,0,0);
						}
					}
					
			}
		}
	}
	
	public static boolean inList(int a) {
		for(int i = 0; i < nums.size(); i++) {
			if(a == nums.get(i)) return true;
		}
		return false;
	}

}
