class Solution {
public:
    int ret; 

    void dfs1(int cur, int par, vector<vector<int>>& adjlist, string& s, vector<int>& dp) {
        // children check 
        for(int next : adjlist[cur]) {
            if(next != par) {
                dfs1(next, cur, adjlist, s, dp); 
                if(s[next] != s[cur]) // pick max path 
                    dp[cur] = max(dp[cur], dp[next]); 
            }
        }
        dp[cur]++; // include yourself 
        ret = max(ret, dp[cur]); 
    }

    void dfs2(int cur, int par, vector<vector<int>>& adjlist, string& s, vector<int>& dp) {
        // find the two biggest children that aren't close to it 
        int max1 = 0, max2 = 0; 
        for(int next : adjlist[cur]) {
            if(next != par && s[next] != s[cur]) {
                if(dp[next] > max1) {
                    max2 = max1; 
                    max1 = dp[next];
                }
                else if(dp[next] > max2) {
                    max2 = dp[next]; 
                }
            }
        }

        // check max 
        dp[cur] = max(dp[cur], max1 + max2 + 1); 
        ret = max(ret, dp[cur]); 

        // visit children 
        for(int next : adjlist[cur]) 
            if(next != par)
                dfs2(next, cur, adjlist, s, dp); 
    }

    int longestPath(vector<int>& parent, string s) {
        ret = 0; 

        // parent list can form an adjlist 
        // 2 dfs 
        // inital dfs will set up for its own subtree 
        // second dfs will be between 2 subtrees 
        // store max and previous character 
        
        // adj list 
        vector<vector<int>> adjlist = vector(parent.size(), vector(0, 0)); 
        for(int i = 1; i < parent.size(); i++) {
            adjlist[i].push_back(parent[i]); 
            adjlist[parent[i]].push_back(i); 
        }

        // dfs 1 - in its own subtree 
        vector<int> dp = vector(parent.size(), 0); 
        dfs1(0, -1, adjlist, s, dp); 

        // dfs 2 - between 2 subtrees 
        dfs2(0, -1, adjlist, s, dp); 

        return ret; 
    }
};
