//package Chapter3_1;
/*
ID: alan.li2
LANG: JAVA
TASK: agrinet
 */

import java.io.*;
import java.util.*;

public class agrinet {
    	static int n;
        static int[][] map;


    //prims algorithm
        static boolean[] MSTree;
        static int[] minTree;
        public static void main(String args[]) throws IOException {
                //input
                BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
                n = Integer.parseInt(f.readLine());
                map = new int[n][n];
                StringTokenizer input;
                for(int i = 0; i < n; i++) {
                        input = new StringTokenizer(f.readLine());
                        for(int j = 0; j < n; j++) {
                        		if(input.hasMoreTokens() == false) input = new StringTokenizer(f.readLine());
                                map[i][j] = Integer.parseInt(input.nextToken());
                        }
                }
                f.close();

                //prims algorithm to create MST
                MSTree = new boolean[n];
                minTree = new int[n];
                //init
                for(int i = 0; i < n; i++) {
                        MSTree[i] = false;
                        minTree[i] = Integer.MAX_VALUE;
                }

                //prims algorithm
                minTree[0] = 0;
                for(int i = 0; i < n-1; i++) {
                        int next = minNode();
                        MSTree[next] = true;
            //set values around the node
                        for(int j = 0; j < n; j++) {
                                if(map[next][j]!=0 && map[next][j] < minTree[j] && MSTree[j] == false) {
                                        minTree[j] = map[next][j];
                                }
                        }
                }


                //output
                //calculate distance
                int sum = 0;
                for(int item : minTree) {
                    sum += item;
                 }
                	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
                	out.println(sum);
                	out.close();
        }	

    //takes in index of current node
    //outputs the minimum node index
    public static int minNode() { //returns min node index
            int minNodeVal = Integer.MAX_VALUE;
            int minNodeIdx = -1;
            for(int i = 0; i < n; i++) {
                    if(MSTree[i] == false && minTree[i] < minNodeVal) {
                            minNodeVal = minTree[i];
                            minNodeIdx = i;
                    }
            }
            return minNodeIdx;

    }
}
