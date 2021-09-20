//package Chapter3_4;
/*
ID: alan.li2
LANG: JAVA
TASK: heritage 
 */

import java.util.*;
import java.io.*;

public class heritage {
	static char[] tree = new char[1000000]; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("heritage.in")); 
		String inOrder = f.readLine(); //inorder is equal to left substring, root, right substring
		String preOrder = f.readLine(); //preorder is equal to the root, left substring, right substring 
		f.close();
		
		//assemble the tree using recursion 
		create(inOrder, preOrder, 0);

		//assemble post order string by doing dfs on the tree, dfs by default prints the tree from left to right 
		String postOrder = dfs(0); 
		
		//output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("heritage.out"))); 
		out.println(postOrder);
		out.close();
	}
	
	public static void create(String inOrder, String preOrder, int idx) { //left child at 2i + 1, right child at 2i+2
		if(inOrder.length() == 0) return; 
		else if(inOrder.length() == 1) {
			tree[idx] = inOrder.charAt(0); 
		}
		else {
			char root = preOrder.charAt(0); 
			String leftInOrder, rightInOrder, leftPreOrder, rightPreOrder; 
			leftInOrder = inOrder.substring(0, inOrder.indexOf(root));
			rightInOrder = inOrder.substring(inOrder.indexOf(root)+1); 
			leftPreOrder = preOrder.substring(1, 1+leftInOrder.length()); 
			rightPreOrder = preOrder.substring(1+leftInOrder.length()); 
			create(leftInOrder, leftPreOrder, 2*idx+1); 
			create(rightInOrder, rightPreOrder, 2*idx+2); 
			tree[idx] = root; 
		}
	}
	public static String dfs(int idx) {
		if((int)tree[idx] == 0) return "";
		else {
			return dfs(2*idx+1) + dfs(2*idx+2) + tree[idx]; 
		}
	}
}
