package jan2018gold;
//ufds example
import java.io.*;
import java.util.*;
public class mootubecopy {
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[n-1]; //edge list 
		for(int i = 0; i < edges.length; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(x, y, w);
		}
		//
		
		Arrays.sort(edges); //sorts the edges given by weight 
		par = new int[n]; //for UFDS this is parent
		sz = new int[n]; //this is rank 
		for(int i = 0; i < n; i++) {
			par[i] = i; //the parent is itself 
			sz[i] = 1; //size of it is 1
		}
		Query[] queries = new Query[q]; //the queries 
		for(int query = 0; query < q; query++) {
			st = new StringTokenizer(br.readLine());
			int threshold = Integer.parseInt(st.nextToken()); //the k value
			int start = Integer.parseInt(st.nextToken())-1; //where you start (node number) 
			queries[query] = new Query(start, threshold, query); //and addsd to list, it also contains its original position in queries
		}
		Arrays.sort(queries); //sorts it based on threshold, want the most expensive one first 
		int[] ret = new int[q]; //what you return 
		int idx = 0; 
		for(Query query: queries) { //for the queries 
			while(idx < edges.length && edges[idx].w >= query.w) { //the edges we look at must be greater than or equal to the threshold 
				merge(edges[idx].a, edges[idx].b); //if it satisfys those constraints you then merge the destinations of the edge 
				idx++;
			}
			ret[query.i] = sizeOf(query.v)-1; //once they are all merged all the edges that are connected and satisfy the threshold are in a specific set which is then found with .v of the query (-1 since it is excluding itself) 
		}
		
		//output 
		for(int out: ret) {
			pw.println(out);
		}
		pw.close();
	}
	
	//UFDS
	static int[] par;
	static int[] sz;
	public static int sizeOf(int x) { //the size of x is its root nodes size 
		return sz[find(x)];
	}
	public static int find(int x) {
		return par[x] == x ? x : (par[x] = find(par[x])); //the root of the tree's parent is itself 
	}
	public static void merge(int x, int y) {
		int fx = find(x); //finds parent of destination x 
		int fy = find(y); //finds parent of destination y 
		sz[fy] += sz[fx]; //size of the fy root increases by the size of the tree it inherits 
		par[fx] = fy; //the parent of fx no longer is itself but fy because the trees have merged 
	}
	
	static class Edge implements Comparable<Edge> {
		public int a, b, w; //a to b with wieght w 
		public Edge(int x, int y, int z) {
			a=x;
			b=y;
			w=z;
		}
		public int compareTo(Edge e) {
			return e.w - w;
		}
	}
		
	static class Query implements Comparable<Query> {
		public int v, w, i;
		public Query(int x, int y, int z) {
			v=x;
			w=y;
			i=z;
		}
		public int compareTo(Query q) {
			return q.w - w;
		}
	}
	
}