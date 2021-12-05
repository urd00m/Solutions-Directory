class Solution {
    
    //information we need to find 
    static int ret = 0; 
    
    //starting variables 
    static int[] valuesGlobal;
    static int n, m; 
    
    //adjlist 
    static ArrayList<pair>[] adjList; 
    
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        valuesGlobal = values; 
        n = values.length; m = edges.length; 
        ret = 0;
        
        //convert edges to adjlist
        adjList = new ArrayList[n]; 
        for(int i = 0; i < n; i++) adjList[i] = new ArrayList<pair>(); 
        for(int i = 0; i < m; i++) {
            int[] curEdge = edges[i]; 
            adjList[curEdge[0]].add(new pair(curEdge[1], curEdge[2]));
            adjList[curEdge[1]].add(new pair(curEdge[0], curEdge[2]));
        }
        
        //dfs 
        int[] visited = new int[n]; 
        for(int i = 0; i < n; i++) visited[i] = 0; 
        recur(0, maxTime, 0, visited); 
        
        return ret; 
    }
    
    public void recur(int curNode, int maxTime, int quality, int[] visited) {
        if(maxTime < 0 || (maxTime == 0 && curNode != 0)) return; 
        
        if(visited[curNode] == 0) quality += valuesGlobal[curNode]; 
        //System.out.println(curNode + " " + maxTime + " " + quality); 
        
        if(curNode == 0) ret = Math.max(ret, quality); 
        
        visited[curNode]++; 
        for(pair next : adjList[curNode]) {
            recur(next.dest, maxTime-next.weight, quality, visited); 
        }
        visited[curNode]--; 
        
    }
    
    public static class pair {
        int dest, weight; 
        public pair(int a, int b) {
            dest = a; 
            weight = b; 
        }
    }
}


