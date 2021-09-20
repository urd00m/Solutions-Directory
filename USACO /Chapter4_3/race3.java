
//package Chapter4_3;
/*
ID: alan.li2
LANG: JAVA
TASK: race3
 */

import java.util.*;
import java.io.*;

public class race3 {
	static int[][] course = new int[50][50];
	static int n = 0;
	static boolean[] unavoidable;
	static ArrayList<Integer> split = new ArrayList<Integer>();

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new FileReader("race3.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		while (true) {
			int temp = Integer.parseInt(input.nextToken());
			if (temp == -1)
				break;
			else if (temp == -2) {
				input = new StringTokenizer(f.readLine());
				n++;
			} else {
				course[n][temp] = 1;
			}
		}
		unavoidable = new boolean[n]; // exclude 0 and n-1 from final print
		Arrays.fill(unavoidable, true);
		f.close();

		// algorithm
		// graph theory
		/*
		 * you know that the unavoidable points are the points that are always in the
		 * the paths, so find the shortest path and record then remove that path and do
		 * it till their are no more paths the splitting points are the unavoidable
		 * points that don't cross over
		 */
		int[][] temp = copy(course); 
		if(n != 2) findUn(temp, 0, n - 1);
		// finding the splitters
		ArrayList<Integer> unAv = new ArrayList<Integer>();
		for (int i = 1; i < n - 1; i++) { // finding the unavoidables
			if (unavoidable[i] == true) {
				unAv.add(i);
				boolean[] store = connected(0, i);
				boolean[] store2 = connected(i, n); 
				boolean isSplit = true;
				for (int j = 0; j < n; j++) { // finding vertexes on the other side
					if(j != i && store[j] == store2[j]) { //there is overlap
						isSplit = false; 
						break; 
					}
				}
				if (isSplit == true)
					split.add(i);
			}
		}

		// output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race3.out")));
		String line1 = "" + unAv.size() + "", line2 = "" + split.size() + "";
		for (int i = 0; i < unAv.size(); i++) {
			line1 += " " + unAv.get(i);
		}
		for (int i = 0; i < split.size(); i++) {
			line2 += " " + split.get(i);
		}
		out.println(line1);
		out.println(line2);
		out.close();
	}

	public static void findUn(int[][] tempCourse, int source, int sink) { // always 0 and n-1
		int[] prevnode = new int[n];
		boolean[] visited = new boolean[n];
		boolean[] reachable = new boolean[n];
		while (true) {
			int cur;
			for (int i = 0; i < n; i++) {
				prevnode[i] = -1;
				visited[i] = false;
				reachable[i] = false;
			}
			reachable[0] = true;
			while (true) {
				cur = -1;
				for (int i = 0; i < n; i++) { // next node
					if (reachable[i] == true && visited[i] == false) {
						cur = i;
					}
				}
				if (cur == sink || cur == -1)
					break;
				visited[cur] = true;
				for (int i = 0; i < n; i++) {
					if (tempCourse[cur][i] == 1 && visited[i] == false) {
						reachable[i] = true;
						prevnode[i] = cur;
					}
				}
			}
			if (cur == -1)
				break;
			int curNode = prevnode[sink];
			boolean[] included = new boolean[n];
			included[sink] = true; 
			while (curNode != source) {
				int nextNode = prevnode[curNode];
				if(nextNode != source) tempCourse[nextNode][curNode] = 0; //eliminating the connections 
				included[curNode] = true;
				curNode = nextNode; 
			}
			for (int i = 0; i < n; i++) {
				if (unavoidable[i] == true && included[i] == false)
					unavoidable[i] = false;
			}
		}
	}

	public static boolean[] connected(int startNode, int finishNode) {
		boolean[] output = new boolean[n];
		Queue<Integer> nextNode = new LinkedList<Integer>();
		nextNode.add(startNode);
		output[startNode] = true;
		while (true) {
			int cur = nextNode.remove();
			if (cur != finishNode) {
				for (int i = 0; i < n; i++) {
					if (output[i] == false && course[cur][i] == 1) {
						nextNode.add(i);
						output[i] = true;
					}
				}
			}
			if (nextNode.isEmpty() == true)
				break;
		}
		return output;
	}
	
	public static int[][] copy(int[][] a) {
		int[][] theCopy = new int[50][50]; 
		for(int i = 0; i < 50; i++) {
			for(int j = 0 ; j < 50; j++) {
				theCopy[i][j] = a[i][j]; 
			}
		}
		return theCopy; 
	}

}
