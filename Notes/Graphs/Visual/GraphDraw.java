package Visual;

/* Simple graph drawing class
Bert Huang
COMS 3137 Data Structures and Algorithms, Spring 2009

This class is really elementary, but lets you draw 
reasonably nice graphs/trees/diagrams. Feel free to 
improve upon it!
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphDraw extends JFrame {
	int width;
	int height;

	ArrayList<Node> nodes;
	ArrayList<edge> edges;
	position[] positionList; 

	public GraphDraw() { // Constructor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nodes = new ArrayList<Node>();
		edges = new ArrayList<edge>();
		width = 30;
		height = 30;
	}

	public GraphDraw(String name) { // Construct with label
		this.setTitle(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nodes = new ArrayList<Node>();
		edges = new ArrayList<edge>();
		width = 30;
		height = 30;
	}

	class Node {
		int x, y;
		String name;

		public Node(String myName, int myX, int myY) {
			x = myX;
			y = myY;
			name = myName;
		}
	}

	class edge {
		int i, j;

		public edge(int ii, int jj) {
			i = ii;
			j = jj;
		}
	}
	
	class position {
		int x, y; 
		
		public position(int a, int b) {
			x = a; 
			y = b; 
		}
	}

	public void addNode(String name, int x, int y) {
		// add a node at pixel (x,y)
		nodes.add(new Node(name, x, y));
		positionList[Integer.parseInt(name)] = (new position(x, y)); 
		this.repaint();
	}

	public void addEdge(int i, int j) {
		// add an edge between nodes i and j
		edges.add(new edge(i, j));
		this.repaint();
	}

	public void paint(Graphics g) { // draw the nodes and edges
		FontMetrics f = g.getFontMetrics();
		int nodeHeight = Math.max(height, f.getHeight());

		g.setColor(Color.black);
		for (edge e : edges) {
			g.drawLine(positionList[e.i].x, positionList[e.i].y, positionList[e.j].x, positionList[e.j].y);
		}

		for (Node n : nodes) {
			int nodeWidth = Math.max(width, f.stringWidth(n.name) + width / 2);
			g.setColor(Color.white);
			g.fillOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);
			g.setColor(Color.black);
			g.drawOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);

			g.drawString(n.name, n.x - f.stringWidth(n.name) / 2, n.y + f.getHeight() / 2);
		}
	}
	public void init(int a) {
		positionList = new position[a]; 
	}
}

class testGraphDraw {
	// Here is some example syntax for the GraphDraw class
	ArrayList<Integer>[] graph;
	ArrayList<Integer>[] depths;
	int n;
	GraphDraw frame = new GraphDraw("Test Window");

	public void set(int root, GraphDraw frame) {
		dfs(root, -1, 0);
		int y = 50; // increments by 40
		for (int i = 0; i < n; i++) {
			if (depths[i].size() > 0) {
				int numNodes = depths[i].size();
				double spread = 400.0 / numNodes;
				int x = 50;
				for (int node : depths[i]) {
					// System.out.println(i + " " + node + " " + x + " " + y);
					frame.addNode("" + node, x, y); 
					x += spread;
				}
				y += 40;
			} else {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int item : graph[i]) {
				//System.out.println(i + " " + item);
				frame.addEdge(i, item);
			}
		}
	}

	public void dfs(int curNode, int parentNode, int depth) {
		depths[depth].add(curNode);
		for (int item : graph[curNode])
			if (parentNode != item)
				dfs(item, curNode, depth + 1);
	}

	public void init() {
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<Integer>();
		depths = new ArrayList[n];
		for (int i = 0; i < n; i++)
			depths[i] = new ArrayList<Integer>();
		frame.init(n); 
	}
}
