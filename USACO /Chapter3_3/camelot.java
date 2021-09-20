//package Chapter3_3;
/*
ID: alan.li2
LANG: JAVA
TASK: camelot
 */
import java.io.*;
import java.util.*;
public class camelot {
	static int r, c;
	static node king; 
	static ArrayList<node> knights = new ArrayList<node>(); 
	static int[][][][] board; 
	static int[] set1 = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] set2 = {1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("camelot.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine());
		r = Integer.parseInt(input.nextToken());
		c = Integer.parseInt(input.nextToken());
		input = new StringTokenizer(f.readLine());  
		int store1 = input.nextToken().charAt(0)-'A';
		int store2 = Integer.parseInt(input.nextToken())-1; 
		king = new node(store2, store1); //row then column 
		while(f.ready() == true) {
			input = new StringTokenizer(f.readLine());
			while(input.hasMoreElements() == true) {
				store1 = input.nextToken().charAt(0)-'A';
				store2 = Integer.parseInt(input.nextToken())-1; 
				knights.add(new node(store2, store1)); 
			}
		}
		//init
		board = new int[r][c][r][c]; 
		for(int a = 0; a < r; a++)
			for(int b = 0; b < c; b++) 
				for(int c1 = 0; c1 < r; c1++)
					for(int d = 0; d < c; d++)
						board[a][b][c1][d] = -1; 
		//graph 
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				dist(i, j); //shortest distance from each point to every other point 
			}
		}
		f.close();
		
		//graph theory: the locations the king might move to to get picked up as intermediate points 
		int totalMin = Integer.MAX_VALUE;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				boolean exit = false; 
				int store = 0; 
				for(node item : knights) {
					if(board[i][j][item.x][item.y] == -1) {
						exit = true; 
						break; 
					}
					store += board[i][j][item.x][item.y]; 
				}
				if(exit == true) continue; 
				int minAdd = Math.max(Math.abs(i-king.x), Math.abs(j-king.y)); 
				for(int a = Math.max(0, king.x-2); a <= Math.min(r-1, king.x+2); a++) {
					for(int b = Math.max(0, king.y-2); b <= Math.min(c-1, king.y+2); b++) {
						for(node item : knights) {
							if(board[i][j][a][b] != -1 && board[a][b][item.x][item.y] != -1) {
								minAdd = Math.min(minAdd, board[i][j][a][b] + board[a][b][item.x][item.y] - board[i][j][item.x][item.y] + Math.max(Math.abs(a-king.x), Math.abs(b-king.y))); 
							}
						}
					}
				}
				if(minAdd+store < totalMin) totalMin = minAdd+store;
			}
		}
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		out.println(totalMin);
		out.close();
	}
	public static void dist(int x, int y) {
		Queue<node> q = new LinkedList<node>(); 
		q.add(new node(x, y)); 
		board[x][y][x][y] = 0; 
		while(q.isEmpty() == false) {
			node store = q.remove();
			for(int i = 0; i < 8; i++) { //goes through the different connections 
				if(0 <= set1[i]+store.x && set1[i]+store.x < r && 0 <= set2[i]+store.y && set2[i]+store.y < c) {
					if(board[x][y][set1[i]+store.x][set2[i]+store.y] == -1 || board[x][y][set1[i]+store.x][set2[i]+store.y] > board[x][y][store.x][store.y]+1) {
						board[x][y][set1[i]+store.x][set2[i]+store.y] = board[x][y][store.x][store.y]+1;
						board[set1[i]+store.x][set2[i]+store.y][x][y] = board[x][y][store.x][store.y]+1;
						q.add(new node(set1[i]+store.x,set2[i]+store.y)); 
					}
				}
			}
		}
	}
	
	public static class node implements Comparator<node> {
		public int x;
		public int y;

		public node() {
		}

		public node(int node, int cost) {
			this.x = node;
			this.y = cost;
		}

		@Override
		public int compare(node node1, node node2) {
			if (node1.x < node2.x)
				return -1;
			if (node1.x > node2.x)
				return 1;
			return 0;
		}
	}
	
	
}