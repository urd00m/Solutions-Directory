//package goldDec2019;
import java.util.*;
import java.io.*;

public class milkvisitscopy {
	static int MX = 100005; 
	static int N, M;
	static int[] T = new int[MX], C = new int[MX]; 
	static boolean[] ok = new boolean[MX]; 
	static ArrayList<Integer>[] adj = new ArrayList[MX]; 
	static int[][] dat = new int[MX][2]; 
	static ArrayList<Integer>[] todo = new ArrayList[MX]; 
	static pair[] range = new pair[MX]; 
	static int co = 0; 
	static ArrayList<pair>[] stor = new ArrayList[MX]; //the current dfs path sorted based on cost of the node along with its depth which corresponds to the ord 
	static ArrayList<Integer> ord = new ArrayList<Integer>(); //the current dfs path 
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milkvisits.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		init(); 
		N = Integer.parseInt(input.nextToken()); M = Integer.parseInt(input.nextToken());
		input = new StringTokenizer(f.readLine()); 
		for(int i = 1; i < N+1; i++) {
			T[i] = Integer.parseInt(input.nextToken()); //the farm types 
		}
		for(int i = 0; i < N-1; i++) {
			input = new StringTokenizer(f.readLine()); 
			int A, B; 
			A = Integer.parseInt(input.nextToken()); B = Integer.parseInt(input.nextToken()); 
			adj[A].add(B); adj[B].add(A); //adjacency list 
		}
		//ancestor-desecendent query 
		dfs(1, 0); 
		
		//lca query 
		for(int i = 0; i < M; i++) {
			input = new StringTokenizer(f.readLine()); 
			dat[i][0] = Integer.parseInt(input.nextToken()); dat[i][1] = Integer.parseInt(input.nextToken()); C[i] = Integer.parseInt(input.nextToken()); 
			for(int j = 0; j < 2; j++) {
				todo[dat[i][j]].add(i); //assigns query number 
			}
		}
		
		dfs2(1, 0); 
		f.close();
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out"))); 
		for(int i = 0; i < M; i++) {
			if(ok[i]) out.print("1");
			else out.print("0");
		}
		out.println();
		out.close();
	}
	public static boolean anc(int a, int b) {
		return (range[a].first <= range[b].first) && (range[b].second <= range[a].second); 
	}
	public static void dfs(int x, int y) {
		range[x].first = co++; 
		for(int t : adj[x]) if(t != y) dfs(t,x); 
		range[x].second = co-1; 
	}
	
	/* the idea behind this is to first do a dfs search 
		while recording the path of the dfs and sorting that stack based on cow type of that specific farm and the relative position in the stack containing the dfs path 
		then finding all the queries that contain the current node 
		the next step is to check the closest node of the type you are looking for to the current node  
		then 2 things hpappen
		1. the current node is the type you want 
		2. it isn't 
		
		if it isn't you look at the next depth node to the node that you looked at before 
		and that new node cannot be the ancestor of the end destination of the query 
	
	*/
	public static void dfs2(int x, int y) {
		stor[T[x]].add(new pair(x, ord.size())); //adds new pair to store[type of cow on field x]] 
		ord.add(x); //adds nodes it sees to the ord arrayList
		for(int t : todo[x]) if(stor[C[t]].size() > 0) { //looks at all the queries for farm x and if stor[cow type] size is greater than zero
			pair y2 = stor[C[t]].get(stor[C[t]].size()-1); //checks last item of stor[C[t]] the most recent node of that cost in the current dfs path 
			if(y2.first == x) ok[t] = true; //if the item is x then true   if the current node is the the right cost then ok = true 
			else { 
				int Y = ord.get(y2.second+1); //gets the node below the current node y2 in the current dfs path 
				assert(dat[t][0] == x || dat[t][1] == x); //unnecessary but just to make sure the code is function properly
				if(!anc(Y, dat[t][0]+dat[t][1]-x)) ok[t] = true; //Y cannot be an ancestor of the other farm in the query 
			}
		}
		for(int t : adj[x]) if(t != y) dfs2(t, x); //all the ones that are connected to x dfs2 to there
		
		stor[T[x]].remove(stor[T[x]].size()-1);  //removes itself if it is a leaf node 
		ord.remove(ord.size()-1); //^^
	}
	
	public static void init() {
		for(int i = 0; i < MX; i++) {
			adj[i] = new ArrayList<Integer>();
			todo[i] = new ArrayList<Integer>(); 
			stor[i] = new ArrayList<pair>(); 
			range[i] = new pair(0,0); 
		}
	}
	public static class pair {
		public int first; 
		public int second; 
		public pair(int a, int b) {
			first = a;
			second = b; 
		}
	}
}
