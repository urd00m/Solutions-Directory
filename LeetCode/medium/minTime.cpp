class Solution {
public:
    int dfs(int cur, int par, vector<vector<int>>& adjlist, vector<bool>& hasApple) {
        // check children 
        int ret = 0; 

        // check children for apples 
        for(int next : adjlist[cur]) 
            if(next != par) 
                ret += dfs(next, cur, adjlist, hasApple); 

        // check if we are apple 
        if(ret == 0 && hasApple[cur] == false) return 0; 
        else return ret + (cur == 0 ? 0 : 1); // account for the edge up 
    }

    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        /* tree structure makes it easier 
           every edge traversed counts as two 
           visit a leaf node and if true return the doubled count */

        // construct adjlist 
        vector<vector<int>> adjlist = vector(n, vector(0, 0));
        for(vector<int>& edge : edges) {
            adjlist[edge[0]].push_back(edge[1]);
            adjlist[edge[1]].push_back(edge[0]);
        }

        // dfs 
        return 2 * dfs(0, -1, adjlist, hasApple);
    }
};
