//package Chapter3_3;
/*
ID: alan.li2
LANG: JAVA
TASK: shopping
 */

import java.io.*;
import java.util.*;

public class shopping {
	//Data is 
	/*
	 * minCost (dp array)
	 * s and b (special offers) & (number of items to buy)
	 * codeSwitch (switch from code to index) 
	 * special (all the special offers) 
	 * itemsNeed (the items needed)
	 * itemsCost (the cost of those items) 
	 */ 
	static int[][][][][] minCost = new int[6][6][6][6][6];
	public static void main(String args[]) throws IOException {
		// data
		int s, b;
		int[] codeSwitch = new int[1000]; // to switch to the corresponding index
		Arrays.fill(codeSwitch, -1);
		specialOffer[] special;
		int[] itemsNeed; 
		int[] itemsCost; 
		// input
		BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
		s = Integer.parseInt(f.readLine());
		special = new specialOffer[s];
		StringTokenizer input;
		for (int i = 0; i < s; i++) {
			input = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(input.nextToken()), d;
			int[] b1 = new int[a];
			int[] c = new int[a];
			for (int j = 0; j < a; j++) {
				b1[j] = Integer.parseInt(input.nextToken());
				c[j] = Integer.parseInt(input.nextToken());
			}
			d = Integer.parseInt(input.nextToken());
			special[i] = new specialOffer(a, b1, c, d);
		}
		b = Integer.parseInt(f.readLine());
		int[] itemCode = new int[b]; 
		itemsNeed = new int[5]; //no matter what we need all five up and running 
		itemsCost = new int[b]; 
		for (int i = 0; i < b; i++) {
			input = new StringTokenizer(f.readLine());
			int z = Integer.parseInt(input.nextToken()); 
			codeSwitch[z] = i; 
			itemCode[i] = z; 
			itemsNeed[i] = Integer.parseInt(input.nextToken()); 
			itemsCost[i] = Integer.parseInt(input.nextToken()); 
		}
		f.close();
		
		
		// algorithm, 5 dimensional butterfly?
		for(int first = 0; first < 6; first++) { //  [0] [1] [2] [3] [4] 
			for(int second = 0; second < 6; second++) {
				for(int third = 0; third < 6; third++) {
					for(int fourth = 0; fourth < 6; fourth++) {
						for(int fifth = 0; fifth < 6; fifth++) {
							minCost[first][second][third][fourth][fifth] = 10000000; 
						}
					}
				}
			}
		}
		minCost[0][0][0][0][0] = 1; 
		for(int first = 0; first < 6; first++) { //  [0] [1] [2] [3] [4] 
			for(int second = 0; second < 6; second++) {
				for(int third = 0; third < 6; third++) {
					for(int fourth = 0; fourth < 6; fourth++) {
						for(int fifth = 0; fifth < 6; fifth++) {
							for(int i = 0; i < s; i++) {
								int[] addon = new int[5]; 
								for(int j = 0; j < special[i].code.length; j++) {
									addon[ codeSwitch[special[i].code[j]] ] = special[i].amount[j]; 
								}
								if(first+addon[0] < 6 && second+addon[1] < 6 && third+addon[2] < 6 && fourth+addon[3] < 6 && fifth+addon[4] < 6) minCost[first+addon[0]][second+addon[1]][third+addon[2]][fourth+addon[3]][fifth+addon[4]] = Math.min(minCost[first+addon[0]][second+addon[1]][third+addon[2]][fourth+addon[3]][fifth+addon[4]], minCost[first][second][third][fourth][fifth]+special[i].cost); 
							}
							for(int i = 0; i < b; i++) {
								if(i == 0 && first+1 < 6) {
									minCost[first+1][second][third][fourth][fifth] = Math.min(minCost[first+1][second][third][fourth][fifth], minCost[first][second][third][fourth][fifth]+itemsCost[i]); 
								}
								else if(i == 1 && second+1 < 6) {
									minCost[first][second+1][third][fourth][fifth] = Math.min(minCost[first][second+1][third][fourth][fifth], minCost[first][second][third][fourth][fifth]+itemsCost[i]); 
								}
								else if(i == 2 && third+1 < 6) {
									minCost[first][second][third+1][fourth][fifth] = Math.min(minCost[first][second][third+1][fourth][fifth], minCost[first][second][third][fourth][fifth]+itemsCost[i]); 
								}
								else if(i == 3 && fourth+1 < 6) {
									minCost[first][second][third][fourth+1][fifth] = Math.min(minCost[first][second][third][fourth+1][fifth], minCost[first][second][third][fourth][fifth]+itemsCost[i]); 
								}
								else if(i == 4 && fifth+1 < 6) {
									minCost[first][second][third][fourth][fifth+1] = Math.min(minCost[first][second][third][fourth][fifth+1], minCost[first][second][third][fourth][fifth]+itemsCost[i]); 
								}
							}
						}
					}
				}
			}
		}
		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out"))); 
		out.println( (minCost[itemsNeed[0]][itemsNeed[1]][itemsNeed[2]][itemsNeed[3]][itemsNeed[4]]-1) );
		out.close(); 
	}

	public static class specialOffer {
		public int items;
		public int cost;
		public int[] code;
		public int[] amount;

		public specialOffer(int a, int[] b, int[] c, int d) {
			items = a;
			cost = d;
			code = b;
			amount = c;
		}
	}
}
