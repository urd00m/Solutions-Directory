import java.io.*;
import java.util.*;

public class problemD {
    static ArrayList<Integer>[] adjList;
    static long[] fun;
    public static void main(String args[]) throws IOException {
        //input 
        BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; StringTokenizer input2;
        int t = Integer.parseInt(f.readLine()); 

        for(int count = 1; count <= t; count++) {
            //input 
            int n = Integer.parseInt(f.readLine());
            input = new StringTokenizer(f.readLine()); // values
            input2 = new StringTokenizer(f.readLine()); //pointer
            fun = new long[n+1]; //fun value for each node
            Arrays.fill(fun, 0);
            adjList = new ArrayList[n+1]; // Adjacency list
            for(int i = 0; i < n+1; i++)
                adjList[i] = new ArrayList<Integer>();
            for(int i = 1; i < n+1; i++) {
                adjList[Integer.parseInt(input2.nextToken())].add(i); // sets up pointer
                fun[i] = Long.parseLong(input.nextToken()); // fun value
            }

            /*
            for(ArrayList<Long> ary : adjList) {
                for(int item : ary) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }
            */

            // Recurison and flip the direction 
            long ret = recur(0);

            System.out.println("Case #" + count + ": " + ret);
        }
    }

    public static long[] recur(int curNode) {
        long[] retary = {0, 0};
        if(adjList[curNode].size() == 0) { // at the end
            retary[0] = fun[curNode];
            return retary;
        }

        // find the max of previous iterations 
        long min = Long.MAX_VALUE;
        long ret = 0;
        for(int i = 0; i < adjList[curNode].size(); i++) {
            long curFun = recur(adjList[curNode].get(i));
            if(curFun < min) {
                min = curFun;
            }
            ret += curFun;
        }

        if(fun[curNode] > min)
            return ret - min + fun[curNode];
        else 
            return ret; 
    }
}