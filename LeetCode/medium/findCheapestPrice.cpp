#define MAX 1000000

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        // bottom up dp 
        vector<vector<int>> dp = vector(k+2, vector(n, INT32_MAX)); 
        dp[0][src] = 0; 

        //create adjlist 
        vector<vector<pair<int,int>>> adjlist = vector(n, vector(0, pair<int,int>())); 
        for(vector<int>& f : flights) adjlist[f[0]].push_back({f[1], f[2]}); 

        // begin dp 
        for(int i = 0; i < k+1; i++) 
            for(int j = 0; j < n; j++) 
                for(pair<int,int>& n : adjlist[j]) 
                    if(dp[i][j] != INT32_MAX) 
                        dp[i+1][n.first] = min(dp[i+1][n.first], dp[i][j] + n.second);

        int ret = INT32_MAX;
        for(int i = 0; i < k+2; i++) ret = min(ret, dp[i][dst]); 
        return ret == INT32_MAX ? -1 : ret; 
    }
};
