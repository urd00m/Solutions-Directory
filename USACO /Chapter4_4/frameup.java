//package Chapter4_4;
/*
ID: alan.li2
LANG: JAVA
TASK: frameup
 */
import java.io.*;
import java.util.*;

public class frameup { 
	static ArrayList<Character>[] below = new ArrayList[26]; //'A' == 65 //list of all the elements contained
	static boolean[][] belowContains = new boolean[26][26]; //for O(1) lookup of what is in the list 
	static ArrayList<String> solutions = new ArrayList<String>(); 
	static int h,w; 
	static char[][] board; 
	static boolean[] existing = new boolean[26]; 
	public static void main(String args[]) throws IOException {
		//input
		long time = System.currentTimeMillis(); 
		BufferedReader f = new BufferedReader(new FileReader("frameup.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		h = Integer.parseInt(input.nextToken()); 
		w = Integer.parseInt(input.nextToken()); 
		board = new char[h][w];
		for(int i = 0; i < h; i++) {
			String input2 = f.readLine(); 
			for(int j = 0; j < w; j++) {
				board[i][j] = input2.charAt(j); 
			}
		}
		f.close();
		
		//algorithm
		//create a arrayList[] of which letters are below a specific letter 
		fillBelow(); //getting what is below what 
		for(boolean item : existing) System.out.println(item);
		findAll(""); 
		
		//sorting
		Collections.sort(solutions);
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frameup.out")));
		for(String item : solutions) 
			out.println(item); 
		out.close();
		System.out.println(System.currentTimeMillis()-time); 
	}
	
	public static void findAll(String output) { //finding frame orders recursive 
		boolean done = true; 
		for(int i = 0; i < 26; i++) {
			if(existing[i] == true && output.contains(""+(char)(i+65)) == false) {
				done = false; 
				boolean isGood = true; 
				for(int j = 0; j < below[i].size(); j++) {
					if(output.contains(below[i].get(j)+"") == false) {
						isGood = false; 
						break; 
					}
				}
				if(isGood == true) {
					findAll(output + "" + ((char)(i+65))); 
				}
			}
		}
		if(done == true) {
			solutions.add(output); 
		}
	}
	public static void fillBelow() { //fills the below arrayList and belowContains list 
		//determining the max positions 
		maxMin[] boundaries = new maxMin[26]; 
		for(int i = 0; i < 26; i++) { //init 
			boundaries[i] = new maxMin(-1, -1, Integer.MAX_VALUE, Integer.MAX_VALUE); 
		}
		for(int i = 0; i < 26; i++) { //init
			below[i] = new ArrayList<Character>(); 
		}
		
		for(int i = 0; i < h; i++) { //y the rows       finding the boundaries 
			for(int j = 0; j < w; j++) { //x the columns 
				if(board[i][j] != '.') {
					boundaries[board[i][j]-65].xMax = Math.max(boundaries[board[i][j]-65].xMax, j); 
					boundaries[board[i][j]-65].yMax = Math.max(boundaries[board[i][j]-65].yMax, i); 
					boundaries[board[i][j]-65].xMin = Math.min(boundaries[board[i][j]-65].xMin, j); 
					boundaries[board[i][j]-65].yMin = Math.min(boundaries[board[i][j]-65].yMin, i); 
				}
			}
		}
		
		for(int i = 0; i < 26; i++) { //finding the belows 
			if(boundaries[i].yMax != -1) { //if it exists 
				existing[i] = true; 
				for(int height = boundaries[i].yMin; height <= boundaries[i].yMax; height++) {
					if(board[height][boundaries[i].xMin]-65 != i && belowContains[board[height][boundaries[i].xMin]-65][i] == false) {
						below[board[height][boundaries[i].xMin]-65].add((char)(i+65)); 
						belowContains[board[height][boundaries[i].xMin]-65][i] = true; 
					}
					if(board[height][boundaries[i].xMax]-65 != i && belowContains[board[height][boundaries[i].xMax]-65][i] == false) {
						below[board[height][boundaries[i].xMax]-65].add((char)(i+65)); 
						belowContains[board[height][boundaries[i].xMax]-65][i] = true; 
					}
				}
				
				for(int width = boundaries[i].xMin; width <= boundaries[i].xMax; width++) {
					if(board[boundaries[i].yMin][width]-65 != i && belowContains[board[boundaries[i].yMin][width]-65][i] == false) {
						below[board[boundaries[i].yMin][width]-65].add((char)(i+65)); 
						belowContains[board[boundaries[i].yMin][width]-65][i] = true; 
					}
					if(board[boundaries[i].yMax][width]-65 != i && belowContains[board[boundaries[i].yMax][width]-65][i] == false) {
						below[board[boundaries[i].yMax][width]-65].add((char)(i+65)); 
						belowContains[board[boundaries[i].yMax][width]-65][i] = true; 
					}
				}
			}
		}
	}
	public static class maxMin {
		public int xMax, yMax; 
		public int xMin, yMin;
		public maxMin(int a, int b, int c, int d) {
			xMax = a; 
			yMax = b;
			xMin = c;
			yMin = d; 
		}
	}
}
