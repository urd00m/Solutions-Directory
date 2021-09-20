
//package a100_200;
/*
ID: urd00m
LANG: JAVA
TASK: uva00140
 */
import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, Integer> convert = new HashMap<String, Integer>();
	static HashMap<Integer, String> convertBack = new HashMap<Integer, String>();
	public static void main(String args[]) throws IOException, InterruptedException {
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		//Thread.sleep(5000);
		String input = f.readLine();
		while (input.equals("#") == false) {
			convert.clear(); convertBack.clear();
			int curNode = -1;
			int nodeNum = 0;
			ArrayList<Integer>[] graph2 = new ArrayList[10];
			for (int i = 0; i < 10; i++)
				graph2[i] = new ArrayList<Integer>();
			boolean isLeft = true; 
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == ':') {
					isLeft = false;
				} else if (input.charAt(i) == ';') {
					isLeft = true;
				} else {
					if (isLeft == true) {
						if (convert.containsKey(input.substring(i, i + 1)) == false) {
							convert.put(input.substring(i, i + 1), nodeNum);
							convertBack.put(nodeNum++, input.substring(i, i + 1));
						}
						curNode = convert.get(input.substring(i, i + 1));

					} else {
						if (convert.containsKey(input.substring(i, i + 1)) == false) {
							convert.put(input.substring(i, i + 1), nodeNum);
							convertBack.put(nodeNum++, input.substring(i, i + 1));
						}
						graph2[curNode].add(convert.get(input.substring(i, i + 1)));
						graph2[convert.get(input.substring(i, i + 1))].add(curNode);
					}
				}
			}
			// for permutations
			int[] save = new int[nodeNum];
			for (int i = 0; i < nodeNum; i++)
				save[i] = i;

			// begin next permuatation
			int min = Integer.MAX_VALUE; String output = "-1"; 
			/*   to view the graph 
			for(ArrayList<Integer> ary : graph2) {
				for(int item : ary) System.out.print(convertBack.get(item) + " ");
				System.out.println();
			}
			*/
			do {
				int tempMax = 0; 
				for(int i = 0; i < nodeNum; i++) tempMax = Math.max(tempMax, maxBandwidth(save, i, graph2)); 
				if(tempMax < min) {
					min = tempMax; 
					output = toString(save, tempMax); 
				}
				else if (tempMax == min) {
					String a = toString(save, tempMax); 
					if(a.compareTo(output) < 0) output = a; 
				}
			} while (findNextPermutation(save));
			System.out.println(output);
			input = f.readLine(); 
		}
	}
	public static String toString(int[] a, int bandwidth) {
		String output = "";
		for(int item : a) output += convertBack.get(item) + " ";
		output += "-> " + bandwidth; 
		return output; 
	}
	public static int maxBandwidth(int[] a, int cur, ArrayList[] graph) {
		int maxBand = 0; 
		for(int i = 0; i < a.length; i++) {
			if(graph[a[cur]].contains(a[i])) maxBand = Math.max(maxBand, Math.abs(cur-i));  
		}
		return maxBand; 
	}
	public static int[] swap(int data[], int left, int right) {
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		return data;
	}

	public static int[] reverse(int data[], int left, int right) {
		while (left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}
		return data;
	}

	public static boolean findNextPermutation(int data[]) {
		if (data.length <= 1)
			return false;
		int last = data.length - 2;
		while (last >= 0) {
			if (data[last] < data[last + 1]) {
				break;
			}
			last--;
		}
		if (last < 0)
			return false;
		int nextGreater = data.length - 1;
		for (int i = data.length - 1; i > last; i--) {
			if (data[i] > data[last]) {
				nextGreater = i;
				break;
			}
		}
		data = swap(data, nextGreater, last);
		data = reverse(data, last + 1, data.length - 1);
		return true;
	}
}
