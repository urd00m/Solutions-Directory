//package febGold2018;
/*
ID: alwang
LANG: JAVA
TASK: snowboots
 */
import java.io.*;
import java.util.*;

public class snowboots {
	static int n, b; 
	static pair[] tiles; 
	static pair[] boots; 
	static int[] output;
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("snowboots.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		n = Integer.parseInt(input.nextToken()); b = Integer.parseInt(input.nextToken()); 
		init(); 
		input = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < n; i++) tiles[i] = new pair(Integer.parseInt(input.nextToken()), i); 
		for(int i = 0; i < b; i++) {
			input = new StringTokenizer(f.readLine());
			boots[i] = new pair(Integer.parseInt(input.nextToken()), Integer.parseInt(input.nextToken()), i); 
		}
		f.close();
		
		//sorting
		Arrays.sort(tiles, new Comparator<pair>() { //decreasing order sort
			@Override
			public int compare(pair a, pair b) {
				return b.a-a.a; 
			}
		});
		Arrays.sort(boots, new Comparator<pair>() { //decreasing order 
			@Override
			public int compare(pair a, pair b) {
				return b.a-a.a; 
			}
			
		});
		
		//algorithm: sort then iterate and remove tiles that have to much snow on them and make sure the maximum distance between the tiles is less then the snow boots distance 
		//doubly linked list type structure
		int[] next = new int[n+1]; 
		int[] prev = new int[n+1]; 
		for(int i = 0; i < n+1; i++) {
			next[i] = i+1; prev[i] = i-1; 
		}
		int maxDist = 1;
		int j = 0; 
		for(int i = 0; i < b; i++) { //iterating through the boots 
			pair curBoot = boots[i]; 
			while(j < n && curBoot.a < tiles[j].a) {
				pair curTile = tiles[j]; 
				next[prev[curTile.i]] = next[curTile.i]; //tile 0 and n-1 will never be here since they have depth 0
				prev[next[curTile.i]] = prev[curTile.i]; 
				maxDist = Math.max(maxDist, next[curTile.i]-prev[curTile.i]); 
				j++; 
			}
			if(maxDist <= curBoot.b) output[curBoot.i] = 1;  
		}
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out"))); 
		for(int item : output) out.println(item);
		out.close();
	}
	
	public static class pair {
		int a; //snow depth
		int b; //distance   (For tiles you don't use this one); 
		int i; //original index 
		public pair(int x, int y, int z) { //for boots
			a = x; 
			b = y; 
			i = z; 
		}
		public pair(int x, int y) { //for tiles 
			a = x; 
			i = y; 
		}
	}
	
	public static void init() {
		tiles = new pair[n];
		boots = new pair[b];
		output = new int[b]; 
	}
}
