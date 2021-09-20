package round1a2019;

/*
ID: urd00m
LANG: JAVA
TASK: rhyme
 */
import java.util.*;
import java.io.*;

public class rhyme2 {
	static int t;
	static int n;

	public static void main(String args[]) throws IOException {
		// input
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			n = Integer.parseInt(f.readLine());
			// using a prefix tree, never the same word makes it easier to deal with
			Trie words = new Trie(); 
			for(int i = 0; i < n; i++) 
				words.insert(reverse(f.readLine()));
			int ret = n - words.solve(); 
			System.out.println("Case #" + cn + ": " + ret);
		}
	}

	public static String reverse(String a) {
		String ret = ""; 
		for(int i = a.length()-1; i >= 0; i--) {
			ret += a.substring(i, i+1); 
		}
		return ret; 
	}
	
	public static class Trie {
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char currentChar = word.charAt(i);
				if (!node.containsKey(currentChar)) {
					node.put(currentChar, new TrieNode());
				}
				node = node.get(currentChar);
			}
			node.setEnd();
		}
		public boolean search(String word) {
			TrieNode node = searchPrefix(word);
			return node != null && node.isEnd();
		}
		public boolean startsWith(String prefix) {
			TrieNode node = searchPrefix(prefix);
			return node != null;
		}
		public TrieNode searchPrefix(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char curLetter = word.charAt(i);
				if (node.containsKey(curLetter)) {
					node = node.get(curLetter);
				} else {
					return null;
				}
			}
			return node;
		}
		
		public int solve() {
			return dfs(root); 
		}
		
		
		public int dfs(TrieNode cur) {
			if(cur.numChildren == 0) { //leaf node
				return 1; 
			}
			int ret = 0; 
			if(cur.isEnd == true) ret += 1; 
			for(TrieNode item : cur.children) ret += dfs(item); 
			if(cur != root && ret >= 2) ret -= 2;
			return ret; 
			
		}

		class TrieNode {
			private TrieNode[] links;
			private final int R = 26;
			public boolean isEnd;
			public int numChildren = 0; 
			public ArrayList<TrieNode> children = new ArrayList<TrieNode>(); 
			public TrieNode() {
				links = new TrieNode[R];
			}
			public boolean containsKey(char ch) {
				return links[ch - 'A'] != null;
			}
			public TrieNode get(char ch) {
				return links[ch - 'A'];
			}
			public void put(char ch, TrieNode node) {
				if(links[ch - 'A'] == null) {
					numChildren++;
					children.add(node); 
				}
				
				links[ch - 'A'] = node;
			}
			public void setEnd() {
				isEnd = true;
			}
			public boolean isEnd() {
				return isEnd;
			}
		}
	}
}
